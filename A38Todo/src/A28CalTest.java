import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalFrame extends JFrame implements ActionListener
{
	private JPanel display, button, debug;
	private JTextField input, prev, op, flag;
	private JButton[] btns;
	private JButton plus, minus, divide, product, equal, ce;
	private JLabel prevL, opL, flagL;
	
	public CalFrame()
	{
		this.setTitle("계산기연습2");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font1 = new Font("Gothic", Font.BOLD, 30);
		
		this.setLayout(new BorderLayout(10,10));
		display = new JPanel();
		button = new JPanel();
		debug = new JPanel();
		
		display.setLayout(new FlowLayout());
		button.setLayout(new GridLayout(0,4, 10,10));
		debug.setLayout(new FlowLayout());
		
		display.setBackground(Color.green);
		button.setBackground(Color.white);
		debug.setBackground(Color.blue);
		
		input = new JTextField(13);
		input.setFont(font1);
		input.setText("0");
		input.setHorizontalAlignment(JTextField.RIGHT);
		display.add(input);
		
		this.add(display, BorderLayout.NORTH);
		this.add(button, BorderLayout.CENTER);
		this.add(debug, BorderLayout.SOUTH);
		
		btns = new JButton[10];
		for(int i = 0; i < 10; i++)
		{
			btns[i] = new JButton("" + i);		
			btns[i].setFont(font1);
			btns[i].addActionListener(this);
		}
		plus = new JButton("+");
		minus = new JButton("-");
		divide = new JButton("/");
		product = new JButton("*");
		equal = new JButton("=");
		ce = new JButton("CE");
		
		plus.setFont(font1);
		minus.setFont(font1);
		divide.setFont(font1);
		product.setFont(font1);
		equal.setFont(font1);
		ce.setFont(font1);
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		divide.addActionListener(this);
		product.addActionListener(this);
		equal.addActionListener(this);
		ce.addActionListener(this);
		
		button.add(btns[1]);
		button.add(btns[2]);
		button.add(btns[3]);
		button.add(plus);
		
		button.add(btns[4]);
		button.add(btns[5]);
		button.add(btns[6]);
		button.add(minus);
		
		button.add(btns[7]);
		button.add(btns[8]);
		button.add(btns[9]);
		button.add(product);
		
		button.add(btns[0]);
		button.add(divide);
		button.add(equal);
		button.add(ce);
		
		prev = new JTextField(10);
		op = new JTextField(10);
		flag = new JTextField(10);
		
		prevL = new JLabel("prev");
		opL = new JLabel("op");
		flagL = new JLabel("flag");
		
		prevL.setForeground(Color.white);
		opL.setForeground(Color.white);
		flagL.setForeground(Color.white);
		
		debug.add(prevL);
		debug.add(prev);
		debug.add(opL);
		debug.add(op);
		debug.add(flagL);
		debug.add(flag);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	// TODO Auto-generated method stub
		
		for(int i = 0; i < btns.length; i++)
		{
			if(e.getSource() == btns[i])
			{
				if(input.getText().equals("0"))
				{
					input.setText("" + i);
				} else
				{
					if(op.getText().equals(""))
					{
						input.setText(input.getText() + i);
					} else
					{
						if(flag.getText().equals(""))
						{
							flag.setText("ing");
							input.setText("" + i);
						} else
						{
							input.setText(input.getText() + i);
						}
					}
				}
			}
		}
		
		if(e.getSource() == plus)
		{
			op.setText("+");
			prev.setText(input.getText());
		} else if(e.getSource() == minus)
		{
			op.setText("-");
			prev.setText(input.getText());
		} else if(e.getSource() == product)
		{
			op.setText("*");
			prev.setText(input.getText());
		} else if(e.getSource() == divide)
		{
			op.setText("/");
			prev.setText(input.getText());
		} else if(e.getSource() == equal)
		{
			double num1 = Double.parseDouble(prev.getText());
			double num2 = Double.parseDouble(input.getText());
			
			if(op.getText().equals("+"))
			{
				input.setText("" + (num1 + num2));
			} else if(op.getText().equals("-"))
			{
				input.setText("" + (num1 - num2));
			} else if(op.getText().equals("*"))
			{
				input.setText("" + (num1 * num2));
			} else if(op.getText().equals("/"))
			{
				input.setText("" + (num1 / num2));
			}
			
			op.setText("");
			prev.setText("");
			flag.setText("");
			
		} else if(e.getSource() == ce)
		{
			op.setText("");
			prev.setText("");
			flag.setText("");
			input.setText("");
		}
	}
}	


public class A28CalTest 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		CalFrame frame = new CalFrame();
	}

}
