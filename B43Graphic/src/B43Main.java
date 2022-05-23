import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		this.setLayout(new BorderLayout()); 		 	// center¿¡ component ³ÖÀ¸·Á°í 
		this.add(new MyComponent(), BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}

class MyComponent extends JComponent
{
	public void paint(Graphics g)
	{
		g.setColor(Color.black); 						   // º×¿¡ »¡°£°Å ¹¯ÇôµÒ.. ÀÌÁ¦ ¹» ÇÏµç ´Ù »¡°£»öÀÓ!
		Font font = new Font("Dialog", Font.BOLD, 10); // dialog : »ßÄ§ÀÌ ¾ø´Â ÆùÆ®
		g.setFont(font);
		
		g.drawString("2D Graphic Test", 100, 30); 	   // 100 from left, 50 from top
//		g.drawString("ÇÑ±Û", 300, 200);
//		
//		g.drawLine(50, 50, 450, 50); 					// startX, startY, endX, endY
//		g.drawLine(50, 450, 450, 450);
		
		/*
		for(int i=50; i<=450; i+=50)
		{
			for(int j=50; j<=450; j+=50)
			{
				g.drawLine(50, i, 450, j);
				g.drawLine(i, 50, j, 450);
			}
		}
		*/
		
		g.setColor(Color.blue);
		
		// Rect
		g.drawRect(50, 50, 400, 400);
		g.fillRect(60, 60, 380, 380);
		
		g.setColor(Color.yellow);
		
		// Oval
		g.fillOval(100, 200, 300, 100);
	}
}

public class B43Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame();
	}

}
