
// Overloading : 중복정의 -- 두개 이상이 정의되어있음 
// Overriding : 재정의(toString) -- 최종적으로 한개만 남음 

class Car
{
	private String name;
	private int speed;
	private String color;
	
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
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
	
}

public class B08Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car taxi = new Car();
		taxi.setName("taxi");
		taxi.setSpeed(33);
		taxi.setColor("RED");
		System.out.println(taxi); // overriding required
		
	}

}
