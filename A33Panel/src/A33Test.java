import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class KbFrame extends JFrame
{
	private JPanel panel;
	private JButton btn1, btn2, btn3;
	private JTextField tf;
	private JLabel label;
	
	public KbFrame()
	{
		this.setTitle("KBStar");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);									// ������� ������ �Ѽ�Ʈ
	}

	public KbFrame(String title)
	{
		this.setTitle(title);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		btn1 = new JButton("button 1");
		btn2 = new JButton("button 2");
		btn3 = new JButton("button 3"); // �гο� �갡 �پ�ߵ�
		
		tf = new JTextField(10);
		label = new JLabel();
		
		label.setText("ID");
		panel.add(label);
		panel.add(tf);
		
		btn3.setToolTipText("Tooltip");
		btn2.setEnabled(false);
		
		panel.add(btn1); // �гο� ��ư ���̱�
		panel.add(btn2);
		panel.add(btn3);
		
		this.add(panel); // �����ӿ� �г� ���̱�
		
		this.setVisible(true);	
	}
}


public class A33Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		KbFrame frame = new KbFrame("KB* GUI");
	}

}
