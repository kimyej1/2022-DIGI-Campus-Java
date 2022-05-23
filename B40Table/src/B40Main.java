import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		// 테이블 : 이름, 주소, 나이, 가입여부 
		String[] colName = {"이름", "주소", "나이", "가입여부"}; // 배열로 머릿글 만들기 
		Object[][] data = { // 이중배열로 만들기 
				{"홍길동", "서울", 33, false},
				{"이순신", "경상", 44, true},
				{"킹세종", "전라", 55, true}				
		};
		
		JTable table = new JTable(data, colName);
		table.setPreferredScrollableViewportSize(new Dimension(500,150));
		table.setFillsViewportHeight(true); // 여백을 어떻게 처리할지? (맥북은 차이없음.. 테이블 밑에가 회색이냐 흰색이냐 이렇게 다른듯)
		
		JScrollPane scroll = new JScrollPane(table); // 테이블 자동스크롤처리되도록 
		this.add(scroll);
		
		this.setVisible(true);
	}
}

public class B40Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
