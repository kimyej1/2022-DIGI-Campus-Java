
/*
 *  Interface : ��� �޼ҵ尡 �߻��� Ŭ���� 
 */

interface RemoteController
{
	public void turnOn();
	public void turnOff();
}

class TV implements RemoteController, Days // �ڹ� ���Ģ : ���ϻ�Ӹ� ��� (extends �ΰ��ϰ������ �ϳ��� �Ǵϱ�, �ϳ��� Ŭ������ �ؼ� ��ӹް�, �������� �������̽��� �޾ƿ�) 
{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turn On..");
		System.out.println("�Ͽ��� = " + SUN); // days���� �޾ƿ� 
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("turn Off..");
	}
	
}

public class B12Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TV tv = new TV();
		tv.turnOn();
	}

}
