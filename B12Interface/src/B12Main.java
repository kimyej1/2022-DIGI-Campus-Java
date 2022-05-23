
/*
 *  Interface : 모든 메소드가 추상인 클래스 
 */

interface RemoteController
{
	public void turnOn();
	public void turnOff();
}

class TV implements RemoteController, Days // 자바 대원칙 : 단일상속만 허용 (extends 두개하고싶은데 하나만 되니까, 하나는 클래스로 해서 상속받고, 나머지는 인터페이스로 받아옴) 
{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turn On..");
		System.out.println("일요일 = " + SUN); // days에서 받아옴 
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
