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
		System.out.println("age" + 123 + 45); 	// 앞에서부터 더하기때문에 age + 123이 이미 문자열
		System.out.println("age" + (123 + 45)); // 괄호로 숫자 묶어주면 가
		
		byte value = 126; // byte타입 : -128 ~ 127 (마이너스쪽에서 하나 더 가짐)
		System.out.println("next byte = " + (value++)); // 먼저 값 쓰고 더하기 -> 126 출력, 메모리에는 127
		System.out.println("next byte = " + (++value)); // 먼저 더하고 값 쓰기 -> 127 출력, 메모리도 127
		
	
		short port = 80;
		float degree = 1.23F; // float로 쓰려면 뒤에 꼭 F붙여야해서 잘 안씀..(double씀) float : 10^38
		double point = 1.23;
		long longValue = 123;
		boolean on = false;
		
		/*
		 * 변수 이름에 허용 : _name, $name, 이름, Name
		 * 허용 안되는 변수명 : 숫자로 시작되는 이름(int 1st;), 키워드(int class;)
		 * 바람직한 변수명 : 카멜표기법 사용, 소문자로 시작, 의미없는 변수명X! (int myFamilyCount;)
		 * 
		 * Final : 상수(constant), Read only variable, 선언함과 동시에 값이 세팅!
		 * 			모두 대문자로 표기한다.
		 */
		
		int 나이 = 12;
		System.out.println("나이 = " + 나이 );
		
		final double PI = 3.14;
		//PI = 3.1415; // 오류 발생!
		final int MAX_MONTH = 12;
		
		char familyName = 'K'; // java는 작은따옴표('')와 큰따옴표("")는 아예 다르다!
		char fm = '가';
		System.out.println("fm = " + fm);
		char ufm = '\uAC00';
		System.out.println("ufm = " + ufm);
		System.out.println("각 추정 = " + '\uAC01');
		System.out.println('\uAC02' +","+ '\uAC03' +","+ '\uAC04' + "," + '\uAC05');
		
		// 특수문자는 앞에 백슬래시
		// 화면에 '가의 유니코드는 'uAC00'입니다' 라고 출력하기
		System.out.println("// 화면에 '가의 유니코드는 '\uAC00'입니다.'라고 출력하기");
		
		/*
		 * 연산자 : Operator
		 * 피연산자 : Operand
		 * 	후위연산자 : age++, age--
		 * 	전위증감 : ++age, --age
		 * 	*, /, %
		 * 	<<, >> // shift-left
		 * 	a = 4 : 치환/대입 연산
		 * 	==, !=, true, false
		 * 논리연산 : &&, ||
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
		
		// 삼항연산자    [조건 ? 참일때 : 거짓일때]
		max = (x >= y)? x : y;
		
		System.out.println(x>10 && y<10);
		System.out.println(x = 1); // ==이 아니고 =이므로 1을 x에 
		
		
		/*
		 * Type Casting(형변환)
		 * 
		 * 1 + 2
		 */
		
		int a = 1;
		int b = 1;
		int c;
		double d;
		
		c = (a + b)/2;
		d = (a + b)/2; // 정수 나누기 정수라서 1.5가 아님..
		System.out.println("d = " + d);
				
		d = (a+b)/2.0; // int와 double이 같이있으면 큰 쪽으로 자동 형변환
		System.out.println("d = " + d);
		
		d = (double)(a+b)/(double)2;
		System.out.println("d = " + d);
		
		d = 1 + 2.3; 
		System.out.println("d = " + d);
		
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("d = " + (int)d);
		
		
		/*
		 * if(조건) {}
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
		} else if(ptr >= 80) // else에 들어왔다는 건 90보다 작다는걸 이미 내포하고 있
		{
			System.out.println("Your grade is B.");
		} else
		{
			System.out.println("Your grade is F.");
		}
		
		/*
		 * 시간당 1000원(8시간 넘으면 초과분은 1.5)
		 * 시간 입력받음 : 1~20 (무조건 이 사이 값만 입력하기, 나머지는 에러)
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
				int time = 8; // 나중에 시급이 바뀔수도 있고 근무시간이 바뀔수도 있으니, 수정영역을 최소화하기 위해 변수를 사용한다!
				
				if(hour <= time)
				{
					salary = hour * mph;
				} else
				{
					salary = ((hour - time) * (mph * overPay)) + (time * mph);
				}
				System.out.println("시급 : " + (int)salary + "원");
				break;
			}
		}
		
		/*
		 * SWITCH
		 * 
		 * break
		 * 		1. switch를 빠져나갈 때
		 * 		2. 나를 둘러싼 반복문 빠져나갈 때 
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
