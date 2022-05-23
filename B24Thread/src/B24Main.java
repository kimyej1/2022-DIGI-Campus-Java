class Bell implements Runnable
{
	private String name;
	private int interval; // 
	
	public Bell(String name, int sec)
	{
		this.name = name;
		this.interval = sec * 1000;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<100; i++)
		{
			try {
				Thread.sleep(interval);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(name + " : " + i);
		}
		
	}
	
}


// Thread
public class B24Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=10; i>=0; i--)
		{
			try {
				Thread.sleep(1000); // 1000ms = 1s, Unhandled Exception 오류나면 try 안에 넣자!
			} catch (Exception e) {
				// TODO: handle exception
			}			
			System.out.println(i);
		}
		
		Bell one = new Bell("one", 1);
		Bell three = new Bell("three", 3);
		Bell five = new Bell("five", 5);
		
		Thread t1 = new Thread(one);
		Thread t3 = new Thread(three);
		Thread t5 = new Thread(five);
		
		t1.start();
		t3.start();
		t5.start();
	}

}
