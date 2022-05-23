
// Inheritance

// final
class Car
{
	protected String name; // private�̸� ��� ���ϴµ�, public���� �ϸ� �ƹ��� �� ���ϱ�..
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
	
	// ���� �޼ҵ� (Final Method)
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
	public void print() {	// �θ��� print() ������ , �θ� final�� �صθ� ������ �Ұ� -> ���� �߻� 
		// TODO Auto-generated method stub
//		super.print();
		System.out.println("OK Print");
		System.out.println("data = " + data); // �ڽĲ� �ҷ��� (�̸� �Ȱ����� ������ overriding�Ѵ�) 
		System.out.println("this.data = " + this.data); // �ڽĲ� 
		System.out.println("super.data = " + super.data); // �θ� 
	}

	@Override
	public String toString() { 	// protected���� ȣ�� ���� 
		return "SportsCar [turbo=" + turbo + ", name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
}

public class B10Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car taxi = new Car("taxi", 33, "red");
		System.out.println(taxi);
		
		SportsCar bmw = new SportsCar(); // Car()...���� ����ϰ� SportsCar() ����� : �θ� ���� ����� �ڽĸ޸� ���� ( ������ �޸��̴� !) 
		bmw.name = "dd";
		
		bmw.print();
	}

}
