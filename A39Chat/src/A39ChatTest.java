import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// textarea, input받아서 엔터치면 올라가게, borderLayout - 센터에 textarea

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
		
		
		// 0. 컨테이너는 레이아웃을 결정했는가?
		this.setLayout(new BorderLayout());
		display = new JTextArea(10,30);
		
		// 스크롤페인에 display를 넣음
		scroll = new JScrollPane(display);
		
		input = new JTextField(30);
		input.addActionListener(this);
		
		// display가 스크롤페인에 붙었으니까 프레임에 display 대신 스크롤페인 붙임
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
