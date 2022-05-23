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
		toolBar.setBackground(color);			// Color.LIGHT_GRAY 이런식으로 아예 여기에 써도 됨 
		toolBar.add(new JButton("New"));
//		toolBar.add(new JButton(new ImageIcon("image/unnamed.png"))); // 이미지아이콘 버튼 
		toolBar.add(new JButton("Save"));
		
		toolBar.addSeparator(); // 구분선
		toolBar.add(new JLabel("검색어를 입력하세요."));
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
