import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame
{
	private JButton btn1;
	private JButton btn2;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		
		// 1. 컨테이너 : 레이아웃을 먼저 결정해야 한다!
		this.setLayout(new FlowLayout()); // flowLayout : 공간이 부족하면 아래로 흘러넘침 
		 
		
		// 버튼생성 방법 1
		btn1 = new JButton("Hello Button");
		
		// 버튼생성 방법 2
		btn2 = new JButton(); // 디폴트생성자 사용 
		btn2.setText("Second Button");
		
		this.add(btn1);
		this.add(btn2);
		
		
		this.setVisible(true);
	}
}

public class B28Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
