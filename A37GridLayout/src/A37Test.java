import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class KbFrame extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private JButton btn;
	private JButton btn1, btn2, btn3, btn4, btn5;	
	private JButton[] btns; // array�� ������ �ѹ��� �����
	
	public KbFrame()
	{
		this.setTitle("KBStar");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public KbFrame(String title)
	{
		this.setTitle(title);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,3)); // Grid Layout(����, �)
		
		btn = new JButton("test");		
		btn.addActionListener(this);
		
		btns = new JButton[10]; // 10���� �޸� ������ ����(��ư 10���� ���� �ȸ���)
		
		for(int i = 0; i < btns.length; i++) 
		{
			btns[i] = new JButton("Button " + i);	// 10�� �޸𸮿� �����ڷ� ��ư �����
			panel.add(btns[i]);						// ��ư ���鶧���� �гο� �ٿ�
		}
				
		this.add(panel);
		this.setVisible(true);	
	}	

	@Override
	public void actionPerformed(ActionEvent e) { 
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn) 
		{
			if(btn.getText().equals("Hello Button")) 
			{
				btn.setText("Hello Button");
			} else
			{
				btn.setText("Button");	
			}
		}
	}
}


public class A37Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		KbFrame frame = new KbFrame("KB* GUI");
	}

}
