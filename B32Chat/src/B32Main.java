import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;
	private 	JPanel 		inputPanel;
		private JTextField 	input;

	private		Font		inputFont;
	private		Font		displayFont;
	
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
		
		// 3. 인풋 패널
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.blue);
		
		// inputPanel의 컴포넌트 만들어 붙이기,,
		inputPanel.setLayout(new BorderLayout());
		input = new JTextField(10);
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		// 4. 각 패널을 프레임에 붙이기 
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}

public class B32Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
