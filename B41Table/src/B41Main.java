import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

// Vector : 가변길이 Array 
// 		(길이를 설정하지 않고 계속 늘려가면서 쓸 수 있도록).. Generic이나 Collections과 사용해도 좋다 

class MyFrame extends JFrame implements ActionListener
{
	private JTable table;
	private JPanel tablePanel;
	// not sure how many inputs will put -> use VECTOR
	
	private Vector<String> userColumn;
	private DefaultTableModel tableModel;
	
	
	private JPanel inputPanel;
	// input : name, id, address, age
	
	private JTextField name;
	private JTextField id;
	private JTextField address;
	private JSpinner age; 
	
	public MyFrame()
	{
		initFrame("Table Practice");
		
		// Programming Here
		tablePanel = createPanel(); // 원래는 "tablePanel = new JPanel(); + 속성 나열" 해야하는데, 그냥 다 만들어서 패널 리턴해주는 함수로 해버리기!
		buildTablePanel(); 				 // createPanel() 안에서 처리해도 되는데, 따로 만들면 간결해지고 짧아짐 
		
		inputPanel = createPanel();
		buildInputPanel();
		
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public void buildInputPanel()
	{
		// name(tf), age(spinner), address(tf), id(tf)
		name = new JTextField(5);
		id = new JTextField(5);
		address = new JTextField(5);
		
		SpinnerModel smAge = new SpinnerNumberModel(20, 1, 100, 1); // spinnerNumberModel(default, min, max, step);
		age = new JSpinner(smAge);
		
		inputPanel.add(new JLabel("name")); // label 먼저 달아놓고 input창을 넣어야 뭘 입력하는지 알수있음(placeholder가 없으니까)
		inputPanel.add(name);
		inputPanel.add(new JLabel("ID"));
		inputPanel.add(id);
		inputPanel.add(new JLabel("age"));
		inputPanel.add(age);
		inputPanel.add(new JLabel("address"));
		inputPanel.add(address);
		
		address.addActionListener(this); // 마지막꺼 입력하고 엔터치면 이벤트 발생하도록 
	}
	
	public void buildTablePanel()
	{
		userColumn = new Vector<String>();
		userColumn.addElement("idx");
		userColumn.addElement("name");
		userColumn.addElement("ID");
		userColumn.addElement("address");
		userColumn.addElement("age");
		
		tableModel = new DefaultTableModel(userColumn, 0);
		table = new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(450,350));
		table.setFillsViewportHeight(true); // 데이터 없어도 아래쪽 흰색으로 채워라~
		
		JScrollPane tableScroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true); // 자동정렬하는거 만들래? -> true(yes)
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50); // col(0) = idx열의 디폴트 너비 설정 
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(200); // col(3) = address는 꽤 넓어야함 
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		
		tablePanel.add(tableScroll);
	}
	
	public JPanel createPanel() // return panel!
	{
		JPanel panel = new JPanel();
		return panel;
	}

	public void initFrame(String title)
	{
		this.setTitle(title); // 이름이 정해지지 않고 매번 생성자 불러올 때 정한 제목으로 들어가도록!
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == address)
		{
			int nextTableNo = table.getRowCount() + 1; // 처음엔 RowCount = 0이니까, +1 해서 1번부터 넘버 세라고!
			tableModel = (DefaultTableModel)table.getModel();
			
			// idx, name, id, address, age
			Object[] tmp = new Object[] {nextTableNo, name.getText(), id.getText(), address.getText(), age.getValue()};
			tableModel.addRow(tmp);
		}
	}
	
}

public class B41Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
