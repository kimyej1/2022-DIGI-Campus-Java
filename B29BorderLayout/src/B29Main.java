import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame
{
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		
		// 1. 컨테이너 : 레이아웃을 먼저 결정해야 한다!
		this.setLayout(new BorderLayout()); // flowLayout : 공간이 부족하면 아래로 흘러넘침 
		 
		
		// 버튼생성 방법 1
		btn1 = new JButton("Hello Button");
		
		// 버튼생성 방법 2
		btn2 = new JButton(); // 디폴트생성자 사용 
		btn2.setText("Second Button");
		
		btn3 = new JButton("3rd Button");
		btn4 = new JButton("4th Button");
		btn5 = new JButton("5th Button");
		
		this.add(btn1, BorderLayout.CENTER);
		this.add(btn2, BorderLayout.NORTH);
		this.add(btn3, BorderLayout.WEST);
		this.add(btn4, BorderLayout.EAST);
		this.add(btn5, BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
}

public class B29Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
