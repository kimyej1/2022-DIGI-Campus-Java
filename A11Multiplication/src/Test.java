import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		
	/* 
	 * 사용자로부터 입력을 무한히 반복해서 받는다.
	 * 0을 입력하면 프로그램 종료.
	 * 숫자를 입력하면.. 해당 단(table)의 구구단을 출력하시오.
	 */
		
		int input;
		Scanner scan = new Scanner(System.in);
	

		
		while(true)
		{
			
			System.out.print("숫자를 입력하세요~ 0 넣으면 종료됩니다 : ");
			input = scan.nextInt();
			
			if (input ==0)
			{
				break;
			}
			
			int i;
			for (i=1; i<=9; i++)
			{
				System.out.println(input + " * " + i + " = " + (input * i));
			}
		}
		
		
		scan.close();
		
	}

}
