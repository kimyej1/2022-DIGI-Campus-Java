import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatFrame extends JFrame implements ActionListener
{
	private JPanel chatPanel, setupPanel;
	private JTextArea display;
	private JTextField input, ip, port, myName, yourName;
	private JLabel inputL, ipL, portL, myL, yourL;
	private JButton clear, play;
	private JScrollPane scroll;
	
	
	public ChatFrame()
	{	
		this.setTitle("KB Chat");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		Font font1 = new Font("Gothic", Font.BOLD, 15);
		
		chatPanel = new JPanel();
		setupPanel = new JPanel();
		
		chatPanel.setLayout(new BorderLayout());
		setupPanel.setLayout(new GridLayout(0,2, 10,10));
		
		display = new JTextArea(10,30);
		input = new JTextField(10);
		scroll = new JScrollPane(display);
		
		display.setEnabled(false);
		input.setEnabled(false);		
		input.addActionListener(this);
		display.setDisabledTextColor(Color.black);
		
		ipL = new JLabel("IP");
		portL = new JLabel("port");
		myL = new JLabel("내이름");
		yourL = new JLabel("상대방");
		
		ipL.setHorizontalAlignment(JLabel.CENTER);
		portL.setHorizontalAlignment(JLabel.CENTER);
		myL.setHorizontalAlignment(JLabel.CENTER);
		yourL.setHorizontalAlignment(JLabel.CENTER);
		
		ipL.setFont(font1);
		portL.setFont(font1);
		myL.setFont(font1);
		yourL.setFont(font1);
		
		ip = new JTextField();
		port = new JTextField();
		myName = new JTextField();
		yourName = new JTextField();
		
		clear = new JButton();
		play = new JButton();
		clear.addActionListener(this);
		play.addActionListener(this);
		clear.setFont(font1);
		play.setFont(font1);
		
		clear.setText("초기화");
		play.setText("완료");
		clear.setBackground(Color.yellow);
		play.setBackground(Color.orange);
		
		setupPanel.add(ipL);
		setupPanel.add(ip);
		setupPanel.add(portL);
		setupPanel.add(port);
		setupPanel.add(myL);
		setupPanel.add(myName);
		setupPanel.add(yourL);
		setupPanel.add(yourName);
		setupPanel.add(clear);
		setupPanel.add(play);
		
		chatPanel.add(scroll, BorderLayout.CENTER);
		chatPanel.add(input, BorderLayout.SOUTH);
		chatPanel.setBackground(Color.YELLOW);
		

		this.add(chatPanel, BorderLayout.CENTER);
		this.add(setupPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == clear)
		{
			ip.setText("");
			port.setText("");
			myName.setText("");
			yourName.setText("");
		} else if(e.getSource() == play)
		{
			//this.remove(setupPanel);
			//this.remove(chatPanel);
			
			this.add(chatPanel, BorderLayout.CENTER);
			setupPanel.setVisible(false);
			chatPanel.setVisible(true);
			// System.out.println("CP 0 : " + display.getText());
			display.setText(" ---- " + myName.getText() + " 님이 입장하셨습니다. ----" + "\n");
			// System.out.println("CP 1 : " + display.getText());
			input.setEnabled(true);
			
		} else if(e.getSource() == input);
		{
			if(input.getText().equals("") == false)
			{
				display.append(myName.getText() + " > " + input.getText() + "\n");
				input.setText("");
			}
		}
	}	
}


public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		ChatFrame chat = new ChatFrame();
		
	}
}

