
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
	
	private class InnerClass // Car �ȿ� Car������ �� ���� Ŭ������ ��Ƶ� 
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

// Anonymous Class : ����Ŭ����
// 		��ü�� ����, �̸��� ����.
// 		�����ϸ鼭 ���ÿ� ��ü�� ����
// 		�ѹ��� ���� �� ��! 

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
