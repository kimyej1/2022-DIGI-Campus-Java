import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener
{
	private JButton eventButton; // eventListener에서도 읽을 수 있도록 밖에 선언 
	MyDialog dialog;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		dialog = new MyDialog(this, "Dialog Title"); // 밑에 생성자에 MyDialog(Frame, title) 이렇게 만듬 
		
		this.setLayout(new FlowLayout());
		eventButton = new JButton("Event Button"); // EVENT 1 : 객체 선언 
		eventButton.addActionListener(this); // EVENT 2 : 이벤트 등록
		this.add(eventButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == eventButton)
		{
			// dialog - 화면에 가려져있던걸 그냥 띄워주는것 : 왜냐면 밑에 MyDialog 다 만들어놨고, MyFrame에도 붙여놨으니까 
			dialog.setVisible(true);
			
		}
	}
}

class MyDialog extends JDialog implements ActionListener
{
	// ____당신의 이름____  [버튼] -> 부모에게 이름 전달 

	private JTextField name;
	private JButton okBtn;
	
	public MyDialog(JFrame frame, String title) // copy constructor
	{
		super(frame, title); // super : 나의 부모(JDialog)의 생성자를 호출 
		
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
