

class Car
{
	// 원칙: field는 private, method = public이다.
	
	private int speed;
	
	// method Overloading : 메소드 중복정의
	// 조건: signature 구분이 가능해야한다. 단, 리턴값만으로는 구분하지 못한다.

	public void setSpeed(double speed)
	{
		this.speed = (int)speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public void setSpeed(int speed1, int speed2)
	{
		this.speed = speed1 + speed2;
	}
	

	
	public int getSpeed()
	{
		return speed;
	}

	@Override // Annotation : 오버라이딩 => 재정의
	public String toString() {
		return "Car [speed=" + speed + "]";
	}
	
	
}


public class A17Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Car taxi = new Car();
		
		taxi.setSpeed(33);
		//taxi.speed = 11;
		System.out.println("taxi.speed = " + taxi.getSpeed());
		
		taxi.setSpeed(12.3);
		taxi.setSpeed(10,20);
		
		System.out.println("taxi = " + taxi);
	}

}
