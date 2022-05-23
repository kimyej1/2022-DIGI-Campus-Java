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
		
		// 1. 레이아웃 정하기
		this.setLayout(new BorderLayout());
		
		// 2. 디스플레이 패널
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.yellow);
		
		// displayPanel의 컴포넌트 만들어 붙이기,,
		displayPanel.setLayout(new BorderLayout()); // 알아서 center에 붙으니까 
		
		display = new JTextArea(5,30);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER); // center은 안써도 알아서 들어가긴함 
		
		displayFont = new Font("dialog", Font.BOLD, 15);
		display.setFont(displayFont);
		display.setEditable(false);
		
		// 회색(무채색, RGB 동일한 비율)
		display.setBackground(new Color(230, 230, 230));
		
		// mouse Event 등록 
		display.addMouseListener(this);
		
		// 3. 인풋 패널
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.blue);
		
		// inputPanel의 컴포넌트 만들어 붙이기,,
		inputPanel.setLayout(new BorderLayout());
		input = new JTextField(10); 				// EVENT 1
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		// EVENT 2 : 이벤트 등록
		input.addActionListener(this); // 엔터쳤을때 이벤트 발생 
		input.addKeyListener(this); // 키 하나하나에 이벤트 발생 
		
		// 4. 각 패널을 프레임에 붙이기 
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// EVENT 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display에 input 내용을 append
			display.append("\n" + input.getText());
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX(); // 마우스 위치 : x 좌표 
		int y = e.getY();
		int count = e.getClickCount(); // 한번 클릭인지 더블클릭인지 확인 용도
		
		String info = "mouse Click : " + x + ", " + y + " #" + count;
		display.append(info + "\n");
		display.setCaretPosition(display.getDocument().getLength());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// 아무 역할도 안할건데, MouseListener implements	 하면 무조건 이거 있어야해서 만든거.. 
		
		int x = e.getX(); // 마우스 위치 : x 좌표 
		int y = e.getY();
		int count = e.getClickCount(); // 한번 클릭인지 더블클릭인지 확인 용도
		
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
		// ctrl, alt, shift 중요! (abc..보다) -> 키보드 이벤트에서는 항상 체크 필요!!
		
		char c = e.getKeyChar(); // getKeyCode : insert, 이런.. 캐릭터 아닌 키 눌렀을 때
		
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
