import javax.swing.JFrame;

class MyFrame extends JFrame
{
	public MyFrame()
	{
		createFrame();
		// createMenu();
	}
	
	public void createFrame() // 프레임 만드는 함수를 만들어서 사용하기도 함 
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		this.setVisible(true);
	}
}

public class B27Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
