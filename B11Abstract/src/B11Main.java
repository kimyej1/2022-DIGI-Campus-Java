

// Abstract Class : 추상 클래스 : 형태가 완성되지 않은 클래스 

abstract class Animal
{
	protected int legs;
	protected int wings;
	
	public void eat()
	{
		System.out.println("Eat..");
	}
	public abstract void move(); // abstract : 이걸 상속받는 것들은 꼭 move()를 정의해야해 (상속에 제한) 
	
}

class Birds extends Animal
{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}

public class B11Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Animal bird = new Animal(); // 이렇게 쓰면 오류 -> cannot instantiate
		Birds eagle = new Birds();
	}

}
