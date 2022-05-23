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
		this.setVisible(true);									// ������� ������ �Ѽ�Ʈ
	}

	public KbFrame(String title)
	{
		this.setTitle(title);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		btn = new JButton("Button");
		btn.addActionListener(this); // �̺�Ʈ �˻�����
		
		panel.add(btn);		
		this.add(panel);
		
		this.setVisible(true);	
	}	

	@Override
	public void actionPerformed(ActionEvent e) { // �������� e�� Ÿ�� ��(�� ������ �Դ���,...)
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
