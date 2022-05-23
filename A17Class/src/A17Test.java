

class Car
{
	// ��Ģ: field�� private, method = public�̴�.
	
	private int speed;
	
	// method Overloading : �޼ҵ� �ߺ�����
	// ����: signature ������ �����ؾ��Ѵ�. ��, ���ϰ������δ� �������� ���Ѵ�.

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

	@Override // Annotation : �������̵� => ������
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
