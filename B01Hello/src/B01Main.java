import java.util.Scanner;

public class B01Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int age = 10;
		System.out.println("age = " + age);
		System.out.println("123" + 45);
		System.out.println(123 + 45);
		System.out.println("age" + 123 + 45); 	// �տ������� ���ϱ⶧���� age + 123�� �̹� ���ڿ�
		System.out.println("age" + (123 + 45)); // ��ȣ�� ���� �����ָ� ��
		
		byte value = 126; // byteŸ�� : -128 ~ 127 (���̳ʽ��ʿ��� �ϳ� �� ����)
		System.out.println("next byte = " + (value++)); // ���� �� ���� ���ϱ� -> 126 ���, �޸𸮿��� 127
		System.out.println("next byte = " + (++value)); // ���� ���ϰ� �� ���� -> 127 ���, �޸𸮵� 127
		
	
		short port = 80;
		float degree = 1.23F; // float�� ������ �ڿ� �� F�ٿ����ؼ� �� �Ⱦ�..(double��) float : 10^38
		double point = 1.23;
		long longValue = 123;
		boolean on = false;
		
		/*
		 * ���� �̸��� ��� : _name, $name, �̸�, Name
		 * ��� �ȵǴ� ������ : ���ڷ� ���۵Ǵ� �̸�(int 1st;), Ű����(int class;)
		 * �ٶ����� ������ : ī��ǥ��� ���, �ҹ��ڷ� ����, �ǹ̾��� ������X! (int myFamilyCount;)
		 * 
		 * Final : ���(constant), Read only variable, �����԰� ���ÿ� ���� ����!
		 * 			��� �빮�ڷ� ǥ���Ѵ�.
		 */
		
		int ���� = 12;
		System.out.println("���� = " + ���� );
		
		final double PI = 3.14;
		//PI = 3.1415; // ���� �߻�!
		final int MAX_MONTH = 12;
		
		char familyName = 'K'; // java�� ��������ǥ('')�� ū����ǥ("")�� �ƿ� �ٸ���!
		char fm = '��';
		System.out.println("fm = " + fm);
		char ufm = '\uAC00';
		System.out.println("ufm = " + ufm);
		System.out.println("�� ���� = " + '\uAC01');
		System.out.println('\uAC02' +","+ '\uAC03' +","+ '\uAC04' + "," + '\uAC05');
		
		// Ư�����ڴ� �տ� �齽����
		// ȭ�鿡 '���� �����ڵ�� 'uAC00'�Դϴ�' ��� ����ϱ�
		System.out.println("// ȭ�鿡 '���� �����ڵ�� '\uAC00'�Դϴ�.'��� ����ϱ�");
		
		/*
		 * ������ : Operator
		 * �ǿ����� : Operand
		 * 	���������� : age++, age--
		 * 	�������� : ++age, --age
		 * 	*, /, %
		 * 	<<, >> // shift-left
		 * 	a = 4 : ġȯ/���� ����
		 * 	==, !=, true, false
		 * ������ : &&, ||
		 */
		
		int x = 3;
		x = x << 2;
		System.out.println("x = " + x);
		
		x = 7;
		int y = 5;
		
		System.out.println("x & y = " + (x & y));
		System.out.println("x | y = " + (x | y));
		
		int max = 0;
		
		if(x >= y)
		{
			max = x;
		} else
		{
			max = y;
		}
		System.out.println("max = " + max);
		
		// ���׿�����    [���� ? ���϶� : �����϶�]
		max = (x >= y)? x : y;
		
		System.out.println(x>10 && y<10);
		System.out.println(x = 1); // ==�� �ƴϰ� =�̹Ƿ� 1�� x�� 
		
		
		/*
		 * Type Casting(����ȯ)
		 * 
		 * 1 + 2
		 */
		
		int a = 1;
		int b = 1;
		int c;
		double d;
		
		c = (a + b)/2;
		d = (a + b)/2; // ���� ������ ������ 1.5�� �ƴ�..
		System.out.println("d = " + d);
				
		d = (a+b)/2.0; // int�� double�� ���������� ū ������ �ڵ� ����ȯ
		System.out.println("d = " + d);
		
		d = (double)(a+b)/(double)2;
		System.out.println("d = " + d);
		
		d = 1 + 2.3; 
		System.out.println("d = " + d);
		
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("d = " + (int)d);
		
		
		/*
		 * if(����) {}
		 * 
		 * if(){} else{}
		 * 
		 * if(){} else if(){} ...
		 */
		
		Scanner scan = new Scanner(System.in);
		
		/*
		 * 100~90 : A
		 * 89~80 : B, C, F
		 */
		
		System.out.print("INSERT Degree : ");
		int ptr = scan.nextInt();
		
		if(ptr >= 90)
		{
			System.out.println("Your grade is A.");
		} else if(ptr >= 80) // else�� ���Դٴ� �� 90���� �۴ٴ°� �̹� �����ϰ� ��
		{
			System.out.println("Your grade is B.");
		} else
		{
			System.out.println("Your grade is F.");
		}
		
		/*
		 * �ð��� 1000��(8�ð� ������ �ʰ����� 1.5)
		 * �ð� �Է¹��� : 1~20 (������ �� ���� ���� �Է��ϱ�, �������� ����)
		 */
		
		while(true)
		{
			System.out.print("INSERT hour : ");
			int hour = scan.nextInt();
			
			if(hour<1 || hour>20)
			{
				System.out.println("ERROR : insert hour between 1 and 20.");
			} else
			{
				double salary = 0;
				double overPay = 1.5;
				int mph = 1000; // money per hour
				int time = 8; // ���߿� �ñ��� �ٲ���� �ְ� �ٹ��ð��� �ٲ���� ������, ���������� �ּ�ȭ�ϱ� ���� ������ ����Ѵ�!
				
				if(hour <= time)
				{
					salary = hour * mph;
				} else
				{
					salary = ((hour - time) * (mph * overPay)) + (time * mph);
				}
				System.out.println("�ñ� : " + (int)salary + "��");
				break;
			}
		}
		
		/*
		 * SWITCH
		 * 
		 * break
		 * 		1. switch�� �������� ��
		 * 		2. ���� �ѷ��� �ݺ��� �������� �� 
		 */
		
		int month = 7;
		
		switch(month)
		{
			case 2:
				System.out.println("28");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30");
				break;
			default:
				System.out.println("31");
				break;
		}
		
		/*
		 * if(%4) // 29
		 * 		if(%100) // 28
		 * 			if(%400) // 29
		 * 		else // 29
		 * else // 28
		 * 
		 * ((year % 4 == 0) && !(year % 100 == 0)) -> 29
		 */
		
		scan.close();
	}

}
