
// Overloading : 중복정의 -- 두개 이상이 정의되어있음 
// Overriding : 재정의(toString) -- 최종적으로 한개만 남음 
// Constructor

class Car
{
	private String name;
	private int speed;
	private String color;
	
	public static int numberOfCar;
	
	/*
	 * 생성자 : 초기화 메소드
	 * 		1. 리턴 타입이 없다.
	 * 		2. 클래스와 이름이 같다.
	 * 		3. 생성자가 없으면 : 시스템이 알아서 만들어준다.
	 * 		4. 생성자가 하나라도 있으면 : 프로그래머의 의지를 반영한다.
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
	 * Signature가 다르면 메소드를 중복정의 할 수 있다.
	 * 
	 * Signature : 나를 구분할 수 있는 요소
	 * 		파라미터의 갯수, 타입 등..
	 * 		* 단, 리턴 타입만 다른 것은 Signature	로 인정하지 않는다.
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
		System.out.println(taxi.numberOfCar); // static(공유메모리) -> taxi.numberOfCar = 7
		System.out.println(Car.numberOfCar); // 이렇게 쓰는게 더 바람직 (자동차가 공통으로 가지고있는거니까, 위처럼 쓰면 택시만 가진 느낌..)
		
		// Static method : 객체를 만들 필요가 없는 경우
		// Math.random()
		// static method는 static method만 호출 가능 (main이 static이라 함수도 static이어야함)
		
		int value = (int)Math.ceil(1.23);
		
		int result = add(1,2);
	}
	
	public static int add(int a, int b) // static method can call static method only
	{
		return a + b;
	}

}
