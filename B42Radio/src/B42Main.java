import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/*
 * <input type = "radio" name = "gender" value = "1"> ����
 * <input type = "radio" name = "gender" value = "2"> ����
 * �̷��� name���� grouping�ؼ� name���� value �ϳ����� ������ �� �ְ� ������� "Radio Button"
 */

class MyFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	
	private JRadioButton tcp;
	private JRadioButton udp;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		this.setLayout(new BorderLayout()); // frame default : border layout
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout()); // panel default : flow layout
		
		this.add(panel);
		
		ButtonGroup protocol = new ButtonGroup();
		tcp = new JRadioButton("TCP");
		udp = new JRadioButton("UDP");
		
		protocol.add(tcp);
		protocol.add(udp);
		
		tcp.addActionListener(this);
		udp.addActionListener(this);
		
		tcp.setSelected(true); // checked
		
		Border border = BorderFactory.createTitledBorder("PROTOCOL"); // �׵θ� ����� 
		
		panel.setBorder(border); // panel�� �׵θ��� �ѷ��� (������ �׷����ϱ� ����.. �г��� �������� �Ҷ�..) 
		panel.add(tcp);
		panel.add(udp);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == tcp)
		{
			System.out.println("tcp checked");
		}
		
		if(e.getSource() == udp)
		{
			System.out.println("udp checked : ");
		}
	}

	
}

public class B42Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
