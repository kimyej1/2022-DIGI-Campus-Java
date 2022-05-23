import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame
{
	private JPanel displayPanel; // 이름만 만듬 
	private JPanel buttonPanel;
	
	private JButton button;
	private JTextField input;
	private JTextArea memo;
	private JScrollPane scroll;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		// 1. 레이아웃을 결정한다.
		this.setLayout(new BorderLayout());
		
		displayPanel = new JPanel(); // 이름만 있는 상태니까, 객체 생성 
		displayPanel.setLayout(new FlowLayout());
		displayPanel.setBackground(Color.yellow);
		
		button = new JButton("Button Test");
		displayPanel.add(button);
		input = new JTextField(10);
		displayPanel.add(input);
		input.setText("홍길동");
		input.setFont(new Font("serif", Font.BOLD, 20));
		input.setHorizontalAlignment(JTextField.RIGHT);
		
		memo = new JTextArea(5,30);
		scroll = new JScrollPane(memo);
		displayPanel.add(scroll); // 스크롤 안에 메모 넣고, 스크롤을 패널에 붙여 (자동스크롤 만들기) 
		
		this.add(displayPanel);
		
		this.setVisible(true);
	}
}

public class B31Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
