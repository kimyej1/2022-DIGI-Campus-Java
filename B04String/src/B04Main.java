
public class B04Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = new String("HelloStringWorld"); // ������ String�� class
		String str2 = "Hello Java World"; // �̷��� ���� �͵� ����Ѵ�. (�̰� �� ���ϰ� ���ذ� ����) 
		String str3, str4;
		
		int len = str1.length(); // space ���� 
		System.out.println("str1.length = " + len);
		
		str3 = str1.concat(" Concat"); // Concat : �����̱� 
		System.out.println("str3 = " + str3);
		
		str3 = str1.replace('l', 'L');
		System.out.println("str3 = " + str3);
		
		str3 = str1.substring(1, 5); // index�� 0���� ���� ~ 5���� ���������� (1,2,3,4)
		System.out.println("str3 = " + str3);
		
		str3 = str1.toUpperCase();
		str4 = str1.toLowerCase();
		System.out.println("str3 = " + str3);
		System.out.println("str4 = " + str4);
		
		// charAt : Ư�� �ڸ��� �ִ� ���� ��� 
		for(int i=0; i<str1.length(); i++)
		{
			System.out.println(i + " : " + str1.charAt(i));
		}
		
		str4 = str1 + str2;
		System.out.println("str4 = " + str4);
		System.out.println("100" + 20); // 10020(����) 
		System.out.println(100 + 20); // 120(����)
		
	}

}
