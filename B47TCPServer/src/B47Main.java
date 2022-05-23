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
		
		startServer();	// 일단 위에 화면구성 다 만들고 서버 시작해~ 
		
	}
	
	public void startServer()
	{
		// socket setting : receive --> print --> answer
		
		// TCP : Transmission Control Protocol  --> Datagram : UDP, ServerSocket : TCP
		ServerSocket serverSocket = null;
		display.setText("Start TCP Server .. \n");
		
		try {	// 포트번호 누가 쓰고있어서 실패할수도 있으니 try-catch 사용 
			serverSocket = new ServerSocket(port);
			display.append("Create Server Socket # : " + port + "\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Cannot Open Port # : " + port + "\n");
		}
		
		// 클라이언트가 접속하면, 접속 정보를 확인하기 위해 만든 객체 
		Socket clientSocket = null;
		
		try {
			clientSocket = serverSocket.accept();	// 3-way handshaking
			display.append("Accepted ..\n");
			display.append(("Client INFO : " + clientSocket.getRemoteSocketAddress().toString() 
							+ " : " + clientSocket.getPort() + "\n"));	// 127.0.0.1:8080 이런식으로 표기 
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Accept Error\n");
		}
		
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			display.append("Create PrintWriter\n");
			
			// ClientSocket으로 받은 데이터를 buffer단위로 처리해줘~ 
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			display.append("Create BufferedReader Done\n");
			
			String inputLine, outputLine;
			
			/*
			 * Client ------ data(Hello) -----> Server
			 * Client <----- data(Hello) ------ Server ("Echo Server" : 테스트를 위해 받은 데이터 그대로 메아리 
			 */
			
			while((inputLine = in.readLine()) != null)
			{
				display.append("RCV Data\n <<" + inputLine + "\n"); // 받은 메시지 그대로 출력 
				outputLine = "KBStar Server Says : " + inputLine; // echo server
				out.println(outputLine);
				display.append(">> " + outputLine + "\n");
				
				if(inputLine.equals("quit")) // quit 라는 메시지를 받으면,
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
		
		// EVENT 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display에 input 내용을 append
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
