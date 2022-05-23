import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class KbFrame extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private JButton btn;
	
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
		
		panel = new JPanel();
		btn = new JButton("Button");
		btn.addActionListener(this); // 이벤트 검사해줘
		
		panel.add(btn);		
		this.add(panel);
		
		this.setVisible(true);	
	}	

	@Override
	public void actionPerformed(ActionEvent e) { // 정보들이 e를 타고 옴(뭐 눌러서 왔는지,...)
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn)
		{
			btn.setText("Hello Button");
		}
	}
}


public class A34Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		KbFrame frame = new KbFrame("KB* GUI");
	}

}
