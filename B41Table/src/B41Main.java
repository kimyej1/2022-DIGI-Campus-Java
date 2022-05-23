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

// Vector : �������� Array 
// 		(���̸� �������� �ʰ� ��� �÷����鼭 �� �� �ֵ���).. Generic�̳� Collections�� ����ص� ���� 

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
		tablePanel = createPanel(); // ������ "tablePanel = new JPanel(); + �Ӽ� ����" �ؾ��ϴµ�, �׳� �� ���� �г� �������ִ� �Լ��� �ع�����!
		buildTablePanel(); 				 // createPanel() �ȿ��� ó���ص� �Ǵµ�, ���� ����� ���������� ª���� 
		
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
		
		inputPanel.add(new JLabel("name")); // label ���� �޾Ƴ��� inputâ�� �־�� �� �Է��ϴ��� �˼�����(placeholder�� �����ϱ�)
		inputPanel.add(name);
		inputPanel.add(new JLabel("ID"));
		inputPanel.add(id);
		inputPanel.add(new JLabel("age"));
		inputPanel.add(age);
		inputPanel.add(new JLabel("address"));
		inputPanel.add(address);
		
		address.addActionListener(this); // �������� �Է��ϰ� ����ġ�� �̺�Ʈ �߻��ϵ��� 
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
		table.setFillsViewportHeight(true); // ������ ��� �Ʒ��� ������� ä����~
		
		JScrollPane tableScroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true); // �ڵ������ϴ°� ���鷡? -> true(yes)
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50); // col(0) = idx���� ����Ʈ �ʺ� ���� 
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(200); // col(3) = address�� �� �о���� 
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
		this.setTitle(title); // �̸��� �������� �ʰ� �Ź� ������ �ҷ��� �� ���� �������� ������!
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == address)
		{
			int nextTableNo = table.getRowCount() + 1; // ó���� RowCount = 0�̴ϱ�, +1 �ؼ� 1������ �ѹ� �����!
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
