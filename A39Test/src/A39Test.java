import java.util.Scanner;

public class A39Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		/*
		 * 10 이하의 두 수를 입력받아서(n1,n2),
		 * 1~100 사이의 수 중 n1, n2의 공배수 출력
		 */
		
		Scanner scan = new Scanner(System.in);
	
		int num1;
		int num2;
		
		while(true)
		{
			System.out.print("10 이하의 수를 입력하세요 : ");
			num1 = scan.nextInt();
			
			System.out.print("10 이하의 수를 또 입력하세요 : ");
			num2 = scan.nextInt();
			
			if(num1 > 10 || num2 > 10 || num1 == 0 || num2 == 0)
			{
				System.out.println("ERROR : 1부터 10 사이의 수를 입력하세요.");
			} else break;
		}
		
		System.out.println("---- " + num1 + "과 " + num2 + "의 공배수 ----");
		
		for(int i = 1; i <= 100; i++)
		{
			if(i % num1 == 0 && i % num2 == 0)
			{
				System.out.println(i);
			}
		}
		
		scan.close();
	}

}
