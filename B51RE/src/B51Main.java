import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;
	private 	JPanel 		inputPanel;
		private JTextField 	input;

	private		Font		inputFont;
	private		Font		displayFont;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		// 1. ���̾ƿ� ���ϱ�
		this.setLayout(new BorderLayout());
		
		// 2. ���÷��� �г�
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.yellow);
		
		// displayPanel�� ������Ʈ ����� ���̱�,,
		displayPanel.setLayout(new BorderLayout()); // �˾Ƽ� center�� �����ϱ� 
		
		display = new JTextArea(5,30);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER); // center�� �Ƚᵵ �˾Ƽ� ������ 
		
		displayFont = new Font("dialog", Font.BOLD, 15);
		display.setFont(displayFont);
		display.setEditable(false);
		
		// ȸ��(��ä��, RGB ������ ����)
		display.setBackground(new Color(230, 230, 230));
		
		// 3. ��ǲ �г�
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.blue);
		
		// inputPanel�� ������Ʈ ����� ���̱�,,
		inputPanel.setLayout(new BorderLayout());
		input = new JTextField(10); 				// EVENT 1
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		// EVENT 2 : �̺�Ʈ ���
		input.addActionListener(this);
		
		// 4. �� �г��� �����ӿ� ���̱� 
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : �ڵ� �߰�
		if(e.getSource() == input)
		{
			// display�� input ������ append
			
			String regex = "^010-[0-9]{4}-\\d{4}$";	// \�� ��¥ \���� ���ַ��� \\
		
			if(Pattern.matches(regex, input.getText()) == false)
			{
				// Error
			} else
			{
				display.append("\nMobile #");
			}
			
			display.append("\n" + input.getText());
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B51Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
