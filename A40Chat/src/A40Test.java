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
	private int yourPort = 20000;	// �ι�° �׽�Ʈ�Ҷ� my�� 10000, your�� 10001�� �ٲ㼭 �غ���
	
	public ChatFrame()
	{
		this.setTitle("KB Messenger");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Network ����
		try {
			address = InetAddress.getByName("127.0.0.1"); // Unhandled Exception -> try/catch �־��
			socket = new DatagramSocket(myPort);		  // ���� �̰� ���Ŷ�� ���
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		// 0. �����̳ʴ� ���̾ƿ��� �����ߴ°�?
		this.setLayout(new BorderLayout());
		display = new JTextArea(10,30);
		
		
		// ��ũ�����ο� display�� ����
		scroll = new JScrollPane(display);
		
		input = new JTextField(30);
		input.addActionListener(this);
		
		// display�� ��ũ�����ο� �پ����ϱ� �����ӿ� display ��� ��ũ������ ����
		this.add(scroll, BorderLayout.CENTER); 
		this.add(input, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void process() // ȣ���ؼ� �� �޼ҵ� �����
	{
		while(true)
		{
			try {								// ����ϴ� �������� �������� �˷���~
				byte[] buffer = new byte[1024]; // �ѹ��� �޴� ������ ũ�� ����(1024¥�� ����Ʈ Ÿ������ �ְ�����ž�)
				packet = new DatagramPacket(buffer, buffer.length); // UDP�� ������ �޴µ�, ���������� ���ۿ��ٰ� ������, ���� ����Ұ�!
				socket.receive(packet); 		// ��Ŷ������ �޾� -> ���Ͽ�
				
				display.append("Python > " + new String(buffer) + "\n"); // ���� ����(����)�� byteŸ���̴ϱ� ���ڿ��� �ٲ㼭 ������~
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
			
			byte[] buffer =  msg.getBytes();	// ���� ����(msg)�� byte�� �ٲ�� ���� �� ����
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {								// ������ ���� �����ϱ� try/catch��
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
		frame.process(); // �� �޼ҵ� ȣ���ؼ� ���ѷ��� ���鼭 ������ �ѷ��ְ�, ������ �ѷ��ְ�
		
	}

}
