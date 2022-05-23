import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		/* While
		 * 프로그램 실행 전 반드시 눈으로 확인해라!
		 * 빠져나오는 조건이 있는가? --> 꼭 확인! (무한루프 조심)
		 */
		
		int i = 10;
		
		while(i>=0)
		{
			System.out.println(i);
			i--; // i++와 반대, i = i - 1 (i를 하나씩 줄여준다.)
		}
		
		// 무한루프
		Scanner scan = new Scanner(System.in);
		
		int input;
		// break
		// 1. 나를 둘러싼 반복문의 종료
		// 2. switch문의 종료
		
		while(true)
		{
			System.out.print("Insert Number [0] to Exit :"); // 0 입력해야 끝난다고 알려줌
			input = scan.nextInt();
			
			
			if(input == 0)
			{
				break;
			}
			
			System.out.println("input = " + input); // 0이 아니면 그냥 반환해주고 반복문 다시 실행 
			
			int sum = 0;
			
			for(i=1; i<=input; i++)
			{
				sum = sum + i; // sum += i;
			}
			
			System.out.println("1 + ... + " + input + " = " + sum);
			// "문자" + 숫자 + "=" + sum
		}
		
		scan.close();
	
	}

}
