class Car
{
	private int speed; // �������µ� �Ⱦ���!
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
			printError("1�� �̻��� �ݾ��� �Է��ϼ���.");
			return; // void���� ���� ��
		}
		System.out.println("deposit : " + amount);
	}	
	
	private void printError(String msg)
	{
		System.out.println("MESSAGE : " + msg);
	}
	
	public int add(double a, double b) // �޼ҵ� �ߺ�����(Method Overloading)
	{
		System.out.println("double, double");
		return  (int)(a + b);
		// return (int)a + (int)b;
	}
	
	public int add(int a, int b)
	{
		if (a<1 || b<1)
		{
			printError("0 �̻��� ���� �ƴմϴ�.");
			return -1; // int���� ���� ��
		} else
		{
			
		return a+b;
	
		}
	}
	
	public void printXY(int x, int y)
	{
		// �Ķ���� (3,4) �̷� ���� ������
		System.out.println("Parameter (" + x + ", " + y + ")");
	}
}


public class A21Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		String str1 = new String(); 			// 1) String class ���� str1�̶�� ��ü�� ����� ���� ���
		String str2 = new String("Hello Java"); // 2) �̷��� ���� ��
		String str3 = "Just String";			// 3) 2���� ������ �Ȱ��� ���
		
		str1 = "ȫ�浿"; // 1�� �ȿ� ���ڸ� �������� �̰ű��� �ι� �ľߵ� -> 2,3���� �ѹ��� �� �� ����
		int length = str1.length();
		// System.out.println("length = " + length);
		
		str3 = str1.replace('ȫ', '��');
		str1 = str1.replace('ȫ', '��');
		
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));
		
		Car taxi = new Car();
		
		length = taxi.add(3, 4);
		System.out.println("length = " + length);
		System.out.println("Mission 2 : " + taxi.add(7,8)); // ����Ϸ��� �ϴ� add(7,8)�� �����Ϸ� �� -> i am add -> parameter -> syso
		
		taxi.add(-4,5);
		// taxi.printError("�޷�~~~~"); --> .printError�� private�̹Ƿ� �̷��� ���� �ҷ��� ������ ����
		
		taxi.deposit(30000000);
		taxi.deposit(-50000);
		

		
		
	}
}