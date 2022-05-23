import java.util.Scanner;

class CircularQueue
{
	private int[] circularQueue;
	private int front, rear;
	
	public CircularQueue(int size)
	{
		circularQueue = new int[size];
		front = -1;
		rear = -1;
	}
	
	private void printError(String errorMsg) // 내부에서만 쓰려고 
	{
		System.out.println(errorMsg);
	}
	
	public boolean isFull()
	{
		if((this.rear + 1) % this.circularQueue.length == 0)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty()
	{
		if(this.front == this.rear)
		{
			return true;
		}
		return false;
	}
	
	public void pop()
	{
		if(isEmpty() == true)
		{
			printError("Queue is Empty");
			return;
		}
		System.out.println("circularQueue[" + rear + "] = " + circularQueue[rear] + "을 제거합니다.");
		rear--;
	}
	
	public void dump() // 처음부터 끝까지 다 보여줘~
	{
		System.out.println("==== Queue ====");
		
		for(int i = rear; i >= front; i--)
		{
			System.out.println(circularQueue[i]);
		}
	}
	
	public void push(int value) // 값을 주면 push해서 넣는 역할 
	{
		if(isFull() == true)
		{
			printError("Stack is Full");
			return;
		}
		circularQueue[front] = value;
	}
}

public class B20Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int cmd;
		int input;
		
		System.out.print("Insert Stack Size : ");
		int size = scan.nextInt();
		CircularQueue queue = new CircularQueue(size); 
		
		while(true)
		{
			System.out.print("[1]Push [2]Pop [3]Dump [4]Exit : ");
			cmd = scan.nextInt();
			
			if(cmd == 1)
			{
				System.out.print("Insert Input : ");
				input = scan.nextInt();
				queue.push(input);
			} else if(cmd == 2)
			{
				queue.pop();
				
			} else if(cmd == 3)
			{
				queue.dump();
				
			} else if(cmd == 4)
			{
				System.out.println("Bye~");
				break;
			}
		}
		
		scan.close();
	}

}
