import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

class MyFrame extends JFrame implements ActionListener
{
	private JPanel displayPanel;
	private JScrollPane scroll;
	private JTextArea display;
	
	private JPanel buttonPanel;
	private JButton open;
	private JButton save;
	private JFileChooser fc; 	// file-chooser
	private JButton color;
	private JButton calendar;
	private JButton close;

	
	public MyFrame()
	{
		initFrame();
		buildDisplayPanel();
		buildButtonPanel();
		
		this.addWindowFocusListener(new MyWindowAdapter()); // call MyWindowAdapter class		
		this.setVisible(true);
	}
	
	/*
	 * Inner Class : ���ʿ� ���� Ŭ������ �����־� ������ ����
	 *		implements MouseListener �̷��ɷ� �ϸ� ���� click�̺�Ʈ�� �ʿ��ص� ���ʿ��� Overriding�� �� ������ϴµ�,
	 *		�̳�Ŭ���� + Adapter�� �̿��ϸ�, ���ϴ� ��ɸ� �� �� ����!
	 */
	class MyWindowAdapter extends WindowAdapter
	{

		@Override
		public void windowGainedFocus(WindowEvent e) {
			// TODO Auto-generated method stub
			display.append("Window Gain Focus\n");
//			super.windowGainedFocus(e);
		}

		@Override
		public void windowLostFocus(WindowEvent e) {
			// TODO Auto-generated method stub
			display.append("Window Lose Focus\n");
//			super.windowLostFocus(e);
		}
		
	}
	
	public void buildDisplayPanel()
	{
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		display = new JTextArea();			// ���� ���� � �����ִµ�, border.center�� ���ϰŶ� �ʿ����..
		scroll = new JScrollPane(display);
		
		displayPanel.add(scroll, BorderLayout.CENTER);
		this.add(displayPanel);
	}
	
	public void buildButtonPanel()
	{
		buttonPanel = new JPanel();
//		buttonPanel.setLayout(new FlowLayout()); // ����Ʈ�� ���ʿ��� �ڵ� 
		
		open = new JButton("Open");
		save = new JButton("Save");
		color = new JButton("Color");
		calendar = new JButton("Calendar");
		fc = new JFileChooser();
		close = new JButton("Exit");
		
		open.addActionListener(this);	// event
		save.addActionListener(this);	// event
		color.addActionListener(this);	// event
		calendar.addActionListener(this); // event
		close.addActionListener(this);	// event
		
		buttonPanel.add(open);
		buttonPanel.add(save);
		buttonPanel.add(color);
		buttonPanel.add(calendar);
		buttonPanel.add(close);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void initFrame()
	{
		this.setTitle("File Open/Save");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setLayout(new BorderLayout());	// default���� �׷��� ���ִ� ����! 
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == open)
		{
			/*
			 * File �̸� : ��θ�/���ϸ�.Ȯ���� (Ȯ���ڴ� 3���ڰ� ���� ��Ģ) (��) a.txt, b.js, c.xlsx
			 * 		Linux, MacOS : mysql.dump.2022-04-18.db.sql �̷������� ��� �ϸ� �� ������ sql�� Ȯ����(���� .�� _�Ǵ� (space) ����)
			 */
			
//			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image File", "jpg", "png"); // �������� ���� 
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
			int result;
			
			fc.setFileFilter(filter); 					// .txt�� ���͸� 
			result = fc.showOpenDialog(this);			// file choose�ϴ� dialogâ ���� 
			
			if(result == JFileChooser.APPROVE_OPTION)	// dialog���� "OPEN"�� ���� ��� 
			{
				String path = fc.getSelectedFile().getPath(); // ���� ��� + ���� �̸� 
				System.out.println("Path = " + path);
				
				FileReader in = null;		// ���� �д� �뵵
				BufferedReader br = null; 	// ���۴������� ���������� ������ �� �������� 
				
				display.setText("");
				String line = null;
				
				try {
					in = new FileReader(path);
					br = new BufferedReader(in);
					
					while( (line = br.readLine()) != null )
					{
						display.append(line + "\n");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					// error
					display.append("File Open Error : " + e2.getMessage() + "\n");
					
				} finally
				{
					// �ڿ� �ݳ� 
					try {
						if(in != null)
							in.close();
						
						if(br != null)
							br.close();
						
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}	
			}
		}
		
		if(e.getSource() == save)
		{
			int result;
			result = fc.showSaveDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION) // OK
			{
				FileWriter out = null;
				BufferedWriter bw = null;
				String fileContents = display.getText();
				
				String path = fc.getSelectedFile().getPath();
				System.out.println("Save File = " + path);
				
				try {
					out = new FileWriter(path);
					bw = new BufferedWriter(out);
					
					StringTokenizer st = new StringTokenizer(fileContents, "\n"); // line������ ���ž� -> line�� \n���� ���еǴϱ� \n������ ���� �������� �ɰ���
					while(st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();
						bw.flush(); // ������ ���������� ��ٷ� 
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Exception : " + e2.getMessage());
				} finally
				{
					try {
						if(out != null)
							out.close();
						
						if(bw != null)
							bw.close();
						
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
			}
		}
		
		if(e.getSource() == color)
		{
			JColorChooser chooser = new JColorChooser();
			Color selectedColor = chooser.showDialog(null, "Color", Color.DARK_GRAY); // default color : Dark gray
			
			if(selectedColor != null)
			{
				display.setForeground(selectedColor);
			}
		}
		
		if(e.getSource() == calendar)
		{
			Date today = new Date(); // new Date(2022, 4, 18); �ϸ� ������(1900.1.1)�� ���� ���ؼ� 3922�� ���� 
			display.append("today = " + today + "\n");
			
			Calendar gc = new GregorianCalendar();
			display.append("year = " + gc.get(Calendar.YEAR)+ "\n" );
			display.append("month = " + gc.get(Calendar.MONTH) + "\n" );	// month : 0~11 (+1 required) 
			display.append("date = " + gc.get(Calendar.DATE)+ "\n" );
			display.append("hour = " + gc.get(Calendar.HOUR)+ "\n" );
			display.append("minute = " + gc.get(Calendar.MINUTE)+ "\n" );
			display.append("second = " + gc.get(Calendar.SECOND)+ "\n" );
			display.append("day = " + gc.get(Calendar.DAY_OF_WEEK)+ "\n" );	// check which day is 0 (Sunday = 0)
		}
		
		if(e.getSource() == close)
		{
			System.exit(1);
		}
	}
}

public class B58Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}
}
