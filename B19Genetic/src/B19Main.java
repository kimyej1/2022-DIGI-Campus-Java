class Car<T>
{
	private String name;
	private T speed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getSpeed() {
		return speed;
	}
	public void setSpeed(T speed) {
		this.speed = speed;
	}
}
public class B19Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car<Integer> taxi = new Car<Integer>(); // speed T�� int �־���
		Car<Double> bus = new Car<Double>(); // speed T�� double �־�
		Car<String> truck = new Car<String>();
		
		taxi.setSpeed(12);
		bus.setSpeed(12.3);
		truck.setSpeed("seventy-seven");
		
		
		
	}

}
