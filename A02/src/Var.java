
public class Var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// single line comment
		/* 
		 * 주석처리~~~
		 */
		int age;
		int myFamilyCount;
		int yourAge;
		int myFatherAge;
		
		final int MAXMONTH = 12; // 절대로 바뀌면 안되는 메모리!! final 써놓으면 최종선언 --> 이후 수정 불가  (알수있도록 대문자로 작성) "read only variable"
		
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
		
		int maxMonth = 13; // 앞에서 final 선언 해둬서 compile 오류 발생
		System.out.println("maxMonth = " + maxMonth);
		System.out.println(MAXMONTH);
		
		a = a + 1; 
		System.out.println("a = " + a); // a=2
		a++;
		System.out.println("a = " + a); // a=3
		
		System.out.println(a++); // a를 출력하고, a를 더해라 -> 출력은 3을 출력하고, 메모리에는 4가 들어있음
		System.out.println(++a); // a를 먼저 더하고, 출력 -> 메모리에 4가 있으니까 5 출력하고, 메모리에도 5가 들어있음
		System.out.println(a++); // 출력은 5, 메모리에는 6
		System.out.println(a);   // 메모리 그대로 출력 -> 6
		
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
		// 백슬래쉬(\) = "이 뒤엔 특별한 의미가 있어!" (예) \t = tab, \n = new line + \r(줄바꿈) + \f(커서 맨 앞으로 이동)
		
		String myName = "yjkim"; // 문자열, String
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
		 * 문자형 변수 테스트
		 */
		
		char ch1 = 'A';
		char ch2 = '가';
		char ch3 = '\uac00';
		
		System.out.println("ch1 = " + ch1);
		System.out.println("ch2 = " + ch2);
		System.out.println("ch3 = " + ch3);
		
	}

}
