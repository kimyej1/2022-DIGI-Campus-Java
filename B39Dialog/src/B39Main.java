import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener
{
	private JButton eventButton; // eventListener������ ���� �� �ֵ��� �ۿ� ���� 
	MyDialog dialog;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		dialog = new MyDialog(this, "Dialog Title"); // �ؿ� �����ڿ� MyDialog(Frame, title) �̷��� ���� 
		
		this.setLayout(new FlowLayout());
		eventButton = new JButton("Event Button"); // EVENT 1 : ��ü ���� 
		eventButton.addActionListener(this); // EVENT 2 : �̺�Ʈ ���
		this.add(eventButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == eventButton)
		{
			// dialog - ȭ�鿡 �������ִ��� �׳� ����ִ°� : �ֳĸ� �ؿ� MyDialog �� ��������, MyFrame���� �ٿ������ϱ� 
			dialog.setVisible(true);
			
		}
	}
}

class MyDialog extends JDialog implements ActionListener
{
	// ____����� �̸�____  [��ư] -> �θ𿡰� �̸� ���� 

	private JTextField name;
	private JButton okBtn;
	
	public MyDialog(JFrame frame, String title) // copy constructor
	{
		super(frame, title); // super : ���� �θ�(JDialog)�� �����ڸ� ȣ�� 
		
		this.setLayout(new FlowLayout());
		
		name = new JTextField(10);
		okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		
		this.add(name);
		this.add(okBtn);
		
		this.setSize(400,300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBtn)
		{
			this.setVisible(false);
		}
	}
}

public class B39Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
