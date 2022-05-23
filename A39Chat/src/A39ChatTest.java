import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// textarea, input�޾Ƽ� ����ġ�� �ö󰡰�, borderLayout - ���Ϳ� textarea

class ChatFrame extends JFrame implements ActionListener
{
	private JTextArea display;
	private JTextField input;
	private JScrollPane scroll;
	
	public ChatFrame()
	{
		this.setTitle("KB* Chat");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// 0. �����̳ʴ� ���̾ƿ��� �����ߴ°�?
		this.setLayout(new BorderLayout());
		display = new JTextArea(10,30);
		
		// ��ũ�����ο� display�� ����
		scroll = new JScrollPane(display);
		
		input = new JTextField(30);
		input.addActionListener(this);
		
		// display�� ��ũ�����ο� �پ����ϱ� �����ӿ� display ��� ��ũ������ ����
		this.add(scroll, BorderLayout.CENTER); 
		this.add(input, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	// TODO Auto-generated method stub
		
		if(e.getSource() == input)
		{
			String msg = input.getText();
			display.append(msg + "\n");
			input.selectAll();
		}
	}
	
}

public class A39ChatTest 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		ChatFrame frame = new ChatFrame();
		
	}

}
