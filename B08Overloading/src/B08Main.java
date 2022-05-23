
// Overloading : �ߺ����� -- �ΰ� �̻��� ���ǵǾ����� 
// Overriding : ������(toString) -- ���������� �Ѱ��� ���� 

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
