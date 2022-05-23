
// Overloading : �ߺ����� -- �ΰ� �̻��� ���ǵǾ����� 
// Overriding : ������(toString) -- ���������� �Ѱ��� ���� 
// Constructor

class Car
{
	private String name;
	private int speed;
	private String color;
	
	public static int numberOfCar;
	
	/*
	 * ������ : �ʱ�ȭ �޼ҵ�
	 * 		1. ���� Ÿ���� ����.
	 * 		2. Ŭ������ �̸��� ����.
	 * 		3. �����ڰ� ������ : �ý����� �˾Ƽ� ������ش�.
	 * 		4. �����ڰ� �ϳ��� ������ : ���α׷����� ������ �ݿ��Ѵ�.
	 * 			
	 */
	
	public Car() // w/o parameter = "Default Constructor"
	{
		this.name = "no name";
		this.color = "no color";
		this.speed = 0;
	}
	public Car(String name) // w/ parameter = "Copy Constructor"
	{
//		this.name = name;
//		this.color = "no color";
//		this.speed = 0;
		this(name, 0, "no color"); // call Constructor "Car(String name, int speed, String color)"
	}
	public Car(String name, int speed, String color)
	{
		this.name = name;
		this.color = color;
		this.speed = speed;
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
	
	/*
	 * Signature�� �ٸ��� �޼ҵ带 �ߺ����� �� �� �ִ�.
	 * 
	 * Signature : ���� ������ �� �ִ� ���
	 * 		�Ķ������ ����, Ÿ�� ��..
	 * 		* ��, ���� Ÿ�Ը� �ٸ� ���� Signature	�� �������� �ʴ´�.
	 */
	
	public void setSpeed(int speed) {				// param type : int
		this.speed = speed;
	}
	public void setSpeed(int speed1, int speed2) {	// param amount : 2
		this.speed = speed1 + speed2;
	}
	public void setSpeed(double speed) {			// param type : double
		this.speed = (int)speed;
	}
//	public int setSpeed(int speed) {				// return type != signature	
//		this.speed = speed;
//		return this.speed;
//	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	protected void finalize() {						// finalize..
		System.out.println("Final");
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
	
}
public class B09Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car taxi = new Car(); // Default Constructor
		taxi.setName("taxi");
		taxi.setSpeed(33);
		taxi.setColor("RED");
		System.out.println(taxi); // ...overriding required
		
		Car bus = new Car();
		System.out.println(bus);
		
		Car truck = new Car("truck"); // Copy Constructor
		System.out.println(truck);
		
		Car train = new Car("train", 77, "Black");
		System.out.println(train);
		
		truck.finalize();
		
		taxi.numberOfCar = 3;
		bus.numberOfCar = 7;
		System.out.println(taxi.numberOfCar); // static(�����޸�) -> taxi.numberOfCar = 7
		System.out.println(Car.numberOfCar); // �̷��� ���°� �� �ٶ��� (�ڵ����� �������� �������ִ°Ŵϱ�, ��ó�� ���� �ýø� ���� ����..)
		
		// Static method : ��ü�� ���� �ʿ䰡 ���� ���
		// Math.random()
		// static method�� static method�� ȣ�� ���� (main�� static�̶� �Լ��� static�̾����)
		
		int value = (int)Math.ceil(1.23);
		
		int result = add(1,2);
	}
	
	public static int add(int a, int b) // static method can call static method only
	{
		return a + b;
	}

}
