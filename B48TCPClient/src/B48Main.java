import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	
	private int serverPort = 10011;
	private String serverIP = "127.0.0.1";
	
	private Socket toSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	
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
		
		startClient();
	}

	public void startClient()
	{
		display.setText("start TCP Client\n");
		
		try {
			toSocket = new Socket(serverIP, serverPort); // client�� �ڱ� ��Ʈ/IP ����
			out = new PrintWriter(toSocket.getOutputStream(), true);
			
			in = new BufferedReader(new InputStreamReader(toSocket.getInputStream()));
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Error : " + e.getMessage() + "\n");
			System.exit(1);
		}
		
		// END : 3-way handshake ��! 
		display.append("Connection OK\n");
	}
	
	public void receive() // ������ �������ִ� ���� 
	{
		// receive data.. echo data
		String fromServer;
		
		while(true)
		{
			try {
				fromServer = in.readLine();
				display.append("<< " + fromServer + "\n");
				
				if(fromServer.equals("KBStar Server Says : quit") == true)
				{
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		closeClient();
		
	}
	
	public void closeClient()
	{
		try {
			if( in != null ) // is 'in' alive?
			{
				in.close();
			}
			if( out != null )
			{
				out.close();
			}
			if (toSocket != null )
			{
				toSocket.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : �ڵ� �߰�
		if(e.getSource() == input)
		{
			// display�� input ������ append
			display.append(">>" + input.getText() + "\n");
			
			out.println(input.getText());
			
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B48Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
		frame.receive();
	}

}
