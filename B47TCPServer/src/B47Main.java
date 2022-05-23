import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;
	private 	JPanel 		inputPanel;
		private JTextField 	input;

	private		Font		inputFont;
	private		Font		displayFont;
	
	private int port = 10011;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
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
		
		startServer();	// �ϴ� ���� ȭ�鱸�� �� ����� ���� ������~ 
		
	}
	
	public void startServer()
	{
		// socket setting : receive --> print --> answer
		
		// TCP : Transmission Control Protocol  --> Datagram : UDP, ServerSocket : TCP
		ServerSocket serverSocket = null;
		display.setText("Start TCP Server .. \n");
		
		try {	// ��Ʈ��ȣ ���� �����־ �����Ҽ��� ������ try-catch ��� 
			serverSocket = new ServerSocket(port);
			display.append("Create Server Socket # : " + port + "\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Cannot Open Port # : " + port + "\n");
		}
		
		// Ŭ���̾�Ʈ�� �����ϸ�, ���� ������ Ȯ���ϱ� ���� ���� ��ü 
		Socket clientSocket = null;
		
		try {
			clientSocket = serverSocket.accept();	// 3-way handshaking
			display.append("Accepted ..\n");
			display.append(("Client INFO : " + clientSocket.getRemoteSocketAddress().toString() 
							+ " : " + clientSocket.getPort() + "\n"));	// 127.0.0.1:8080 �̷������� ǥ�� 
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Accept Error\n");
		}
		
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			display.append("Create PrintWriter\n");
			
			// ClientSocket���� ���� �����͸� buffer������ ó������~ 
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			display.append("Create BufferedReader Done\n");
			
			String inputLine, outputLine;
			
			/*
			 * Client ------ data(Hello) -----> Server
			 * Client <----- data(Hello) ------ Server ("Echo Server" : �׽�Ʈ�� ���� ���� ������ �״�� �޾Ƹ� 
			 */
			
			while((inputLine = in.readLine()) != null)
			{
				display.append("RCV Data\n <<" + inputLine + "\n"); // ���� �޽��� �״�� ��� 
				outputLine = "KBStar Server Says : " + inputLine; // echo server
				out.println(outputLine);
				display.append(">> " + outputLine + "\n");
				
				if(inputLine.equals("quit")) // quit ��� �޽����� ������,
				{
					break;
				}
			}
			
			// closing sockets
			if(out != null)
			{
				out.close();
			}
			if(in != null)
			{
				in.close();
			}
			if(clientSocket != null)
			{
				clientSocket.close();
			}
			if(serverSocket != null)
			{
				serverSocket.close();
			}
			
			display.append("Resources are all closed\n");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Error : " + e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : �ڵ� �߰�
		if(e.getSource() == input)
		{
			// display�� input ������ append
			display.append("\n" + input.getText());
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B47Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
