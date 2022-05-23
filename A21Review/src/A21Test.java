class Car
{
	private int speed; // 만들어놨는데 안쓸거!
	private String color;
	
		
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void deposit(int amount)
	{
		if (amount < 0)
		{
			printError("1원 이상의 금액을 입력하세요.");
			return; // void에서 끝낼 때
		}
		System.out.println("deposit : " + amount);
	}	
	
	private void printError(String msg)
	{
		System.out.println("MESSAGE : " + msg);
	}
	
	public int add(double a, double b) // 메소드 중복정의(Method Overloading)
	{
		System.out.println("double, double");
		return  (int)(a + b);
		// return (int)a + (int)b;
	}
	
	public int add(int a, int b)
	{
		if (a<1 || b<1)
		{
			printError("0 이상의 값이 아닙니다.");
			return -1; // int에서 끝낼 때
		} else
		{
			
		return a+b;
	
		}
	}
	
	public void printXY(int x, int y)
	{
		// 파라미터 (3,4) 이런 값을 얻고싶음
		System.out.println("Parameter (" + x + ", " + y + ")");
	}
}


public class A21Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		String str1 = new String(); 			// 1) String class 안의 str1이라는 객체를 만드는 원래 방법
		String str2 = new String("Hello Java"); // 2) 이렇게 만들어도 됨
		String str3 = "Just String";			// 3) 2번과 완전히 똑같은 방식
		
		str1 = "홍길동"; // 1번 안에 문자를 넣으려면 이거까지 두번 쳐야됨 -> 2,3번은 한번에 할 수 있음
		int length = str1.length();
		// System.out.println("length = " + length);
		
		str3 = str1.replace('홍', '김');
		str1 = str1.replace('홍', '김');
		
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));
		
		Car taxi = new Car();
		
		length = taxi.add(3, 4);
		System.out.println("length = " + length);
		System.out.println("Mission 2 : " + taxi.add(7,8)); // 출력하려면 일단 add(7,8)을 수행하러 감 -> i am add -> parameter -> syso
		
		taxi.add(-4,5);
		// taxi.printError("메롱~~~~"); --> .printError가 private이므로 이렇게 직접 불러다 쓸수는 없음
		
		taxi.deposit(30000000);
		taxi.deposit(-50000);
		

		
		
	}
}