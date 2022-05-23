import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		/*
		 * 사용자로부터 year, month를 입력받는다.
		 * 2월인 경우 다음의 조건에 따른다.
		 *  - 4의 배수이면 29일이고, 4의 배수가 아니면 28일이다.
		 *  - 4의 배수이면서 동시에 100의 배수이면, 이 때는 28일이다.
		 *  - 그리고 동시에 400의 배수이기도 하면, 이 때는 29일이다.
		 *  
		 * 그 달의 1일이 일요일이라고 가정하고, 그 달의 달력을 출력하라.
		 */
		
		int year, month, lastDay;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Insert Year :");
			year = scan.nextInt();
			
			System.out.print("Insert Month :");
			month = scan.nextInt();
			
			if(month>12 || month<=0)
			{
				break;
			}
			
			switch(month)
			{
				case 2:
					/* 방법 1: if 안에 if 사용 */
					if(year % 4 ==0)
					{
						lastDay = 29;
						if(year % 100 ==0)
						{
							lastDay = 28;
							if(year % 400 ==0) 
							{
								lastDay = 29;
							} else { lastDay = 28; }
						} else { lastDay = 29; }
					} else { lastDay = 28; }
					
					/* 방법 2: else if 사용
					if(year % 400 ==0) // 조건을 거꾸로 큰것부터 시작 --> else로 걸러나감
					{
						lastDay = 29;
					} else if(year % 100 ==0) // 400의 배수가 아님을 내포
					{
						lastDay = 28;
					} else if(year % 4 ==0)
					{
						lastDay = 29;
					} else { lastDay = 28; } */
					
					/* 방법 3: 29일인 조건만 모아서 나머지 else로 묶기 
					if((year % 4 ==0) && !(year % 100 ==0) || (year % 400 ==0))
					{
						lastDay = 29;
					} else { lastDay = 28; } */
					/*
					if(year % 4 ==0)
					{ //여기는 29일이 될 가능성이 있는 위치!
						if(year % 100 ==0) // 100의 배수
						{
							if() // 400의 배수
							{
								lastDay = 29;
							} else
							{
								lastDay = 28; // 4와 100으로 떨어지는데 400으로는 안나눠짐
							}
						} else
						{
							lastDay = 29; // 4로는 떨어지고 100으로는 안나눠짐
						}
					} else
					{
						lastDay = 28;
					} */
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					lastDay = 30;
					break;
				default:
					lastDay = 31;
					break;
			}
			// 달력 출력하기
			
			System.out.println("last day = " + lastDay);
		}
			
		scan.close();
	}

}
