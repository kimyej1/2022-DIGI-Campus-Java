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
		
		// ���̺� : �̸�, �ּ�, ����, ���Կ��� 
		String[] colName = {"�̸�", "�ּ�", "����", "���Կ���"}; // �迭�� �Ӹ��� ����� 
		Object[][] data = { // ���߹迭�� ����� 
				{"ȫ�浿", "����", 33, false},
				{"�̼���", "���", 44, true},
				{"ŷ����", "����", 55, true}				
		};
		
		JTable table = new JTable(data, colName);
		table.setPreferredScrollableViewportSize(new Dimension(500,150));
		table.setFillsViewportHeight(true); // ������ ��� ó������? (�ƺ��� ���̾���.. ���̺� �ؿ��� ȸ���̳� ����̳� �̷��� �ٸ���)
		
		JScrollPane scroll = new JScrollPane(table); // ���̺� �ڵ���ũ��ó���ǵ��� 
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
