import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		createToolBar();
		
		this.setVisible(true);
	}
	
	public void createToolBar()
	{
		JToolBar toolBar = new JToolBar("ToolBar Menu Test");
		Color color = new Color(240, 240, 240); // light gray
		toolBar.setBackground(color);			// Color.LIGHT_GRAY �̷������� �ƿ� ���⿡ �ᵵ �� 
		toolBar.add(new JButton("New"));
//		toolBar.add(new JButton(new ImageIcon("image/unnamed.png"))); // �̹��������� ��ư 
		toolBar.add(new JButton("Save"));
		
		toolBar.addSeparator(); // ���м�
		toolBar.add(new JLabel("�˻�� �Է��ϼ���."));
		toolBar.add(new JTextField("Keyword"));
		
		this.add(toolBar, BorderLayout.NORTH);
	}
}

public class B38Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
