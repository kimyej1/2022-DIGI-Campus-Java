
//public class Car 

class Car
{
	// 상태 정보(변수)
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
		
		result = add(a,b); // 메소드 호출 -> 사용 (function call)
		System.out.println("result = " + result);
		
		result = add(973,46); // 메소드 호출 -> 사용
		System.out.println("result = " + result);
		
		
		Car sonata = new Car();
		Car k5 = new Car();
		Car taxi = new Car(); // 외우기
		
		sonata.speed = 77;
		k5.speed = 44;
		
		System.out.println("sonata.speed = " + sonata.speed);
		k5.speed = k5.speedUp();
		System.out.println("k5.speed = " + k5.speed);
		
	}
	


	public static int add(int x, int y) // 메소드 정의한 부분
	{
		System.out.println("x = " + x + ", y = " + y);
		return x + y + 3; // 꼭 add가 a+b가 아니라, 맘대로 만들 수 있음!
		// return 없으면 에러 -> 'int' add()가 정수값을 주겠다는 의미라서~
	}
		
	
}
