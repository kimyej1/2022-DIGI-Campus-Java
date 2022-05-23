
// Thread는 Runnable Interface를 구현..

class Bell implements Runnable
{
	private int ms; 	// 밀리세컨, 초단위로 입력받기 위한 변환툴
	private String name;
	private int count;
	
	public Bell(String name, int sec)
	{
		this.name = name;
		this.ms = sec * 1000;
		this.count = 0;
	}
	
	@Override
	public void run() 
	{	// TODO Auto-generated method stub
		
		while(true)
		{
			try {
				Thread.sleep(ms);
				//count++;
				System.out.println(this.name + " : " + ++count);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class A30Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		
		Bell bell1 = new Bell("one", 1);
		Thread t1 = new Thread(bell1);
		t1.start();
		
		Bell bell3 = new Bell("three", 3);
		Thread t3 = new Thread(bell3);
		t3.start();
		
		Bell bell5 = new Bell("five", 5);
		Thread t5 = new Thread(bell5);
		t5.start();
		
		/*
		int counter = 0;
		
		while(true)
		{
			// 1초 쉬고..
			// Thread.sleep(1000); -> 1,000 밀리세컨
			//Unhandled Exception ---> try/catch 넣어라
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			//counter++;
			System.out.println(++counter); // 먼저 증가시키고(counter++ 대신) 출력
			if (counter >= 100)
			{
				break;
			}
		}
		*/
	}

}
