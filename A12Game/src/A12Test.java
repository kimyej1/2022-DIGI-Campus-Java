import java.util.Scanner;

public class A12Test 
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
		
		int i;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("99이하의 숫자를 입력하세요(0을 입력하면 종료됩니다) : ");
			i = scan.nextInt();
			
			if(i == 0) 
			{
				break;
			}

			if(i > 99)
			{
				System.out.println(" [Error] 99이하의 숫자를 입력하세요.");
			} else 
			{
				if((i % 10) % 3 == 0 && (i/10) != 0 && (i/10) % 3 == 0)
				{
					System.out.println("clap clap");
				} else
				{
					if((i % 10) % 3 == 0 || (i/10) != 0 && (i/10) % 3 == 0)
					{
						System.out.println("clap");
					} else
					{ 
						System.out.println(i); 
					}
				}
			}
		}
		
		scan.close();
	}

}
