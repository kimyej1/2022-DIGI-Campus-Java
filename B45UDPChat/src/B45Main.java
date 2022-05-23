import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatting
{
	private DatagramSocket socket; // UDP : User Datagram Protocol - Datagram 보면 '아~ UDP구나~'
	private DatagramPacket packet; // 데이터는 패킷단위로 주고받는다 
	private InetAddress address;   // 상대방 IP를 저장할 변수 (내꺼는 알고있으니까)
	
	private int myPort=10001; 	   // 포트번호는 항상 10000 이상으로 쓸 것 ! - 앞은 well-known protocol들이 이미 쓰고있을 가능성 큼
	private int yourPort=10002; 
	
}

class MyFrame extends JFrame implements ActionListener
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;
	private 	JPanel 		inputPanel;
		private JTextField 	input;

	private		Font		inputFont;
	private		Font		displayFont;
	
	private DatagramSocket socket; 
	private DatagramPacket packet; 
	private InetAddress address;  
	
	private int myPort=10001; 
	private int yourPort=10002; 
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		// 0. Setting Network
		try {											  // 주소 잘못입력할수도 있으니 항상 try/catch 속
			address = InetAddress.getByName("127.0.0.1"); // localhost에서 테스트하겠다 
			socket = new DatagramSocket(myPort);		  // port번호 점유해달라고 OS에 요
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		// 1. 레이아웃 정하기
		this.setLayout(new BorderLayout());
		
		// 2. 디스플레이 패널
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.yellow);
		
		// displayPanel의 컴포넌트 만들어 붙이기,,
		displayPanel.setLayout(new BorderLayout()); // 알아서 center에 붙으니까 
		
		display = new JTextArea(5,30);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER); // center은 안써도 알아서 들어가긴함 
		
		displayFont = new Font("dialog", Font.BOLD, 15);
		display.setFont(displayFont);
		display.setEditable(false);
		
		// 회색(무채색, RGB 동일한 비율)
		display.setBackground(new Color(230, 230, 230));
		
		// 3. 인풋 패널
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.blue);
		
		// inputPanel의 컴포넌트 만들어 붙이기,,
		inputPanel.setLayout(new BorderLayout());
		input = new JTextField(10); 				// EVENT 1
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		// EVENT 2 : 이벤트 등록
		input.addActionListener(this);
		
		// 4. 각 패널을 프레임에 붙이기 
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public void udpServer() {
		// server(receive 수신)
		
		while(true)	// 서버는 살아있는 한 계속 켜져있어야 해
		{
			byte[] buffer = new byte[1024]; 	// buffer = temporary memory, 2^n 형태로 만듬 
			packet = new DatagramPacket(buffer, buffer.length); // 1024byte씩 데이터 쪼개서 받음
			
			try {
				System.out.println("wait...");
				socket.receive(packet);	// receive : 대기하고있는다
				
				System.out.println("receive..."); // 데이터를 받을때까지는 출력하지 않음 
				
				display.append("KBStar << " + new String(buffer) + "\n"); // byte -> String으로 메시지 전환
				display.setCaretPosition(display.getDocument().getLength()); // 스크롤 내려가면서 계속 맨 밑으로 포커스유지 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : 코드 추가
		if(e.getSource() == input)
		{
			// 작성한 내용을 서버로 전송
			String sendMsg = input.getText();
			byte[] buffer = sendMsg.getBytes();  // string -> byte으로 메시지 전환
			
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {
				socket.send(packet);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			// display에 input 내용을 append
			display.append("나 >> " + sendMsg + "\n");
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B45Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();	// 껍데기 만들고,
		frame.udpServer();				// 서버 수신 기다리고있
	}

}
