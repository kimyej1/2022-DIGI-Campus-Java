import java.util.Scanner;

class Stack
{
	private int[] stack;
	private int top;
	
	public Stack()
	{
		stack = new int[5];
		top = -1;
	}
	
	public Stack(int size) // 5�� �������� �ʰ� �������� ũ���� Stack ����� 
	{
		stack = new int[size];
		top = -1;
	}
	
	private void printError(String errorMsg) // ���ο����� ������ 
	{
		System.out.println(errorMsg);
	}
	
	public boolean isFull() // stack�� ��á���� �˷��� top�� 4���� ���� �� (5��¥�� �迭�̴ϱ� 0~4 �ε���) 
	{
		if(this.top >= this.stack.length -1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() // top = -1�̸� ����ִ� �� 
	{
		if(this.top == -1)
		{
			return true;
		}
		return false;
	}
	
	public void pop() // �� ����� ���� ������ ���� (����� ���°Ŷ� ���° �� ���°��� �� �ʿ� ����) 
	{
		if(isEmpty() == true)
		{
			printError("Stack is Empty");
			return;
		}
		top--; // top���� ����� �ϱ⸸ �ϰ�, ���� �������� ���� 
	}
	
	public void dump() // ó������ ������ �� ������~
	{
		System.out.println("==== Stack ====");
		
		for(int i = top; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	public void push(int value) // ���� �ָ� push�ؼ� �ִ� ���� 
	{
		if(isFull() == true)
		{
			printError("Stack is Full");
			return;
		}
		// stack[++top] = value;
		top++;
		stack[top] = value;
	}
}

public class B17Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int cmd;
		int stackSize;
		
		System.out.print("Insert Stack Size : ");
		stackSize = scan.nextInt();
		Stack stack = new Stack(stackSize); // �Է¹��� ������� ���ø���� 
		int input;
		
		while(true)
		{
			System.out.print("[1]Push [2]Pop [3]Dump [4]Exit : ");
			cmd = scan.nextInt();
			
			if(cmd == 1)
			{
				System.out.print("Insert Input : ");
				input = scan.nextInt();
				stack.push(input);
			} else if(cmd == 2)
			{
				stack.pop();
				
			} else if(cmd == 3)
			{
				stack.dump();
				
			} else if(cmd == 4)
			{
				System.out.println("Bye~");
				break;
			}
		}
		
		scan.close();
	}

}
