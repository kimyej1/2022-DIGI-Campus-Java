
public class Var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// single line comment
		/* 
		 * �ּ�ó��~~~
		 */
		int age;
		int myFamilyCount;
		int yourAge;
		int myFatherAge;
		
		final int MAXMONTH = 12; // ����� �ٲ�� �ȵǴ� �޸�!! final ������� �������� --> ���� ���� �Ұ�  (�˼��ֵ��� �빮�ڷ� �ۼ�) "read only variable"
		
		// multiple variable
		int koreanDegree, mathDegree;
		// declaration, init
		int englishDegree = 77;
		
		int a=1, b=2; // a=1
		// syso Ctrl+Space
		// "abc" + 123 = abc123
		System.out.println("English Degree is " + englishDegree);
		
		englishDegree = 88;
		System.out.println("English Degree is " + englishDegree);
		
		int maxMonth = 13; // �տ��� final ���� �صּ� compile ���� �߻�
		System.out.println("maxMonth = " + maxMonth);
		System.out.println(MAXMONTH);
		
		a = a + 1; 
		System.out.println("a = " + a); // a=2
		a++;
		System.out.println("a = " + a); // a=3
		
		System.out.println(a++); // a�� ����ϰ�, a�� ���ض� -> ����� 3�� ����ϰ�, �޸𸮿��� 4�� �������
		System.out.println(++a); // a�� ���� ���ϰ�, ��� -> �޸𸮿� 4�� �����ϱ� 5 ����ϰ�, �޸𸮿��� 5�� �������
		System.out.println(a++); // ����� 5, �޸𸮿��� 6
		System.out.println(a);   // �޸� �״�� ��� -> 6
		
		a = b = 7;
		
		System.out.println(a);
		
		// b = 7
		System.out.println("b = " + b);

		double pi = 3.14;
		System.out.println("pi = " + pi);
		
		double result;
		result = pi + a;
		System.out.println("result = " + result);
		
		double average = 1 + 3;
		average = average / 3;
		System.out.println("average = " + average);
		System.out.printf("average = \t\t\t %.2f\n", average); 
		// �齽����(\) = "�� �ڿ� Ư���� �ǹ̰� �־�!" (��) \t = tab, \n = new line + \r(�ٹٲ�) + \f(Ŀ�� �� ������ �̵�)
		
		String myName = "yjkim"; // ���ڿ�, String
		System.out.println("myName = " + myName);
		
		char init = 'K';
		char lee = 'L';
		
		byte number = 127;
		System.out.println("number = " + number);
		number++;
		System.out.println("number = " + number);
		number--;
		System.out.println("number = " + number);
		
		final double PI = 3.1415927;
		boolean isOn = true; //logical variable
		System.out.println("isOn = "+ isOn);
		
		double limit = 1.0/2.0;
		System.out.println("limit 1 = " + limit);
		
		limit = 1.0/0.0;
		System.out.println("limit 2 = " + limit);
		
		limit = 0.0/0.0; // NaN = Not a Number
		System.out.println("limit 3 = " + limit);
		
		/*
		 * ������ ���� �׽�Ʈ
		 */
		
		char ch1 = 'A';
		char ch2 = '��';
		char ch3 = '\uac00';
		
		System.out.println("ch1 = " + ch1);
		System.out.println("ch2 = " + ch2);
		System.out.println("ch3 = " + ch3);
		
	}

}
