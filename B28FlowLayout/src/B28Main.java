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
		
		
		// 1. �����̳� : ���̾ƿ��� ���� �����ؾ� �Ѵ�!
		this.setLayout(new FlowLayout()); // flowLayout : ������ �����ϸ� �Ʒ��� �귯��ħ 
		 
		
		// ��ư���� ��� 1
		btn1 = new JButton("Hello Button");
		
		// ��ư���� ��� 2
		btn2 = new JButton(); // ����Ʈ������ ��� 
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
