class Car
{
	private String name;
	private int speed;
	private String color;
	
	/* ������(Constructor) : �ʱ�ȭ �޼ҵ�
	 *   1. �޼ҵ��� �̸��� Ŭ���� �̸��� ����.
	 *   2. ���� Ÿ���� ����.
	 *   3. �����ڰ� ���ǵǾ� ������ ���α׷����� ������ �ݿ��ϰ�,
	 *      ������ �ý����� �˾Ƽ� ������ش�.
	 */
	
	public Car() // Default Constructor
	{
		speed = 10;
		color = "none";
		name = "none";
		System.out.println("Car() created !!!");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
		
}

public class A20Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Car taxi = new Car(); // Car()�� �ҷ��� --> Car() Created!!! ���� ���
		
		System.out.println("taxi name = " + taxi.getName());
		System.out.println("End");
	}

}
