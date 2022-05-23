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
	
	public void pop() // 맨 꼭대기 값을 빼내는 역할 (꼭대기 빼는거라 몇번째 값 빼는건지 줄 필요 없음) 
	{
		if(isEmpty() == true)
		{
			printError("Stack is Empty");
			return;
		}
		top--; // top까지 보라고 하기만 하고, 굳이 지우지는 않음 
	}
	
	public void dump() // 처음부터 끝까지 다 보여줘~
	{
		System.out.println("==== Stack ====");
		
		for(int i = top; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	public void push(int value) // 값을 주면 push해서 넣는 역할 
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
		Stack stack = new Stack(stackSize); // 입력받은 사이즈로 스택만들기 
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
