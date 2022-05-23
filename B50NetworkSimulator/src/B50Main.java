import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


class NetworkSimulator extends JFrame implements ActionListener
{
	private JPanel headPanel;
		private JPanel optionPanel;
			private JPanel serverClientPanel;
				private JRadioButton radioServer;
				private JRadioButton radioClient;
				private JCheckBox echoServer;
				private JCheckBox receiveClient;
			private JPanel protocolPanel;
				private JRadioButton radioTCP;
				private JRadioButton radioUDP;
		private JPanel startStopPanel;
			private JButton startBtn;
			private JButton stopBtn;
			private JButton exitBtn;
		private JPanel ipPortPanel;
			private JTextField inputIP;
			private JTextField inputPort;
			private JTextField debugMsg;
		
	private JPanel bodyPanel;
		private JScrollPane tableScroll;
		private JTable table;
			private DefaultTableModel tableModel;
			private Vector<String> userColumn;
			private int tableNo;
		private JPanel displayPanel;
			private JScrollPane displayScroll;
			private JTextArea display;
		private JPanel filePanel;
			private JButton[] fileButton;
			private JButton saveButton;
			private JButton clearButton;
		
	private JPanel tailPanel;
		private JSpinner sleepSpinner;
		private JSpinner countSpinner;
		private JButton sendBtn;
		private JCheckBox checkRandom;
		private JFileChooser fc;
		

	// A01 �� ���(UDP server, client, TCP server,  client)
	// 		��� false�� ���� ������, �ΰ� �ʰ� �ѹ��� True�� ���� ����.
	private boolean isUdpServerMode = false;
	private boolean isUdpClientMode = false;
	private boolean isTcpServerMode = false;
	private boolean isTcpClientMode = false;
	
	private boolean isRunning = false;
	private boolean udpClientReadyFlag = false;
	
	private Thread thread;	// thread that'll be used in common
	private boolean threadFlag = false;
	
	public NetworkSimulator()
	{
		// Programming Here
		initFrame();
		
		// 1. Head Panel
		headPanel = createPanel();		
		buildHeadPanel();
		this.add(headPanel, BorderLayout.NORTH);
		
		// 2. Body Panel
		bodyPanel = createPanel();
		buildBodyPanel();
		this.add(bodyPanel, BorderLayout.CENTER);
		
		// 3. Tail Panel
		tailPanel = createPanel();
		buildTailPanel();
		this.add(tailPanel, BorderLayout.SOUTH);
		
		setDefaultUdpClient();	// �̰� ������ ��ư���� �ڵ����� UDP Client ȯ������ ������..! 

//		this.pack(); 			// fit the window's size
		this.setVisible(true);
	}
	
	
	//////////// Getters & Setters /////////////
	
	
	public JSpinner getSleepSpinner() {
		return sleepSpinner;
	}

	public JCheckBox getReceiveClient() {
		return receiveClient;
	}


	public boolean isUdpServerMode() {
		return isUdpServerMode;
	}


	public void setUdpServerMode(boolean isUdpServerMode) {
		this.isUdpServerMode = isUdpServerMode;
	}


	public boolean isUdpClientMode() {
		return isUdpClientMode;
	}


	public void setUdpClientMode(boolean isUdpClientMode) {
		this.isUdpClientMode = isUdpClientMode;
	}


	public boolean isTcpServerMode() {
		return isTcpServerMode;
	}


	public void setTcpServerMode(boolean isTcpServerMode) {
		this.isTcpServerMode = isTcpServerMode;
	}


	public boolean isTcpClientMode() {
		return isTcpClientMode;
	}


	public void setTcpClientMode(boolean isTcpClientMode) {
		this.isTcpClientMode = isTcpClientMode;
	}


	public JCheckBox getCheckRandom() {
		return checkRandom;
	}

	public JSpinner getCountSpinner() {
		return countSpinner;
	}



	public JTextField getInputIP() {
		return inputIP;
	}



