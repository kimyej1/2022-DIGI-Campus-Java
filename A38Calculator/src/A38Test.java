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

class CalculatorFrame extends JFrame implements ActionListener
{
	private JPanel displayPanel, buttonPanel, debugPanel;
	private JButton[] btns;
	private JButton btnPlus, btnMinus, btnProduct, btnDivide, btnEqual, btnCE;
	private JTextField tf, prev, op, flag;
	private JLabel prevL, opL, flagL;
	
	public CalculatorFrame(String title)
	{
		this.setTitle(title);
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font1 = new Font("Gothic", Font.BOLD, 20);
		Font font2 = new Font("Gothic", Font.BOLD|Font.ITALIC, 30);
		
		this.setLayout(new BorderLayout(10,10));
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		debugPanel = new JPanel();
		
		this.add(displayPanel, BorderLayout.NORTH);
		this.add(buttonPanel);
		this.add(debugPanel, BorderLayout.SOUTH);
		
		displayPanel.setLayout(new FlowLayout());
		displayPanel.setBackground(Color.orange);
		
		tf = new JTextField(10);
		tf.setText("0");
		tf.setFont(font2);
		tf.setHorizontalAlignment(JTextField.RIGHT); // 우측정렬
		displayPanel.add(tf);
		
		buttonPanel.setLayout(new GridLayout(0,4, 10,10));
		btns = new JButton[10];
		for(int i=0; i<btns.length; i++)
		{
			btns[i] = new JButton("" + i);
			btns[i].setFont(font1);
			btns[i].addActionListener(this);
		}
		
		btnPlus = new JButton("+"); 
		btnPlus.setFont(font1); 
		btnPlus.addActionListener(this);
		
		btnMinus = new JButton("-"); 
		btnMinus.setFont(font1); 
		btnMinus.addActionListener(this);
		
		btnProduct = new JButton("*"); 
		btnProduct.setFont(font1); 
		btnProduct.addActionListener(this);
		
		btnDivide = new JButton("/"); 
		btnDivide.setFont(font1); 
		btnDivide.addActionListener(this);
		
		btnEqual = new JButton("="); 
		btnEqual.setFont(font1); 
		btnEqual.addActionListener(this);
		
		btnCE = new JButton("CE"); 
		btnCE.setFont(font1); 
		btnCE.addActionListener(this);
		
		buttonPanel.add(btns[1]);
		buttonPanel.add(btns[2]);
		buttonPanel.add(btns[3]);
		buttonPanel.add(btnPlus);
		
		buttonPanel.add(btns[4]);
		buttonPanel.add(btns[5]);
		buttonPanel.add(btns[6]);
		buttonPanel.add(btnMinus);
		
		buttonPanel.add(btns[7]);
		buttonPanel.add(btns[8]);
		buttonPanel.add(btns[9]);
		buttonPanel.add(btnProduct);
		
		buttonPanel.add(btns[0]);
		buttonPanel.add(btnDivide);
		buttonPanel.add(btnEqual);
		buttonPanel.add(btnCE);
		
		debugPanel.setLayout(new FlowLayout());
		debugPanel.setBackground(Color.yellow);
		
		prev = new JTextField(6);
		op = new JTextField(6);
		flag = new JTextField(6);
		
		prevL = new JLabel("prev");
		opL = new JLabel("op");
		flagL = new JLabel("flag");
		
		debugPanel.add(prevL);
		debugPanel.add(prev);
		debugPanel.add(opL);
		debugPanel.add(op);
		debugPanel.add(flagL);
		debugPanel.add(flag);
		
		this.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
			
		if(e.getSource() == btnPlus)
		{
			if(flag.getText().equals("ing"))
			{
				double num1 = Double.parseDouble(prev.getText());
				double num2 = Double.parseDouble(tf.getText());
				
				if(op.getText().equals("+"))
				{
					prev.setText("" + (num1 + num2));
					flag.setText("");
					op.setText("+");
				} else if(op.getText().equals("-"))
				{
					prev.setText("" + (num1 - num2));
					flag.setText("");
					op.setText("+");
				} else if(op.getText().equals("*"))
				{
					prev.setText("" + (num1 * num2));
					flag.setText("");
					op.setText("+");
				} else if(op.getText().equals("/"))
				{
					prev.setText("" + (num1 / num2));
					flag.setText("");
					op.setText("+");
				}				
			} else
			{			
			prev.setText(tf.getText());
			op.setText("+");
			flag.setText("");
			}
		} else if(e.getSource() == btnMinus)
		{
			if(flag.getText().equals("ing"))
			{
				double num1 = Double.parseDouble(prev.getText());
				double num2 = Double.parseDouble(tf.getText());
				
				if(op.getText().equals("+"))
				{
					prev.setText("" + (num1 + num2));
					flag.setText("");
					op.setText("-");
				} else if(op.getText().equals("-"))
				{
					prev.setText("" + (num1 - num2));
					flag.setText("");
					op.setText("-");
				} else if(op.getText().equals("*"))
				{
					prev.setText("" + (num1 * num2));
					flag.setText("");
					op.setText("-");
				} else if(op.getText().equals("/"))
				{
					prev.setText("" + (num1 / num2));
					flag.setText("");
					op.setText("-");
				}				
			} else
			{
				op.setText("-");
				prev.setText(tf.getText());
				flag.setText("");
			}
		} else if(e.getSource() == btnProduct)
		{
			if(flag.getText().equals("ing"))
			{
				double num1 = Double.parseDouble(prev.getText());
				double num2 = Double.parseDouble(tf.getText());
				
				if(op.getText().equals("+"))
				{
					prev.setText("" + (num1 + num2));
					flag.setText("");
					op.setText("*");
				} else if(op.getText().equals("-"))
				{
					prev.setText("" + (num1 - num2));
					flag.setText("");
					op.setText("*");
				} else if(op.getText().equals("*"))
				{
					prev.setText("" + (num1 * num2));
					flag.setText("");
					op.setText("*");
				} else if(op.getText().equals("/"))
				{
					prev.setText("" + (num1 / num2));
					flag.setText("");
					op.setText("*");
				}				
			} else
			{
				op.setText("*");
				prev.setText(tf.getText());
				flag.setText("");
			}
		} else if(e.getSource() == btnDivide)
		{
			if(flag.getText().equals("ing"))
			{
				double num1 = Double.parseDouble(prev.getText());
				double num2 = Double.parseDouble(tf.getText());
				
				if(op.getText().equals("+"))
				{
					prev.setText("" + (num1 + num2));
					flag.setText("");
					op.setText("/");
				} else if(op.getText().equals("-"))
				{
					prev.setText("" + (num1 - num2));
					flag.setText("");
					op.setText("/");
				} else if(op.getText().equals("*"))
				{
					prev.setText("" + (num1 * num2));
					flag.setText("");
					op.setText("/");
				} else if(op.getText().equals("/"))
				{
					prev.setText("" + (num1 / num2));
					flag.setText("");
					op.setText("/");
				}				
			} else
			{
				op.setText("/");
				prev.setText(tf.getText());
				flag.setText("");
			}
		} else if(e.getSource() == btnEqual)
		{
			double num1 = Double.parseDouble(prev.getText());
			double num2 = Double.parseDouble(tf.getText());
			
			if(op.getText().equals("+"))
			{
				tf.setText("" + (num1 + num2));
				prev.setText("");
				flag.setText("");
			} else if(op.getText().equals("-"))
			{
				tf.setText("" + (num1 - num2));	
				prev.setText("");
				flag.setText("");
			} else if(op.getText().equals("*"))
			{
				tf.setText("" + (num1 * num2));
				prev.setText("");
				flag.setText("");
			} else if(op.getText().equals("/"))
			{
				tf.setText("" + (num1 / num2));
				prev.setText("");
				flag.setText("");
			}		
			op.setText("");
		} else if(e.getSource() == btnCE)
		{
			tf.setText("0");
			prev.setText("");
			op.setText("");
			flag.setText("");
		} else
		{	
			for(int i = 0; i < btns.length; i++)
			{
				if(e.getSource() == btns[i])
				{
					if(tf.getText().equals("0"))
					{
						tf.setText("" + i);
					}else
					{
						if(op.getText().equals(""))
						{
							tf.setText(tf.getText() + i);
						}else
						{
							if(flag.getText().equals(""))
							{
								tf.setText(""+i);
								flag.setText("ing");
							}else
							{
								tf.setText(tf.getText() + i);
							}
						}
					}	
				}
			}
		}
	}
}


public class A38Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		CalculatorFrame frame = new CalculatorFrame("Calculator");
	}

}
