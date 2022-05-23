import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;


class MyFrame extends JFrame implements ActionListener
{
	private JTable table;
	private JPanel tablePanel;
	
	private Vector<String> userColumn;
	private DefaultTableModel tableModel;
	
	private JPanel inputPanel;	
	private JTextField name;
	private JTextField id;
	private JTextField address;
	private JSpinner age; 
	
	/////////////////// Connect to Database ////////////////////
	private final String driver = "org.mariadb.jdbc.Driver";
	private final String dbHost = "localhost";
	private final String dbPort = "3306";
	private final String dbName = "mykb";
	private final String dbPass = "";
	private final String dbUser = "root";
	private final String dbUrl = "jdbc:mariadb://" + dbHost + ":" + dbPort + "/" + dbName + "?characterEncoding=UTF-8";
	private Connection conn = null;
	private ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public MyFrame()
	{
		initFrame("Table Practice");
		
		// Programming Here
		tablePanel = createPanel(); 
		buildTablePanel(); 	
		inputPanel = createPanel();
		buildInputPanel();
		
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		dbConnect();
		this.setVisible(true);
	}
	
	public void dbConnect()
	{
		try {
			Class.forName(driver);
			System.out.println("OK Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			
			if(conn != null)
			{
				System.out.println("OK DB Connect");
			} else
			{
				System.out.println("Fail DB Connect");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Fail Driver Load");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		}
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
			// insert data to DB
			Statement stmt;	 	// java.sql 
			String sql;
			int affectedCount = 0;
			
			try {
				String pstmtId = id.getText();
				String pstmtName = name.getText();
				int pstmtAge = (int)age.getValue();
				String pstmtAddress = address.getText();
				
				stmt = conn.createStatement();
				sql = "insert into online (id, name, age, address) values (?, ?, ?, ?)"; 
				pstmt = conn.prepareStatement(sql);	
				
				pstmt.setString(1, pstmtId); 
				pstmt.setString(2, pstmtName);
				pstmt.setString(3, Integer.toString(pstmtAge)); 
				pstmt.setString(4, pstmtAddress);
				
				affectedCount = pstmt.executeUpdate(); 
				
				System.out.println("affectedCount = " + affectedCount);
				
			} catch (Exception e1) {
				// TODO: handle exception
//				if(conn != null)
//				{
//					try {
//						conn.close();
//					} catch (SQLException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//				}
			}
			
			if(affectedCount == 1)
			{
				int nextTableNo = table.getRowCount() + 1; // 처음엔 RowCount = 0이니까, +1 해서 1번부터 넘버 세라고!
				tableModel = (DefaultTableModel)table.getModel();
				
				// idx, name, id, address, age
				Object[] tmp = new Object[] {nextTableNo, name.getText(), id.getText(), address.getText(), age.getValue()};
				tableModel.addRow(tmp);
				
				System.out.println("draw table");
			} else
			{
				JOptionPane.showMessageDialog(this, "Duplicated Value", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.out.println("duplicated value");
			}
			
			name.setText("");
			id.setText("");
			address.setText("");
			age.setValue(20);
			name.requestFocus();
			
		}
	}	
}

public class B56Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
