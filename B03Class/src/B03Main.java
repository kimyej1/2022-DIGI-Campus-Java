
class Car 
{
	// 상태정보
	private int speed;
	private String color;
	private boolean turbo;
	
	// 동작정보
	public void startEngine()
	{
		System.out.println("Start Engine");
	}
	
	public void stopEngine()
	{
		System.out.println("Stop Engine");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		
		if(speed < 0)
			printError("negative Speed");
			this.speed = 0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}
	
	private void printError(String msg) // 내부적으로 쓰는게 목적이니까 ! 
	{
		System.out.println("Error : " + msg);
	}

	@Override // Annotation
	public String toString() {
		return "Car [speed=" + speed + ", color=" + color + "]";
	}
	
	
	
}


public class B03Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		int age = 3;
		Car taxi = new Car();
		Car bus = new Car();
		
//		taxi.speed = 100; // private 변수라서 오류 
//		taxi.color = "RED";
//		bus.speed = 70;
//		bus.color = "WHITE";
		
//		System.out.println("taxi.speed = " + taxi.speed);
//		System.out.println("taxi.color = " + taxi.color);
//		System.out.println("bus.speed = " + bus.speed);
//		System.out.println("bus.color = " + bus.color);
		
		taxi.setSpeed(-33);
		taxi.setColor("RED");
		taxi.setTurbo(true);
		System.out.println("taxi.speed = " + taxi.getSpeed());
		System.out.println("taxi = " + taxi);
	}

}
