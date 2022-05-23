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
	private DatagramSocket socket; // UDP : User Datagram Protocol - Datagram ���� '��~ UDP����~'
	private DatagramPacket packet; // �����ʹ� ��Ŷ������ �ְ�޴´� 
	private InetAddress address;   // ���� IP�� ������ ���� (������ �˰������ϱ�)
	
	private int myPort=10001; 	   // ��Ʈ��ȣ�� �׻� 10000 �̻����� �� �� ! - ���� well-known protocol���� �̹� �������� ���ɼ� ŭ
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
		try {											  // �ּ� �߸��Է��Ҽ��� ������ �׻� try/catch ��
			address = InetAddress.getByName("127.0.0.1"); // localhost���� �׽�Ʈ�ϰڴ� 
			socket = new DatagramSocket(myPort);		  // port��ȣ �����ش޶�� OS�� ��
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		// 1. ���̾ƿ� ���ϱ�
		this.setLayout(new BorderLayout());
		
		// 2. ���÷��� �г�
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.yellow);
		
		// displayPanel�� ������Ʈ ����� ���̱�,,
		displayPanel.setLayout(new BorderLayout()); // �˾Ƽ� center�� �����ϱ� 
		
		display = new JTextArea(5,30);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER); // center�� �Ƚᵵ �˾Ƽ� ������ 
		
		displayFont = new Font("dialog", Font.BOLD, 15);
		display.setFont(displayFont);
		display.setEditable(false);
		
		// ȸ��(��ä��, RGB ������ ����)
		display.setBackground(new Color(230, 230, 230));
		
		// 3. ��ǲ �г�
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.blue);
		
		// inputPanel�� ������Ʈ ����� ���̱�,,
		inputPanel.setLayout(new BorderLayout());
		input = new JTextField(10); 				// EVENT 1
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		// EVENT 2 : �̺�Ʈ ���
		input.addActionListener(this);
		
		// 4. �� �г��� �����ӿ� ���̱� 
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public void udpServer() {
		// server(receive ����)
		
		while(true)	// ������ ����ִ� �� ��� �����־�� ��
		{
			byte[] buffer = new byte[1024]; 	// buffer = temporary memory, 2^n ���·� ���� 
			packet = new DatagramPacket(buffer, buffer.length); // 1024byte�� ������ �ɰ��� ����
			
			try {
				System.out.println("wait...");
				socket.receive(packet);	// receive : ����ϰ��ִ´�
				
				System.out.println("receive..."); // �����͸� ������������ ������� ���� 
				
				display.append("KBStar << " + new String(buffer) + "\n"); // byte -> String���� �޽��� ��ȯ
				display.setCaretPosition(display.getDocument().getLength()); // ��ũ�� �������鼭 ��� �� ������ ��Ŀ������ 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : �ڵ� �߰�
		if(e.getSource() == input)
		{
			// �ۼ��� ������ ������ ����
			String sendMsg = input.getText();
			byte[] buffer = sendMsg.getBytes();  // string -> byte���� �޽��� ��ȯ
			
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {
				socket.send(packet);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			// display�� input ������ append
			display.append("�� >> " + sendMsg + "\n");
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B45Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();	// ������ �����,
		frame.udpServer();				// ���� ���� ��ٸ�����
	}

}
