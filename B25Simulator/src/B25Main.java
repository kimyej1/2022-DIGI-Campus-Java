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
	
	synchronized public void pop() // �� ����� ���� ������ ���� (����� ���°Ŷ� ���° �� ���°��� �� �ʿ� ����) 
	// synchronized : �޸� �浹������ ���� �� OS�� ����
	{
		if(isEmpty() == true)
		{
			printError("Stack is Empty");
			return;
		}
		top--; // top���� ����� �ϱ⸸ �ϰ�, ���� �������� ���� 
	}
	
	synchronized public void dump() // ó������ ������ �� ������~
	{
		System.out.println("==== Stack ====");
		
		for(int i = top; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	synchronized public void push(int value) // ���� �ָ� push�ؼ� �ִ� ���� 
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

class Producer implements Runnable // ������ ����/Push�� �ϴ� ���� 
{
	private Stack stack;
	
	public Producer(Stack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			int sleepTime = 0;
			
			try {
				sleepTime = (int)(Math.random()*2000); // 0~2�� ���� ������ �ð� 
				
				Thread.sleep(sleepTime);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			// random..
			// int pushValue = (int)(Math.random() * 1000); �̷��� ������ Push�ص��ǰ�, sleepTime ���ٽᵵ��! 
			stack.push(sleepTime);
		}
		
	}
	
}

class Consumer implements Runnable // pop�� �ϴ� ���� 
{
	private Stack stack;
	
	public Consumer(Stack stack)
	{
		this.stack = stack;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int sleepTime = 0;
		
		try {
			sleepTime = (int)(Math.random()*2000); // 0~2�� ���� ������ �ð� 
			
			Thread.sleep(sleepTime);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		stack.pop(); // pop doesn't need a parameter
	}
}

class Monitor implements Runnable // dump�� �ϴ� ���� 
{
	private Stack stack;
	
	public Monitor(Stack stack) // ���� ������ ��� �����Ұž� 
	{
		this.stack = stack;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{	
			try {	
				Thread.sleep(1000); // push/pop�� �ð��� �޶� ������, dump�� �ð��� �����ؾ��� 
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			stack.dump();
		}
		
	}
}

public class B25Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int cmd;
		int stackSize;
		
		System.out.print("Insert Stack Size : "); // 10
		stackSize = scan.nextInt();
		Stack stack = new Stack(stackSize); // �Է¹��� ������� ���ø���� 
		
		// new Producer(stack)
		// new Consumer(stack);
		
		Producer p = new Producer(stack);
		Consumer c = new Consumer(stack);
		Monitor  m = new Monitor(stack);
		
		Thread tp = new Thread(p); // producer�� �Ķ���ͷ�
		Thread tc = new Thread(c);
		Thread tm = new Thread(m);
		
		tp.start();
		tc.start();
		tm.start();
		
		
		scan.close();
	}

}
