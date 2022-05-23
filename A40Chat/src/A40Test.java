import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatFrame extends JFrame implements ActionListener
{
	private JTextArea display;
	private JTextField input;
	private JScrollPane scroll;
	
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress address = null;
	
	private int myPort = 10000;
	private int yourPort = 20000;	// 두번째 테스트할땐 my를 10000, your를 10001로 바꿔서 해보기
	
	public ChatFrame()
	{
		this.setTitle("KB Messenger");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Network 설정
		try {
			address = InetAddress.getByName("127.0.0.1"); // Unhandled Exception -> try/catch 넣어라
			socket = new DatagramSocket(myPort);		  // 소켓 이거 쓸거라고 등록
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		// 0. 컨테이너는 레이아웃을 결정했는가?
		this.setLayout(new BorderLayout());
		display = new JTextArea(10,30);
		
		
		// 스크롤페인에 display를 넣음
		scroll = new JScrollPane(display);
		
		input = new JTextField(30);
		input.addActionListener(this);
		
		// display가 스크롤페인에 붙었으니까 프레임에 display 대신 스크롤페인 붙임
		this.add(scroll, BorderLayout.CENTER); 
		this.add(input, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void process() // 호출해서 쓸 메소드 만들기
	{
		while(true)
		{
			try {								// 통신하다 에러나면 죽지말고 알려줘~
				byte[] buffer = new byte[1024]; // 한번에 받는 데이터 크기 제한(1024짜리 바이트 타입으로 주고받을거야)
				packet = new DatagramPacket(buffer, buffer.length); // UDP로 데이터 받는데, 받을때마다 버퍼에다가 넣을게, 버퍼 대기할게!
				socket.receive(packet); 		// 패킷단위로 받아 -> 소켓에
				
				display.append("Python > " + new String(buffer) + "\n"); // 받은 내용(버퍼)은 byte타입이니까 문자열로 바꿔서 보여줘~
				display.setCaretPosition(display.getDocument().getLength());
			} catch (Exception e) {
				
				// TODO: handle exception
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	// TODO Auto-generated method stub
		
		if(e.getSource() == input)
		{
			String msg = input.getText();
			
			byte[] buffer =  msg.getBytes();	// 보낼 내용(msg)을 byte로 바꿔야 보낼 수 있음
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {								// 에러날 수도 있으니까 try/catch로
				socket.send(packet);
			} catch (Exception e2) {
				// TODO: handle exception
				
				System.out.println(e2.getMessage());
			}
					
			display.append("Java > " + msg + "\n");
			display.setCaretPosition(display.getDocument().getLength());
			input.selectAll();
		}
	}
	
}

public class A40Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		ChatFrame frame = new ChatFrame();
		frame.process(); // 위 메소드 호출해서 무한루프 돌면서 받으면 뿌려주고, 받으면 뿌려주고
		
	}

}
