
// Inheritance

// final
class Car
{
	protected String name; // private이면 상속 못하는데, public으로 하면 아무나 다 쓰니까..
	protected int speed;
	protected String color;
	protected int data = 100;
	
	public Car() // default constructor
	{
		this("no name", 0, "no color");
	}
	
	public Car(String name, int speed, String color) // copy constructor
	{
		System.out.println("Car()...");
		this.name = name;
		this.speed = speed;
		this.color = color;
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
	
	// 종단 메소드 (Final Method)
	// final
	public void print()
	{
		System.out.println("XXXXXXXXX");
	}
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
}

class SportsCar extends Car // inherit Car
{
	private boolean turbo;
	private double data = 1.23;
	
	public SportsCar()
	{
		System.out.println("SportsCar()");
	}
	
	public boolean isTurbo()
	{
		return turbo;
	}
	

	@Override
	public void print() {	// 부모의 print() 재정의 , 부모를 final로 해두면 재정의 불가 -> 오류 발생 
		// TODO Auto-generated method stub
//		super.print();
		System.out.println("OK Print");
		System.out.println("data = " + data); // 자식꺼 불러옴 (이름 똑같으면 무조건 overriding한다) 
		System.out.println("this.data = " + this.data); // 자식꺼 
		System.out.println("super.data = " + super.data); // 부모꺼 
	}

	@Override
	public String toString() { 	// protected까지 호출 가능 
		return "SportsCar [turbo=" + turbo + ", name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
}

public class B10Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car taxi = new Car("taxi", 33, "red");
		System.out.println(taxi);
		
		SportsCar bmw = new SportsCar(); // Car()...먼저 출력하고 SportsCar() 출력함 : 부모 먼저 만들고 자식메모리 만듬 ( 별개의 메모리이다 !) 
		bmw.name = "dd";
		
		bmw.print();
	}

}
