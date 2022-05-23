class Car
{
	private String name;
	private int speed;
	private boolean engineOn; // boolean�� default�� false!
	
	
	/*
	 * ������: Constructor = �ʱ�ȭ �޼ҵ�
	 *   1. ���� Ÿ���� ����.
	 *   2. Ŭ���� �̸��� ����.
	 *   3. �����ڰ� ������ �ý����� �˾Ƽ� �����������
	 *   	�ϳ��� ������, ���α׷����� ������ �ݿ��Ѵ�.
	 */
	/*
	public boolean isEngineStatus() // �������°� T/F(���̾ȵ� -> �̸��� �� �� ��Ȯ��!(EngineOn ��)
	{
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) 
	{
		this.engineStatus = engineStatus; 
	}*/ 
	
	public boolean isEngineOn() // ���� �������� -> T/F�� ����ϱ� ���� �� �ڿ�������
	{
		return engineOn;
	}

	public void setEngineOn(boolean engineOn) 
	{
		this.engineOn = engineOn;
	}
	
	public Car() // ����Ʈ ������(Default Constructor) : �Ķ���� ����
	{
		System.out.println("Car()");
	}

	public Car(String name) // ���� ������(Copy Constructor)
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
			printError("���� ���¸� Ȯ���ϼ���");
			return -1;
					
		} else if(speed <= 0)
		{
			printError("�ӵ��� 0���� �۽��ϴ�.");
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
		Car truck = new Car("truck"); // name, speed ���õǾ�����
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
