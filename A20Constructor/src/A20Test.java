class Car
{
	private String name;
	private int speed;
	private String color;
	
	/* 생성자(Constructor) : 초기화 메소드
	 *   1. 메소드의 이름은 클래스 이름과 같다.
	 *   2. 리턴 타입이 없다.
	 *   3. 생성자가 정의되어 있으면 프로그래머의 의지를 반영하고,
	 *      없으면 시스템이 알아서 만들어준다.
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
		
		Car taxi = new Car(); // Car()를 불러옴 --> Car() Created!!! 까지 출력
		
		System.out.println("taxi name = " + taxi.getName());
		System.out.println("End");
	}

}
