import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame
{
	private JPanel displayPanel; // �̸��� ���� 
	private JPanel buttonPanel;
	
	private JButton button;
	private JTextField input;
	private JTextArea memo;
	private JScrollPane scroll;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		// 1. ���̾ƿ��� �����Ѵ�.
		this.setLayout(new BorderLayout());
		
		displayPanel = new JPanel(); // �̸��� �ִ� ���´ϱ�, ��ü ���� 
		displayPanel.setLayout(new FlowLayout());
		displayPanel.setBackground(Color.yellow);
		
		button = new JButton("Button Test");
		displayPanel.add(button);
		input = new JTextField(10);
		displayPanel.add(input);
		input.setText("ȫ�浿");
		input.setFont(new Font("serif", Font.BOLD, 20));
		input.setHorizontalAlignment(JTextField.RIGHT);
		
		memo = new JTextArea(5,30);
		scroll = new JScrollPane(memo);
		displayPanel.add(scroll); // ��ũ�� �ȿ� �޸� �ְ�, ��ũ���� �гο� �ٿ� (�ڵ���ũ�� �����) 
		
		this.add(displayPanel);
		
		this.setVisible(true);
	}
}

public class B31Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
