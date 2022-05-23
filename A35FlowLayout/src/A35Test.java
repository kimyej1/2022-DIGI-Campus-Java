import java.awt.FlowLayout;
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
		panel.setLayout(new FlowLayout()); // flow layout : ���������� �����鼭 â �۾����� ������ �귯��ħ
		// align�� �ʿ��ϸ� ����ٰ� ��: hgap, vgap ��
		// panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btn = new JButton("test");		
		btn1 = new JButton("Button 1");
		btn2 = new JButton("Button 2");
		btn3 = new JButton("Button 3");
		btn4 = new JButton("Button 4");
		btn5 = new JButton("Button 5");
		
		btn.addActionListener(this);
		
		panel.add(btn);	
		panel.add(btn1);		
		panel.add(btn2);	
		
		this.add(panel);
		this.pack();	// ���� �� ����� �� �°� â ũ�� ���� - packing
		
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


public class A35Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		KbFrame frame = new KbFrame("KB* GUI");
	}

}
