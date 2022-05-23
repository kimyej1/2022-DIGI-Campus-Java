import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

class KbFrame extends JFrame
{
	///
	private JButton btn2;
	
	public KbFrame()
	{
		this.setTitle("KBStar");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);									// 여기까지 네줄이 한세트
	}

	public KbFrame(String title)
	{
		this.setTitle(title);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Button 1");
		this.add(btn1);
		
		btn2 = new JButton("Button 2");
		this.add(btn2);
		
		Font font = new Font("Serif", Font.BOLD | Font.ITALIC, 20); // |는 원래 "or"인데, 폰트에서만 "and"
		btn2.setFont(font);
		
		this.setVisible(true);	
	}
}


public class A32Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		KbFrame frame = new KbFrame("KB* GUI");
	}

}
