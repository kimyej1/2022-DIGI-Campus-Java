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
		
		startClient();
	}

	public void startClient()
	{
		display.setText("start TCP Client\n");
		
		try {
			toSocket = new Socket(serverIP, serverPort); // client는 자기 포트/IP 몰라
			out = new PrintWriter(toSocket.getOutputStream(), true);
			
			in = new BufferedReader(new InputStreamReader(toSocket.getInputStream()));
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Error : " + e.getMessage() + "\n");
			System.exit(1);
		}
		
		// END : 3-way handshake 끝! 
		display.append("Connection OK\n");
	}
	
	public void receive() // 데이터 수신해주는 역할 
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
		
		// EVENT 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display에 input 내용을 append
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
