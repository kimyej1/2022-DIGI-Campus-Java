import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JComboBox;
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
	
	String[] charset = {"UTF-8", "EUC-KR"};
	JComboBox charsetList;				// ComboBox : Select
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(800,500);
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
		
		// charset ���� �ϱ�
		charsetList = new JComboBox(charset);
		charsetList.setSize(100,30);
		inputPanel.add(charsetList, BorderLayout.WEST);
		
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
//			display.append("\n" + input.getText());
			display.setText("");
			
			try {
				URL url = new URL(input.getText());				   // input�� �ԷµȰ� URL�� ��� 
				String cs = (String)charsetList.getSelectedItem(); // charset combo box ���� �о�� 
				BufferedReader in = new BufferedReader(
										new InputStreamReader(url.openStream(), cs)
									);
				
				String line;	// ������ �������� ���پ� ����ϰ� �Ϸ���
				int count = 0;	// editoró�� ���° �������� ǥ���غ��� 
				String lineCount = "";
				
				while( (line=in.readLine()) != null ) // ������ ���������� ��� �о�� 
				{
					count++;
					lineCount = lineCount.format("%05d : ", count); // �̰� �ȳ����� ���� �ڸ����� �ٲ� �з��� �ٸ��� �̻����� 
					display.append(lineCount + line + "\n"); 
				}
				
				try {
					if(in != null)	// BufferedReader in ����������, �ݾ��� 
					{
						in.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
			
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}
	
}

public class B46Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
