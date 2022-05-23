class Car
{
	private String name;
	private int speed;
	private boolean engineOn; // boolean은 default가 false!
	
	
	/*
	 * 생성자: Constructor = 초기화 메소드
	 *   1. 리턴 타입이 없다.
	 *   2. 클래스 이름과 같다.
	 *   3. 생성자가 없으면 시스템이 알아서 만들어주지만
	 *   	하나라도 있으면, 프로그래머의 의지를 반영한다.
	 */
	/*
	public boolean isEngineStatus() // 엔진상태가 T/F(말이안됨 -> 이름을 좀 더 명확히!(EngineOn 등)
	{
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) 
	{
		this.engineStatus = engineStatus; 
	}*/ 
	
	public boolean isEngineOn() // 엔진 켜진상태 -> T/F로 대답하기 조금 더 자연스러움
	{
		return engineOn;
	}

	public void setEngineOn(boolean engineOn) 
	{
		this.engineOn = engineOn;
	}
	
	public Car() // 디폴트 생성자(Default Constructor) : 파라미터 없음
	{
		System.out.println("Car()");
	}

	public Car(String name) // 복제 생성자(Copy Constructor)
	{
		this.name = name;
		this.speed = 0;
		this.engineOn = true;
		System.out.println("Car(String)");
	}
	
	public Car(String name, int speed)
	{
		this.name = name;
		this.speed = speed;
		System.out.println("Car(String, Speed)");
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public int setSpeed(int speed)
	{
		this.speed = speed;
		
		if(this.engineOn == false)
		{
			printError("엔진 상태를 확인하세요");
			return -1;
					
		} else if(speed <= 0)
		{
			printError("속도가 0보다 작습니다.");
			return -1;
		}

		System.out.println(this.speed);
		return this.speed;

	}
	
	public void print()
	{
		System.out.println("( name, speed, engineOn ) = ( " + this.name + ", " + this.speed + ", "+ this.engineOn + " )");
	}

	@Override
	public String toString() 
	{
		return "Car ( name, speed, engineOn ) = ( " + this.name + ", " + this.speed + ", "+ this.engineOn + " )";
	}
	
	private void printError(String msg)
	{
		System.out.println("MESSAGE : " + msg);
	}
	
}

public class A22Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub
		/*
		Car taxi = new Car();
		Car bus = new Car();
		Car truck = new Car("truck"); // name, speed 세팅되어있음
		Car bmw = new Car("BMW");
		Car kia = new Car("KIA", 77);
		boolean a;
		
		
		
		taxi.setName("TAXI");
		taxi.setSpeed(10);
		bus.setName("BUS");
		bus.setSpeed(20);
		truck.setName("TRUCK");
		truck.setSpeed(30);
		
		
		System.out.println("taxi Name = " + taxi.getName() + ", taxi Speed = " + taxi.getSpeed());
		System.out.println("bus Name = " + bus.getName() + ", bus Speed = " + bus.getSpeed());
		
		taxi.print();
		bus.print();
		bmw.print();
		
		System.out.println(taxi);
		System.out.println(bus);
		System.out.println(truck);
		
		
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		
		taxi.setSpeed(30);
		taxi.setEngineOn(true);
		taxi.setSpeed(-10);
		
		*/
	}

}
