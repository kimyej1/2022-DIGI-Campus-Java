class Car
{
	private String name;
	private int speed;
	private boolean engineOn;
	
	public Car(String name)
	{
		this.name = name;
		this.speed = 0;
		this.engineOn = false;
		System.out.println("( name, speed, engineOn) = ( "+ name + ", " + speed + ", " + engineOn + " )");
	}
	
	public int getSpeed()
	{
		System.out.println("speed = " + speed);
		return this.speed;
	}
	
	public int setSpeed(int speed)
	{
		
		if(engineOn == false)
		{
			printError(name + "�� �õ��� ���� �Ѽ���.");
			return -1;
		} else if(speed <= 0)
		{
			printError("�ӵ��� 0 �̻����� �Է��ϼ���.");
			return -1;
		} else
		{
			System.out.println(name + "�� �ӵ��� " + speed + "�� �����߽��ϴ�.");
			return this.speed = speed;
		}
	}
	
	public String getName()
	{
		System.out.println("name = " + name);
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setName(String name, int year)
	{
		this.name = name + ", " + year + "���";
	}
	
	public boolean getEngineOn()
	{
		System.out.println("Engine On = " + engineOn);
		return this.engineOn;
	}
	
	public void setEngineOn(boolean engineOn)
	{
		this.engineOn = engineOn;
	}
	
	private void printError(String errorMessage)
	{
		System.out.println("error(" + errorMessage + ")");
	}
	
	public void startEngine()
	{
		if(engineOn == true)
		{
			printError(name + "�� �õ��� �̹� �����ֽ��ϴ�.");
		} else
		{
		engineOn = true;
		System.out.println(name + "�� �õ��� �׽��ϴ�.");
		}
	}
	
	public void stopEngine()
	{
		if(engineOn == false)
		{
			printError(name + "�� �õ��� �̹� �����ֽ��ϴ�.");
		} else
		{
		engineOn = false;
		System.out.println(name + "�� �õ��� �����ϴ�.");
		}
	}

	@Override
	public String toString() {
		return "[" + name + " : speed=" + speed + ", engineOn=" + engineOn + "]";
	}
	

}

public class A22Todo
{
	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

	Car taxi = new Car("taxi");
	Car bus = new Car("bus");
	
	
	taxi.setSpeed(10);	
	System.out.println(taxi);
	
	bus.startEngine();
	System.out.println(bus);
	
	bus.setSpeed(44);
	System.out.println(bus);
	
	bus.startEngine();
	System.out.println(bus);
	
	taxi.startEngine();
	System.out.println(taxi);
	
	taxi.setSpeed(20);
	System.out.println(taxi);
	
	taxi.stopEngine();
	System.out.println(taxi);
	
	taxi.stopEngine();
	System.out.println(taxi);
	
	bus.stopEngine();
	System.out.println(bus);

	}
}
