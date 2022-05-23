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
	
	public Stack(int size) // 5로 고정하지 않고 가변적인 크기의 Stack 만들기 
	{
		stack = new int[size];
		top = -1;
	}
	
	private void printError(String errorMsg) // 내부에서만 쓰려고 
	{
		System.out.println(errorMsg);
	}
	
	public boolean isFull() // stack이 꽉찼는지 알려면 top이 4인지 보면 됨 (5개짜리 배열이니까 0~4 인덱스) 
	{
		if(this.top >= this.stack.length -1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() // top = -1이면 비어있는 것 
	{
		if(this.top == -1)
		{
			return true;
		}
		return false;
	}
	
	synchronized public void pop() // 맨 꼭대기 값을 빼내는 역할 (꼭대기 빼는거라 몇번째 값 빼는건지 줄 필요 없음) 
	// synchronized : 메모리 충돌여지가 있을 때 OS가 개입
	{
		if(isEmpty() == true)
		{
			printError("Stack is Empty");
			return;
		}
		top--; // top까지 보라고 하기만 하고, 굳이 지우지는 않음 
	}
	
	synchronized public void dump() // 처음부터 끝까지 다 보여줘~
	{
		System.out.println("==== Stack ====");
		
		for(int i = top; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	synchronized public void push(int value) // 값을 주면 push해서 넣는 역할 
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

class Producer implements Runnable // 데이터 생산/Push만 하는 역할 
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
				sleepTime = (int)(Math.random()*2000); // 0~2초 사이 랜덤한 시간 
				
				Thread.sleep(sleepTime);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			// random..
			// int pushValue = (int)(Math.random() * 1000); 이렇게 랜덤값 Push해도되고, sleepTime 갖다써도됨! 
			stack.push(sleepTime);
		}
		
	}
	
}

class Consumer implements Runnable // pop만 하는 역할 
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
			sleepTime = (int)(Math.random()*2000); // 0~2초 사이 랜덤한 시간 
			
			Thread.sleep(sleepTime);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		stack.pop(); // pop doesn't need a parameter
	}
}

class Monitor implements Runnable // dump만 하는 역할 
{
	private Stack stack;
	
	public Monitor(Stack stack) // 같은 스택을 계속 공유할거야 
	{
		this.stack = stack;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{	
			try {	
				Thread.sleep(1000); // push/pop은 시간이 달라도 되지만, dump는 시간이 일정해야함 
				
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
		Stack stack = new Stack(stackSize); // 입력받은 사이즈로 스택만들기 
		
		// new Producer(stack)
		// new Consumer(stack);
		
		Producer p = new Producer(stack);
		Consumer c = new Consumer(stack);
		Monitor  m = new Monitor(stack);
		
		Thread tp = new Thread(p); // producer를 파라미터로
		Thread tc = new Thread(c);
		Thread tm = new Thread(m);
		
		tp.start();
		tc.start();
		tm.start();
		
		
		scan.close();
	}

}
