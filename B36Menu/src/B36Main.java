import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyFrame extends JFrame implements ActionListener
{
	private JMenuItem eventItem1; // createMenu() 에서도 읽고, actionPerformed()에서도 읽을 수 있도록 바깥에 객체 정의 
	private JPanel displayPanel;
	private JTextArea display;
	private JScrollPane scroll;
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		createMenu(); // 메뉴가 많을테니까 함수처리 
		createDisplay();
		
		this.setVisible(true);
	}
	
	public void createDisplay()
	{
		this.setLayout(new BorderLayout()); 		// frame's layout : border(set)
		displayPanel = new JPanel(); 				// panel's layout : flow(default)
		displayPanel.setLayout(new BorderLayout()); // panel's layout : border(set)
		
		display = new JTextArea();
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		this.add(displayPanel);
	}
	
	public void createMenu()
	{
		 JMenuBar menuBar = new JMenuBar();
		 JMenu fileMenu = new JMenu("File");
		 JMenu editMenu = new JMenu("Edit");
		 
		 menuBar.add(fileMenu);
		 fileMenu.add(new JMenuItem("New"));
		 fileMenu.add(new JMenuItem("Open File..."));
		 fileMenu.addSeparator(); 					// 메뉴 중간선 넣기
		 fileMenu.add(new JMenuItem("Save"));
		 
		 
		 // 객체를 만들어서 JMenuItem 추가
		 
		 eventItem1 = new JMenuItem("Event Test", KeyEvent.VK_E); // Virtual Key : E (E를 이벤트 실행 단축키로 사용) 
		 eventItem1.addActionListener(this);
		 fileMenu.add(eventItem1);
		 
		 
		 JMenu subMenu = new JMenu("Sub Menu");
		 fileMenu.add(subMenu); 					// 메뉴 안에 메뉴아이템이 아니라 또 메뉴를 붙
		 subMenu.add(new JMenuItem("Sub Menu 1"));	// 메뉴 속 메뉴의 메뉴아이템 
		 subMenu.add(new JMenuItem("Sub Menu 2"));
		 
		 menuBar.add(editMenu);
		 editMenu.add(new JMenuItem("Undo Typing"));
		 editMenu.add(new JMenuItem("Redo"));
		 
//		 this.add(menuBar); 		// 무조건 센터에 들어감 
		 this.setJMenuBar(menuBar); // 상단 메뉴바 위치에 들어감 
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == eventItem1)
		{
			System.out.println("event 1 occured");
			display.append("event 1 occured...\n");
		}
	}
}

public class B36Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}
}
