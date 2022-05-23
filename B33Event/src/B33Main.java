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
	
	// ���ʿ� ��ư��..
	// �߾ӿ��� textarea..
	
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
		// 1. ���̾ƿ� ����
		this.setLayout(new BorderLayout());
		
		// 2. ���� button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		btn1 = new JButton("button 1"); // EVENT 1
		btn2 = new JButton("random color");
		btn3 = new JButton("RGB Alpha");
		
		// EVENT 2 (�̺�Ʈ ���) 
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
		display = new JTextArea(5,30); // ������ ���� �ʿ� ����, �ֳĸ� ������ Center ȥ�� �� �����ҰŴϱ�..
		
		display.setBackground(Color.yellow);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		this.add(displayPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// EVENT 3 (���� ����) 
		
		if(e.getSource() == btn1)
		{
			System.out.println("button click!");
			
			// display.setText("btn1 click!");
			display.append("btn1 click! \n");
		}
		
		if(e.getSource() == btn2)
		{
			// RGB : Red, green, blue : ���� 3����
			//			  0-255, 00-FF �̷�������
			// Color.yellow, Color(r, g, b)
			
			int r, g, b; // ���� �����ϰ� �߻���Ű����..
			r = (int)(Math.random() * 256); // 0~ 255 ������ ������
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