	public JTextField getInputPort() {
		return inputPort;
	}



	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	public DefaultTableModel getTableModel() {
		return tableModel;
	}


	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}



	public int getTableNo() {
		return tableNo;
	}



	public boolean isRunning() {
		return isRunning;
	}



	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}



	public boolean isUdpClientReadyFlag() {
		return udpClientReadyFlag;
	}



	public void setUdpClientReadyFlag(boolean udpClientReadyFlag) {
		this.udpClientReadyFlag = udpClientReadyFlag;
	}


	public JTextArea getDisplay() {
		return display;
	}



	public void setDisplay(JTextArea display) {
		this.display = display;
	}



	public void setDefaultUdpClient()
	{
		tableNo = 0;				// ���������� 0���� �ʱ�ȭ�س���, �� �Ҷ����� 1, 2,... �̷��� �÷����� ������! 
		radioClient.setSelected(true);
		receiveClient.setEnabled(true);
		radioUDP.setSelected(true);
		echoServer.setEnabled(false);
		
		stopBtn.setEnabled(false);	// ������ ���� ��ŸƮ �ȴ������� False���� �ϰ�, run ������ ���� true���� �� 
		startBtn.setEnabled(true);
		
		inputIP.setText("127.0.0.1");
		inputPort.setText("10000");	// Server IP/Port # 
		this.debugMsg.setText("Ready..");
		
	}
	
	public void buildTailPanel()
	{
		tailPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		Border border = BorderFactory.createTitledBorder("Simulation Option");
		tailPanel.setBorder(border);
		
		SpinnerModel smsleep = new SpinnerNumberModel(200, 0, 10000, 100); // (default, min, max, step)
		sleepSpinner = new JSpinner(smsleep);
		
		tailPanel.add(new JLabel("Sleep(msec)"));
		tailPanel.add(sleepSpinner);
		
		SpinnerModel smCount = new SpinnerNumberModel(10, 1, 10000000, 1); // (default, min, max, step)
		countSpinner = new JSpinner(smCount);
		
		tailPanel.add(new JLabel("Repeat Count"));
		tailPanel.add(countSpinner);
		
		tailPanel.add(new JLabel("Random"));
		checkRandom = new JCheckBox();
		
		sendBtn = new JButton("SEND");
		sendBtn.setEnabled(false);
		// EVENT
		sendBtn.addActionListener(this);
		
		tailPanel.add(checkRandom);
		tailPanel.add(sendBtn); 
	}
	
	public void buildBodyPanel()
	{
//		tableScroll = buildScrollTable();
		bodyPanel.add(buildScrollTable(), BorderLayout.CENTER);
		
		filePanel = createPanel();
		buildFilePanel();
		buildDisplay();
	}
	
	public void buildDisplay()
	{
		display = new JTextArea(10,35);
		displayScroll = new JScrollPane(display);
		
		Font font = new Font("Dialog", Font.PLAIN, 20);
		display.setFont(font);
		
		displayPanel = createPanel();
		displayPanel.setLayout(new FlowLayout());
		displayPanel.add(displayScroll);
		
		Border border = BorderFactory.createTitledBorder("File Info/Send Msg");
		displayPanel.setBorder(border);
		
		bodyPanel.add(displayPanel, BorderLayout.SOUTH);
	}
	
	public void buildFilePanel()
	{
		filePanel.setLayout(new GridLayout(0,1));
		Border border = BorderFactory.createTitledBorder("Select File");
		filePanel.setBorder(border);
		
		// int[] lotto = new int[6];
		// JButton[] fileButton = new JButton[6];
		fileButton = new JButton[6];
		
		for(int i=0; i<fileButton.length; i++)
		{
			fileButton[i] = new JButton("File Button " + (i+1)); // idx starts with 0, but file should start with 1
			fileButton[i].addActionListener(this);
			filePanel.add(fileButton[i]);
		}
	
		saveButton = new JButton("SAVE");
		saveButton.addActionListener(this);
		
		clearButton = new JButton("CLEAR");
		clearButton.addActionListener(this);
		
		filePanel.add(new JLabel(""));	// ��ĭ ����α� 
		filePanel.add(saveButton);
		filePanel.add(clearButton);
		
		bodyPanel.add(filePanel, BorderLayout.EAST);
	}
	
	public JScrollPane buildScrollTable()
	{
		userColumn = new Vector<String>();
		userColumn.addElement("No");
		userColumn.addElement("In/Out"); // ���°ų� �����ų� (Up/Down)
		userColumn.addElement("IP Address");
		userColumn.addElement("Port");
		userColumn.addElement("Messages");
		
		
		tableModel = new DefaultTableModel(userColumn, 0);
		table = new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(500,350));
		table.setFillsViewportHeight(true); // ������ ��� �Ʒ��� ������� ä����~
		table.setAutoCreateRowSorter(true); // �ڵ������ϴ°� ���鷡? -> true(yes)
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50); // col(0) = no.���� ����Ʈ �ʺ� ���� 
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		
		tableScroll = new JScrollPane(table);
		return tableScroll;
	}
	
	public void buildHeadPanel()
	{
		headPanel.setLayout(new BorderLayout());
		
		buildOptionPanel();
		buildStartStopPanel();
		buildIPPortPanel();		
	}
	
	public void buildIPPortPanel()
	{
		ipPortPanel = createPanel();
		ipPortPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		ipPortPanel.add(new JLabel("IP"));
		
		Font font = new Font("Dialog", Font.BOLD, 20);
		inputIP = new JTextField(10);
		inputIP.setFont(font);
		ipPortPanel.add(inputIP);
		
		ipPortPanel.add(new JLabel("Port"));
		
		inputPort = new JTextField(10);
		inputPort.setFont(font);
		ipPortPanel.add(inputPort);
		
		ipPortPanel.add(new JLabel("Debug"));
		
		debugMsg = new JTextField(8);
		debugMsg.setFont(font);
		debugMsg.setBackground(new Color(200,200,200));
		debugMsg.setEditable(false);
		ipPortPanel.add(debugMsg);
		
		headPanel.add(ipPortPanel, BorderLayout.SOUTH);
	}
	
	public void buildStartStopPanel()
	{
		startStopPanel = createPanel();
		startStopPanel.setLayout(new FlowLayout());
		
		startBtn = new JButton("Start");
		stopBtn = new JButton("Stop");
		exitBtn = new JButton("Exit");
		
		// A02 ��ư�� �̺�Ʈ ���
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		Border sseBorder = BorderFactory.createTitledBorder("Start/Stop");
		startStopPanel.setBorder(sseBorder);
		startStopPanel.add(startBtn);
		startStopPanel.add(stopBtn);
		startStopPanel.add(exitBtn);
		
		startBtn.setEnabled(false); // ó���� �ƹ��͵� �Է�/���� �ȵǾ��ֱ⶧���� ��ư���� ��Ȱ��ȭ�� ���� 
		stopBtn.setEnabled(false);
		
		headPanel.add(startStopPanel, BorderLayout.EAST);
	}
	
	public void buildOptionPanel()
	{
		optionPanel = createPanel();				// this.optionPanel = �̷��� ���� Ÿ���� ���� 
		optionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));	// ������ʹ� ���� �Լ��� �� ���� �ǰ� ���⿡ �� �ᵵ �ǰ�.. ����!
		
		// Server-Client Panel
		serverClientPanel = createPanel();
		serverClientPanel.setLayout(new FlowLayout());
		
		radioServer = new JRadioButton("Server");
		radioServer.addActionListener(this);
		radioClient = new JRadioButton("Client");
		radioClient.addActionListener(this);
		
		echoServer = new JCheckBox("Echo");
		receiveClient = new JCheckBox("Rcv");
		
		ButtonGroup serverOrClient = new ButtonGroup(); // ��� ���⼭�� ���� ���Ŷ� ���������� �Ⱦ� 
		serverOrClient.add(radioServer);
		serverOrClient.add(radioClient);
		
		Border socBorder = BorderFactory.createTitledBorder("Server/Client");
		serverClientPanel.setBorder(socBorder);
		serverClientPanel.add(radioServer);
		serverClientPanel.add(echoServer);
		serverClientPanel.add(radioClient);
		serverClientPanel.add(receiveClient);
		
		optionPanel.add(serverClientPanel);
		
		// Protocol Panel
		protocolPanel = createPanel();
		protocolPanel.setLayout(new FlowLayout());
		
		radioTCP = new JRadioButton("TCP");
		radioUDP = new JRadioButton("UDP");
		
		ButtonGroup protocol = new ButtonGroup();
		protocol.add(radioTCP);
		protocol.add(radioUDP);
		
		Border ptcBorder = BorderFactory.createTitledBorder("Protocol");
		protocolPanel.setBorder(ptcBorder);
		protocolPanel.add(radioTCP);
		protocolPanel.add(radioUDP);
		
		optionPanel.add(protocolPanel);
		
		headPanel.add(optionPanel);
	}

	public JPanel createPanel()
	{
		JPanel panel = new JPanel();
		return panel;
//		return new JPanel();  // ���� ������ �̰� ���ٷ� ��ü ���� 
	}
	
	public void initFrame()
	{
		this.setTitle("Network Simulator");
		this.setSize(700,1000);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void printStatus()
	{
		// (us, uc, ts, tc) = (false, false, true, false) �̷������� ��� 
		System.out.println("(us, uc, ts, tc) = ( " + isUdpServerMode + ", " + isUdpClientMode + ", " 
												   + isTcpServerMode + ", " + isTcpClientMode + " )\n");
	}
	
	public void doStart()
	{
		this.debugMsg.setText("Start");
		this.startBtn.setEnabled(false); 	// 'this' is optional, (easier to type)
		stopBtn.setEnabled(true);
		
		if(radioServer.isSelected())
		{
			radioClient.setEnabled(false);
			receiveClient.setEnabled(false);
		} else
		{
			radioServer.setEnabled(false);
			echoServer.setEnabled(false);
		}
		
		isUdpServerMode = false;
		isUdpClientMode = false;
		isTcpServerMode = false;
		isTcpClientMode = false;
		
		if(radioServer.isSelected() == false && radioUDP.isSelected()) // isEnabled() t/f ������ True 
		{
			isUdpClientMode = true;
			System.out.println("UDP Client");
		} else if(radioServer.isSelected() && radioUDP.isSelected())
		{
			isUdpServerMode = true;
			System.out.println("UDP Server");
		} else if(radioServer.isSelected() == false && radioTCP.isSelected())
		{
			isTcpClientMode = true;
			System.out.println("TCP Client");
		} else if(radioServer.isSelected() && radioTCP.isSelected()) // isEnabled() t/f ������ True 
		{
			isTcpServerMode = true;
			System.out.println("TCP Server");
		}
		
		if(isTcpServerMode || isTcpClientMode || isUdpServerMode || isUdpClientMode)
		{
			thread = new Thread(new Runnable() {  // thread uses "Runnable Interface"
				public void run()
				{
					try {
						if(isUdpClientMode == true)
						{
							startUdpClient();
						}
						
						// TODO: ������ ���� �߰� ���� : TODO�� ����θ� ���߿� ã�Ƽ� �ϱ� ����! 
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			});
			
			thread.start();
		}
	}
	
	public void startUdpClient()
	{
		threadFlag = true;
		stopBtn.setEnabled(true);	// since it's already started, 
		startBtn.setEnabled(false); // couldn't be started again.
		sendBtn.setEnabled(true);
		
		this.isRunning = false;		// not running
		
		while(true)
		{
//			if(isRunning == false && udpClientReadyFlag == true)	 // readyFlag = true -> ���� �����Ͱ� �ִ� -> send ����
			if(isRunning == false)
			{
				isRunning = true; // �ؿ� ������ �����ɸ����� �� if�� �ٽ� ���������ʰ� ���� �ѹ��� ����ǵ��� 
				UDPClient udpClient = new UDPClient(this); // ��ü ���� ; this(��) = simulator, �� ������ ��°�� �� 
				System.out.println("Create UDP Client...");
			}
			
			try {
				Thread.sleep(500); // 0.5�ʸ��� updClient ��ü ��� ���� (���� ������ �ִ��� 0.5�ʸ��� ����)
				System.out.println(".");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if(isUdpClientMode == false)
			{
				break;	// stop btn -> break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// A03 Start Button ���� 
		if(e.getSource() == startBtn)
		{
			// ���� ���� ���� Ȯ��
			printStatus();
			doStart();
		}
		
		if(e.getSource() == radioServer)
		{
			receiveClient.setEnabled(false);
			echoServer.setEnabled(true);
		}
		if(e.getSource() == radioClient)
		{
			echoServer.setEnabled(false);
			receiveClient.setEnabled(true);
		}
		
		if(e.getSource() == clearButton)
		{
			this.display.setText("");
		}
		
		if(e.getSource() == stopBtn)
		{
			this.setRunning(false);
			this.debugMsg.setText("Stop");
			
			this.setUdpClientMode(false);
			this.setUdpServerMode(false);
			this.setTcpClientMode(false);
			this.setTcpServerMode(false);
			
			this.startBtn.setEnabled(true);
			this.stopBtn.setEnabled(false);
			
			this.receiveClient.setEnabled(true);
			this.echoServer.setEnabled(true);
			this.radioServer.setEnabled(true);
			this.radioClient.setEnabled(true);
		}
		
		if(e.getSource() == exitBtn)
		{
			JOptionPane exit = new JOptionPane();
			int answer = JOptionPane.showConfirmDialog(exit, "Do you really want to Exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if(answer == JOptionPane.YES_OPTION)
				System.exit(1);
			
		}
		
		if(e.getSource() == sendBtn)
		{
			if(checkRandom.isSelected())
			{
				int i = (int)(Math.random() * 6);
				openFile(i);
			}
			
			// ������ ���� .. �޽��� �о ������.. 
			udpClientReadyFlag = true;	// '�� ���� ������ �־�!'
		}
		
		fileControl(e);
	}
	
	public void openFile(int i)
	{
		FileReader in = null;	// �о���⸸ �ϸ� �Ǵϱ� reader�� �ʿ��� 
		BufferedReader br = null;
		
		String fileContents = "";
		String path = "/Users/yeji/Desktop/test/" + (i+1) + ".txt";
		
		try {
			in = new FileReader(path);
			br = new BufferedReader(in);
			
			String line = "";
			while( (line = br.readLine()) != null )
			{
				display.append(line + "\n");
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		} finally
		{
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
	
	public void fileControl(ActionEvent e)
	{
		for(int i=0; i<6; i++)
		{
			if(e.getSource() == fileButton[i])
			{
				openFile(i);
			}
		}
		
		if(e.getSource() == saveButton)
		{
			fc = new JFileChooser();
			fc.setCurrentDirectory(new File("/Users/yeji/Desktop/test"));
			int result = fc.showSaveDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION) // OK
			{			
				FileWriter out = null;		// ���⸸ �ϸ� �Ǵϱ� Writer�� �ʿ� 
				BufferedWriter bw = null;
				
				String path = fc.getSelectedFile().getPath();
				String fileContents = display.getText();
				System.out.println("Save File = " + path);
				
				try {
					out = new FileWriter(path);
					bw = new BufferedWriter(out);
					
					StringTokenizer st = new StringTokenizer(fileContents, "\n"); // line������ ���ž� -> line�� \n���� ���еǴϱ� \n������ ���� �������� �ɰ���
					while(st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();	// �ٹٲ� 
						bw.flush(); 	// ������ ���������� ��ٷ� 
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
	}
}

public class B50Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NetworkSimulator simulator = new NetworkSimulator();
	}

}
