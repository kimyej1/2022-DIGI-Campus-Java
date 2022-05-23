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
		

	// A01 각 모드(UDP server, client, TCP server,  client)
	// 		모두 false일 수는 있지만, 두개 초과 한번에 True일 수는 없다.
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
		
		setDefaultUdpClient();	// 이거 누르면 버튼들이 자동으로 UDP Client 환경으로 눌리게..! 

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
		tableNo = 0;				// 전역변수로 0으로 초기화해놓고, 머 할때마다 1, 2,... 이렇게 늘려가며 쓰려고! 
		radioClient.setSelected(true);
		receiveClient.setEnabled(true);
		radioUDP.setSelected(true);
		echoServer.setEnabled(false);
		
		stopBtn.setEnabled(false);	// 원래는 아직 스타트 안눌렀으니 False여야 하고, run 상태일 때만 true여야 함 
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
		
		filePanel.add(new JLabel(""));	// 한칸 비워두기 
		filePanel.add(saveButton);
		filePanel.add(clearButton);
		
		bodyPanel.add(filePanel, BorderLayout.EAST);
	}
	
	public JScrollPane buildScrollTable()
	{
		userColumn = new Vector<String>();
		userColumn.addElement("No");
		userColumn.addElement("In/Out"); // 들어온거냐 나간거냐 (Up/Down)
		userColumn.addElement("IP Address");
		userColumn.addElement("Port");
		userColumn.addElement("Messages");
		
		
		tableModel = new DefaultTableModel(userColumn, 0);
		table = new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(500,350));
		table.setFillsViewportHeight(true); // 데이터 없어도 아래쪽 흰색으로 채워라~
		table.setAutoCreateRowSorter(true); // 자동정렬하는거 만들래? -> true(yes)
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50); // col(0) = no.열의 디폴트 너비 설정 
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
		
		// A02 버튼에 이벤트 등록
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		Border sseBorder = BorderFactory.createTitledBorder("Start/Stop");
		startStopPanel.setBorder(sseBorder);
		startStopPanel.add(startBtn);
		startStopPanel.add(stopBtn);
		startStopPanel.add(exitBtn);
		
		startBtn.setEnabled(false); // 처음엔 아무것도 입력/선택 안되어있기때문에 버튼들이 비활성화된 상태 
		stopBtn.setEnabled(false);
		
		headPanel.add(startStopPanel, BorderLayout.EAST);
	}
	
	public void buildOptionPanel()
	{
		optionPanel = createPanel();				// this.optionPanel = 이렇게 쓰면 타이핑 편함 
		optionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));	// 여기부터는 따로 함수로 또 빼도 되고 여기에 쭉 써도 되고.. 선택!
		
		// Server-Client Panel
		serverClientPanel = createPanel();
		serverClientPanel.setLayout(new FlowLayout());
		
		radioServer = new JRadioButton("Server");
		radioServer.addActionListener(this);
		radioClient = new JRadioButton("Client");
		radioClient.addActionListener(this);
		
		echoServer = new JCheckBox("Echo");
		receiveClient = new JCheckBox("Rcv");
		
		ButtonGroup serverOrClient = new ButtonGroup(); // 얘는 여기서만 쓰고 말거라서 전역변수로 안씀 
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
//		return new JPanel();  // 위의 두줄을 이거 한줄로 대체 가능 
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
		// (us, uc, ts, tc) = (false, false, true, false) 이런식으로 출력 
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
		
		if(radioServer.isSelected() == false && radioUDP.isSelected()) // isEnabled() t/f 없으면 True 
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
		} else if(radioServer.isSelected() && radioTCP.isSelected()) // isEnabled() t/f 없으면 True 
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
						
						// TODO: 나머지 상태 추가 예정 : TODO로 적어두면 나중에 찾아서 하기 쉬움! 
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
//			if(isRunning == false && udpClientReadyFlag == true)	 // readyFlag = true -> 보낼 데이터가 있다 -> send 눌렀
			if(isRunning == false)
			{
				isRunning = true; // 밑에 두줄이 오래걸리더라도 이 if문 다시 실행하지않고 최초 한번만 실행되도록 
				UDPClient udpClient = new UDPClient(this); // 객체 생성 ; this(나) = simulator, 내 정보를 통째로 줌 
				System.out.println("Create UDP Client...");
			}
			
			try {
				Thread.sleep(500); // 0.5초마다 updClient 객체 계속 만듬 (보낼 데이터 있는지 0.5초마다 감시)
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
		
		// A03 Start Button 실행 
		if(e.getSource() == startBtn)
		{
			// 현재 상태 먼저 확인
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
			
			// 데이터 전송 .. 메시지 읽어서 보내기.. 
			udpClientReadyFlag = true;	// '나 보낼 데이터 있어!'
		}
		
		fileControl(e);
	}
	
	public void openFile(int i)
	{
		FileReader in = null;	// 읽어오기만 하면 되니까 reader만 필요함 
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
				FileWriter out = null;		// 쓰기만 하면 되니까 Writer만 필요 
				BufferedWriter bw = null;
				
				String path = fc.getSelectedFile().getPath();
				String fileContents = display.getText();
				System.out.println("Save File = " + path);
				
				try {
					out = new FileWriter(path);
					bw = new BufferedWriter(out);
					
					StringTokenizer st = new StringTokenizer(fileContents, "\n"); // line단위로 쓸거야 -> line은 \n으로 구분되니까 \n단위로 파일 콘텐츠를 쪼개줘
					while(st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();	// 줄바꿈 
						bw.flush(); 	// 실제로 써질때까지 기다려 
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
