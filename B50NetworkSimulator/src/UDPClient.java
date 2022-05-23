import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UDPClient	 // to separate files from Main.java 
{
	private NetworkSimulator frame;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress serverAddress;
	private String serverIP;
	
	private int myPort = 10001;
	private int serverPort;
	
	private JTable table;	// main�� ���̺� �ϳ��ϳ� Get/set�ϱ� ���ŷο��, ��°�� ���� �׳� �־������ 
	private Vector<String> userColumn = new Vector<String>();
	private Vector<String> userRow;
	private DefaultTableModel tableModel;
	
	private int counter;
	private int sleepInterval;
	
	
	public UDPClient(NetworkSimulator frame) // constructor param : frame
	{
		this.frame = frame; // main.java�� networkSimulator�� ��°�� �޾ƿ� -> �׷��� �Լ��� �� �� �� ����
		
		serverIP = this.frame.getInputIP().getText();						// ip : String
		serverPort = Integer.parseInt(this.frame.getInputPort().getText()); // port : int
		
		/*
		 * this.frame.inputPort �̷��� �ϰ������.. inputPort = private	�̶� ���⼱ �Ⱥ���
		 * getter/setter �ʿ�! 
		 * 
		 * IP, Port �Ѵ� String���� setText �ؼ� �־��µ�, 
		 * �򰥸��� ���ƾ� �� �κ�!! *********
		 * GUI(ȭ�鿡 ���̴� �κ�)�� �� String�� -> �׷��� String���� setText��
		 * �ٵ� ��Ʈ��ũ�� �������� port�� ���ڷ� �԰�, Ip�� 1.2.3.4 �̴ϱ� .������ ���ڿ��� �� 
		 */
		
		try {
			this.serverAddress = InetAddress.getByName(serverIP);
			socket = new DatagramSocket(myPort);
			
			socket.setSoTimeout(500);		// soTimeout : socket Timeout
			socket.setReuseAddress(true);	// OS�� ȸ���� �ߵ� ���ߵ� ������ ��� �� ��ȣ�� �ٽ� �����ְ� 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// udpSender(), receiver() �Ѵ� infinity loop�� �޼ҵ�ȭ�ؼ� thread�� ������ ���ÿ� �� �� ����
		// �ȱ׷� �ϳ� ���� ���������� ������ ���۵� ���� 
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				udpSender();
			}
			
		});
		
		if(this.frame.getReceiveClient().isSelected())
		{
			Thread thread2 = new Thread(new Runnable() {
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					receiver();
				}
				
			});
			thread2.start();
		}
			
		thread1.start();
		
	}
	
	public void udpSender()
	{
		// ���� �����Ͱ� �ֳ�?
		while(true)		// infinity loop
		{
			// stop ���������� ���� Ȯ���ϰ�, stop �������� break;
			if(this.frame.isUdpClientMode() == false)
				break;			
			
			if(this.frame.isUdpClientReadyFlag() == true)	// stop �ȴ��� ���¸� ���� 
			{
				// display �о.. ����.. ������ ����
				// display : private�̶�, getter/setter �ʿ� 
				byte[] sendBuffer;
				counter = Integer.parseInt(this.frame.getCountSpinner().getValue().toString());
				sleepInterval = Integer.parseInt(this.frame.getSleepSpinner().getValue().toString());
				
				sendBuffer = this.frame.getDisplay().getText().getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
				
				try {
					
					for(int i=1; i<=counter; i++) // ����ڰ� ���� repeat count ��ŭ �ݺ� 
					{
						if(this.frame.isUdpClientMode() == false)
							break;
						
						socket.send(sendPacket);
						
						// table ���
						int nextTableNo = this.frame.getTableNo() + 1;
						
						table = this.frame.getTable();
						nextTableNo = this.frame.getTableModel().getRowCount() + 1; // rowCount 0�����̹Ƿ� +1 �ؾ� 1���� 
						
						tableModel = (DefaultTableModel) table.getModel();	// ���̺�� : �� ���� �ε������� 
						Object[] tmp = new Object[] {nextTableNo, "Out", sendPacket.getAddress().getHostAddress(), 
														sendPacket.getPort(), new String(sendBuffer)};
						this.frame.setTableModel(tableModel);
						this.frame.getTableModel().addRow(tmp);
						
						// ������ �������� ���̺� ��� (�ֽŵ����Ͱ� ���� ������ ������) 
						this.frame.getTableModel().moveRow(	// (start, end, to)
							this.frame.getTableModel().getRowCount()-1, 
							this.frame.getTableModel().getRowCount()-1, 
							0
						);
						
						try {
							Thread.sleep(sleepInterval); // ����ڰ� ���� sleep(msec)��ŭ ���ڱ� 
							
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					this.frame.getDisplay().setText("");
					// ��� �������ϱ� �ٽ� ���� ������ �������� �ٲ�� 
					this.frame.setUdpClientReadyFlag(false);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			// file�� ���µ�, ���ҵ� �������...
			try {
				Thread.sleep(500); 	// 0.5�ʸ��� while�� ���ѷ��� �ٽ� ���鼭 �˻� 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// ����� �������Դٴ� ����, stop������ while�� break�� ��!
		try {
			if(socket != null)
				socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void receiver()
	{
		while(true)	// infinity loop : �����Ͱ� ������ ��� ��ٷ� 
		{
			// UDPClient():constructor�� ���ѷ�����, �굵 ���ѷ����� �ϳ��� �ȳ����� �������� ���۵� ����
			// ���� ���ÿ� �������� thread�� �������� (�Ѵ� �޼ҵ�� ����..) -> udpSender(), receiver()
			
			
			// stop ���������� ���� Ȯ���ϰ�, stop �������� break;
			if(this.frame.isUdpClientMode() == false)
				break;
			
			byte[] buffer = new byte[1024]; 	// buffer = temporary memory, 2^n ���·� ���� 
			packet = new DatagramPacket(buffer, buffer.length); // 1024byte�� ������ �ɰ��� ����
			
			try {
				System.out.println("wait...");
				socket.receive(packet);	// receive : ����ϰ��ִ´�
				
				System.out.println("receive..."); // �����͸� ������������ ������� ���� 
				
//				display.append("KBStar << " + new String(buffer) + "\n"); // byte -> String���� �޽��� ��ȯ
//				display.setCaretPosition(display.getDocument().getLength()); // ��ũ�� �������鼭 ��� �� ������ ��Ŀ������
				
				table = this.frame.getTable();
				int nextTableNo = table.getRowCount() + 1; // ó���� RowCount = 0�̴ϱ�, +1 �ؼ� 1������ �ѹ� �����!
				tableModel = (DefaultTableModel)table.getModel();
				
				// no, in/out, ip, port, message
				Object[] tmp = new Object[] {nextTableNo, "In", packet.getAddress().getHostAddress(), packet.getPort(), new String(buffer)};
				
				this.frame.setTableModel(tableModel);
				this.frame.getTableModel().addRow(tmp);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);	// 1sec
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("UDP Receiver..");
		}
	}
}
