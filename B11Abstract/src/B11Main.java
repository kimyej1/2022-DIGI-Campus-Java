

// Abstract Class : �߻� Ŭ���� : ���°� �ϼ����� ���� Ŭ���� 

abstract class Animal
{
	protected int legs;
	protected int wings;
	
	public void eat()
	{
		System.out.println("Eat..");
	}
	public abstract void move(); // abstract : �̰� ��ӹ޴� �͵��� �� move()�� �����ؾ��� (��ӿ� ����) 
	
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

//		Animal bird = new Animal(); // �̷��� ���� ���� -> cannot instantiate
		Birds eagle = new Birds();
	}

}
