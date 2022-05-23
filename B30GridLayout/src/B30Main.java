import java.awt.Font;
import java.awt.GridLayout;

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
		this.setLayout(new GridLayout(2,0)); // flowLayout : 공간이 부족하면 아래로 흘러넘침 
		 
		Font font = new Font("serif", Font.BOLD, 30); // 폰트종류, 옵션, 사이즈 
		/*
		 * Serif : 삐침
		 * | or인데, font에서는 and
		 */
		
		// 버튼생성 방법 1
		btn1 = new JButton("Hello Button");
		btn1.setFont(font);
		
		// 버튼생성 방법 2
		btn2 = new JButton(); // 디폴트생성자 사용 
		btn2.setText("Second Button");
		
		System.out.println("btn2 = " + btn2.getText());
		
		btn3 = new JButton("3rd Button");
		btn4 = new JButton("4th Button");
		btn5 = new JButton("5th Button");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		
		
		this.setVisible(true);
	}
}

public class B30Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
