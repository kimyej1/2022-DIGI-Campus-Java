import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener, MouseListener, KeyListener
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
		
		// mouse Event ��� 
		display.addMouseListener(this);
		
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
		input.addActionListener(this); // ���������� �̺�Ʈ �߻� 
		input.addKeyListener(this); // Ű �ϳ��ϳ��� �̺�Ʈ �߻� 
		
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
			display.append("\n" + input.getText());
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX(); // ���콺 ��ġ : x ��ǥ 
		int y = e.getY();
		int count = e.getClickCount(); // �ѹ� Ŭ������ ����Ŭ������ Ȯ�� �뵵
		
		String info = "mouse Click : " + x + ", " + y + " #" + count;
		display.append(info + "\n");
		display.setCaretPosition(display.getDocument().getLength());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// �ƹ� ���ҵ� ���Ұǵ�, MouseListener implements	 �ϸ� ������ �̰� �־���ؼ� �����.. 
		
		int x = e.getX(); // ���콺 ��ġ : x ��ǥ 
		int y = e.getY();
		int count = e.getClickCount(); // �ѹ� Ŭ������ ����Ŭ������ Ȯ�� �뵵
		
		String info = "mouse Pressed : " + x + ", " + y + " #" + count;
		display.append(info + "\n");
		display.setCaretPosition(display.getDocument().getLength());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// ctrl, alt, shift �߿�! (abc..����) -> Ű���� �̺�Ʈ������ �׻� üũ �ʿ�!!
		
		char c = e.getKeyChar(); // getKeyCode : insert, �̷�.. ĳ���� �ƴ� Ű ������ ��
		
		String info = "(Ctrl, shift, alt) = (" + e.isControlDown() + ", " + e.isShiftDown() + ", " + e.isAltDown() + ")";
		info = "PRESS " + c + info;
		display.append(info + "\n");
		display.setCaretPosition(display.getDocument().getLength());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class B35Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}