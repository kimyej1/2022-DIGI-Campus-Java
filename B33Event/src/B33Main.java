import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyFrame extends JFrame implements ActionListener
{
	
	// 북쪽에 버튼들..
	// 중앙에는 textarea..
	
	private JPanel buttonPanel;
		private JButton btn1, btn2, btn3;
	private JPanel displayPanel;
		private JScrollPane scroll;
		private JTextArea display;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		// 1. 레이아웃 결정
		this.setLayout(new BorderLayout());
		
		// 2. 북쪽 button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		btn1 = new JButton("button 1"); // EVENT 1
		btn2 = new JButton("random color");
		btn3 = new JButton("RGB Alpha");
		
		// EVENT 2 (이벤트 등록) 
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		buttonPanel.add(btn3);
		
		this.add(buttonPanel, BorderLayout.NORTH);
		
		// 3. center display panel
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		display = new JTextArea(5,30); // 사이즈 정할 필요 없음, 왜냐면 어차피 Center 혼자 다 차지할거니까..
		
		display.setBackground(Color.yellow);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		this.add(displayPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// EVENT 3 (동작 정의) 
		
		if(e.getSource() == btn1)
		{
			System.out.println("button click!");
			
			// display.setText("btn1 click!");
			display.append("btn1 click! \n");
		}
		
		if(e.getSource() == btn2)
		{
			// RGB : Red, green, blue : 빛의 3원색
			//			  0-255, 00-FF 이런식으루
			// Color.yellow, Color(r, g, b)
			
			int r, g, b; // 각각 랜덤하게 발생시키려고..
			r = (int)(Math.random() * 256); // 0~ 255 사이의 랜덤값
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
			
			Color color = new Color(r, g, b);
			display.setBackground(color);
			display.append("RGB : " + r + ", " + g + ", " + b + "\n");
		}
		
		if(e.getSource() == btn3)
		{
			int r, g, b, alpha;
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
			alpha = (int)(Math.random() * 256);
			
			Color color = new Color(r, g, b, alpha);
			display.setBackground(color);
			display.append("RGB : " + r + ", " + g + ", " + b + ", " + alpha + "\n");
		}
		
	}
	
	
}

public class B33Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
