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
	
	private JTable table;	// main의 테이블 하나하나 Get/set하기 번거로우니, 통째로 만들어서 그냥 넣어버릴래 
	private Vector<String> userColumn = new Vector<String>();
	private Vector<String> userRow;
	private DefaultTableModel tableModel;
	
	private int counter;
	private int sleepInterval;
	
	
	public UDPClient(NetworkSimulator frame) // constructor param : frame
	{
		this.frame = frame; // main.java의 networkSimulator를 통째로 받아옴 -> 그래서 함수도 다 쓸 수 있음
		
		serverIP = this.frame.getInputIP().getText();						// ip : String
		serverPort = Integer.parseInt(this.frame.getInputPort().getText()); // port : int
		
		/*
		 * this.frame.inputPort 이렇게 하고싶은데.. inputPort = private	이라 여기선 안보임
		 * getter/setter 필요! 
		 * 
		 * IP, Port 둘다 String으로 setText 해서 넣었는데, 
		 * 헷갈리지 말아야 할 부분!! *********
		 * GUI(화면에 보이는 부분)은 다 String임 -> 그래서 String으로 setText함
		 * 근데 네트워크로 보낼때는 port는 숫자로 왔고, Ip는 1.2.3.4 이니까 .때문에 문자열로 옴 
		 */
		
		try {
			this.serverAddress = InetAddress.getByName(serverIP);
			socket = new DatagramSocket(myPort);
			
			socket.setSoTimeout(500);		// soTimeout : socket Timeout
			socket.setReuseAddress(true);	// OS가 회수를 했든 안했든 소켓이 썼던 그 번호를 다시 쓸수있게 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// udpSender(), receiver() 둘다 infinity loop라서 메소드화해서 thread로 돌려야 동시에 돌 수 있음
		// 안그럼 하나 루프 끝날때까지 다음꺼 시작도 못함 
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
		// 보낼 데이터가 있냐?
		while(true)		// infinity loop
		{
			// stop 눌러졌는지 먼저 확인하고, stop 눌렀으면 break;
			if(this.frame.isUdpClientMode() == false)
				break;			
			
			if(this.frame.isUdpClientReadyFlag() == true)	// stop 안눌른 상태면 수행 
			{
				// display 읽어서.. 전송.. 보내는 버퍼
				// display : private이라, getter/setter 필요 
				byte[] sendBuffer;
				counter = Integer.parseInt(this.frame.getCountSpinner().getValue().toString());
				sleepInterval = Integer.parseInt(this.frame.getSleepSpinner().getValue().toString());
				
				sendBuffer = this.frame.getDisplay().getText().getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
				
				try {
					
					for(int i=1; i<=counter; i++) // 사용자가 정한 repeat count 만큼 반복 
					{
						if(this.frame.isUdpClientMode() == false)
							break;
						
						socket.send(sendPacket);
						
						// table 출력
						int nextTableNo = this.frame.getTableNo() + 1;
						
						table = this.frame.getTable();
						nextTableNo = this.frame.getTableModel().getRowCount() + 1; // rowCount 0부터이므로 +1 해야 1부터 
						
						tableModel = (DefaultTableModel) table.getModel();	// 테이블모델 : 맨 윗줄 인덱스라인 
						Object[] tmp = new Object[] {nextTableNo, "Out", sendPacket.getAddress().getHostAddress(), 
														sendPacket.getPort(), new String(sendBuffer)};
						this.frame.setTableModel(tableModel);
						this.frame.getTableModel().addRow(tmp);
						
						// 데이터 역순으로 테이블에 출력 (최신데이터가 가장 상위로 오도록) 
						this.frame.getTableModel().moveRow(	// (start, end, to)
							this.frame.getTableModel().getRowCount()-1, 
							this.frame.getTableModel().getRowCount()-1, 
							0
						);
						
						try {
							Thread.sleep(sleepInterval); // 사용자가 정한 sleep(msec)만큼 잠자기 
							
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					this.frame.getDisplay().setText("");
					// 출력 끝났으니까 다시 보낼 데이터 없음으로 바꿔둠 
					this.frame.setUdpClientReadyFlag(false);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			// file을 보냈든, 말았든 관계없이...
			try {
				Thread.sleep(500); 	// 0.5초마다 while문 무한루프 다시 돌면서 검사 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// 여기로 빠져나왔다는 말은, stop눌러서 while문 break된 것!
		try {
			if(socket != null)
				socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void receiver()
	{
		while(true)	// infinity loop : 데이터가 오는지 계속 기다려 
		{
			// UDPClient():constructor도 무한루프고, 얘도 무한루프라 하나가 안끝나면 다음꺼는 시작도 못함
			// 둘이 동시에 돌리려면 thread로 만들어야함 (둘다 메소드로 빼서..) -> udpSender(), receiver()
			
			
			// stop 눌러졌는지 먼저 확인하고, stop 눌렀으면 break;
			if(this.frame.isUdpClientMode() == false)
				break;
			
			byte[] buffer = new byte[1024]; 	// buffer = temporary memory, 2^n 형태로 만듬 
			packet = new DatagramPacket(buffer, buffer.length); // 1024byte씩 데이터 쪼개서 받음
			
			try {
				System.out.println("wait...");
				socket.receive(packet);	// receive : 대기하고있는다
				
				System.out.println("receive..."); // 데이터를 받을때까지는 출력하지 않음 
				
//				display.append("KBStar << " + new String(buffer) + "\n"); // byte -> String으로 메시지 전환
//				display.setCaretPosition(display.getDocument().getLength()); // 스크롤 내려가면서 계속 맨 밑으로 포커스유지
				
				table = this.frame.getTable();
				int nextTableNo = table.getRowCount() + 1; // 처음엔 RowCount = 0이니까, +1 해서 1번부터 넘버 세라고!
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
