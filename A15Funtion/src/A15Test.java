
//public class Car 

class Car
{
	// ���� ����(����)
	int speed = 0;
	String maker;
	double rate;
	
	void startEngine()
	{
		System.out.println("start Engine");
	}
	
	void stopEngine()
	{
		System.out.println("stop Engine");
	}
	
	int speedUp()
	{
		System.out.println("speed Up");
		return speed + 10;
	}
	
	int speedDown()
	{
		System.out.println("speed Down");
		return speed - 10;
	}
	

}


public class A15Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		int a = 3, b = 4;
		int result;
		
		result = add(a,b); // �޼ҵ� ȣ�� -> ��� (function call)
		System.out.println("result = " + result);
		
		result = add(973,46); // �޼ҵ� ȣ�� -> ���
		System.out.println("result = " + result);
		
		
		Car sonata = new Car();
		Car k5 = new Car();
		Car taxi = new Car(); // �ܿ��
		
		sonata.speed = 77;
		k5.speed = 44;
		
		System.out.println("sonata.speed = " + sonata.speed);
		k5.speed = k5.speedUp();
		System.out.println("k5.speed = " + k5.speed);
		
	}
	


	public static int add(int x, int y) // �޼ҵ� ������ �κ�
	{
		System.out.println("x = " + x + ", y = " + y);
		return x + y + 3; // �� add�� a+b�� �ƴ϶�, ����� ���� �� ����!
		// return ������ ���� -> 'int' add()�� �������� �ְڴٴ� �ǹ̶�~
	}
		
	
}
