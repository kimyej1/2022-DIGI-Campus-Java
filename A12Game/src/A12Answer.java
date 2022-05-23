import java.util.Scanner;

public class A12Answer 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		/*
		 * 99 이하의 숫자를 입력한다 --> 입력한 값의 369게임의 결과를 출력하시오.
		 * 예1: 27 입력인 경우 27 출력
		 * 예2: 13, 31을 입력한 경우 "clap"출력
		 * 예3: 33 입력인 경우 "clap clap" 출력
		 * 0을 입력할때까지 계속 반복한다.
		 */
		
		int input, ten, one;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			int clapCount = 0; // 박수 치는 횟수
			System.out.print("99이하의 숫자를 입력하세요(0을 입력하면 종료됩니다) : ");
			input = scan.nextInt();
			
			if(input == 0) 
			{
				break;
			}

			ten = input / 10;
			one = input % 10;
			
			if(ten == 3 || ten == 6 || ten == 9)
			{
				clapCount++;
			}

			if(one == 3 || one == 6 || one == 9)
			{
				clapCount++;
			}
			
			int i;
			for(i=1; i<=clapCount; i++)
			{
				System.out.print("clap ");
			}
			
			if(clapCount == 0)
			{
				System.out.println(input);
			}
			System.out.println("");
			
		}
		
		scan.close();
		
	}

}
