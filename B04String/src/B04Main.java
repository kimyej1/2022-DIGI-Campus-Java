
public class B04Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = new String("HelloStringWorld"); // 원래는 String도 class
		String str2 = "Hello Java World"; // 이렇게 쓰는 것도 허용한다. (이게 더 편하고 이해가 쉬움) 
		String str3, str4;
		
		int len = str1.length(); // space 포함 
		System.out.println("str1.length = " + len);
		
		str3 = str1.concat(" Concat"); // Concat : 덧붙이기 
		System.out.println("str3 = " + str3);
		
		str3 = str1.replace('l', 'L');
		System.out.println("str3 = " + str3);
		
		str3 = str1.substring(1, 5); // index는 0부터 시작 ~ 5보다 작을때까지 (1,2,3,4)
		System.out.println("str3 = " + str3);
		
		str3 = str1.toUpperCase();
		str4 = str1.toLowerCase();
		System.out.println("str3 = " + str3);
		System.out.println("str4 = " + str4);
		
		// charAt : 특정 자리에 있는 글자 출력 
		for(int i=0; i<str1.length(); i++)
		{
			System.out.println(i + " : " + str1.charAt(i));
		}
		
		str4 = str1 + str2;
		System.out.println("str4 = " + str4);
		System.out.println("100" + 20); // 10020(문자) 
		System.out.println(100 + 20); // 120(문자)
		
	}

}
