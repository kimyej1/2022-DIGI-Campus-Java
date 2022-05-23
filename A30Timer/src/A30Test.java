
// Thread�� Runnable Interface�� ����..

class Bell implements Runnable
{
	private int ms; 	// �и�����, �ʴ����� �Է¹ޱ� ���� ��ȯ��
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
			// 1�� ����..
			// Thread.sleep(1000); -> 1,000 �и�����
			//Unhandled Exception ---> try/catch �־��
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			//counter++;
			System.out.println(++counter); // ���� ������Ű��(counter++ ���) ���
			if (counter >= 100)
			{
				break;
			}
		}
		*/
	}

}
