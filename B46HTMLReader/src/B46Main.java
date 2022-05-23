import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JComboBox;
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
	
	String[] charset = {"UTF-8", "EUC-KR"};
	JComboBox charsetList;				// ComboBox : Select
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(800,500);
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
		
		// charset 고르게 하기
		charsetList = new JComboBox(charset);
		charsetList.setSize(100,30);
		inputPanel.add(charsetList, BorderLayout.WEST);
		
		// EVENT 2 : 이벤트 등록
		input.addActionListener(this);
		
		// 4. 각 패널을 프레임에 붙이기 
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display에 input 내용을 append
//			display.append("\n" + input.getText());
			display.setText("");
			
			try {
				URL url = new URL(input.getText());				   // input에 입력된걸 URL로 사용 
				String cs = (String)charsetList.getSelectedItem(); // charset combo box 고른거 읽어옴 
				BufferedReader in = new BufferedReader(
										new InputStreamReader(url.openStream(), cs)
									);
				
				String line;	// 데이터 가져오면 한줄씩 출력하게 하려고
				int count = 0;	// editor처럼 몇번째 라인인지 표시해보자 
				String lineCount = "";
				
				while( (line=in.readLine()) != null ) // 읽을게 없을때까지 계속 읽어라 
				{
					count++;
					lineCount = lineCount.format("%05d : ", count); // 이걸 안넣으면 숫자 자릿수가 바뀔때 밀려서 줄맞춤 이상해짐 
					display.append(lineCount + line + "\n"); 
				}
				
				try {
					if(in != null)	// BufferedReader in 열려있으면, 닫아줘 
					{
						in.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B46Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
