
// InnerClass
class Car
{
	private String name;
	private int speed;
	
	public Car()
	{
		InnerClass obj = new InnerClass();
		obj.getTest();
	}
	
	private class InnerClass // Car 안에 Car에서만 쓸 관련 클래스를 모아둠 
	{
		private int test;
		
		public int getTest() {
			return test;
		}

		public void setTest(int test) {
			this.test = test;
		}

		public InnerClass()
		{
			System.out.println("inner class");
		}
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
}

// Anonymous Class : 무명클래스
// 		몸체는 정의, 이름은 없다.
// 		정의하면서 동시에 객체를 생성
// 		한번만 쓰고 말 때! 

interface RemoteController{
	public void turnOn();
	public void turnOff();
}
public class B14Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RemoteController tv = new RemoteController() {
			public void turnOn() {};
			public void turnOff() {};
		};
	}

}
