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
			printError(name + "의 시동을 먼저 켜세요.");
			return -1;
		} else if(speed <= 0)
		{
			printError("속도를 0 이상으로 입력하세요.");
			return -1;
		} else
		{
			System.out.println(name + "의 속도를 " + speed + "로 설정했습니다.");
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
		this.name = name + ", " + year + "년식";
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
			printError(name + "의 시동이 이미 켜져있습니다.");
		} else
		{
		engineOn = true;
		System.out.println(name + "의 시동을 켰습니다.");
		}
	}
	
	public void stopEngine()
	{
		if(engineOn == false)
		{
			printError(name + "의 시동이 이미 꺼져있습니다.");
		} else
		{
		engineOn = false;
		System.out.println(name + "의 시동을 껐습니다.");
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
