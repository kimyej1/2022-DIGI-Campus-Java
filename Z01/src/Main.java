import java.util.*; // 다 가져오는거


public class Main 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);		
		int num1, num2;
		// int count = 0;
		// int sum = 0;
		
		// while(true)
		// {
			num1 = scan.nextInt();
			num2 = scan.nextInt();
		
			/*
			if(num1 < 1 || num2 < 1)
			{
				System.out.println("ERROR : 1 이상의 숫자를 입력하세요.");
			} else if(num1 == num2)
			{
				System.out.println("ERROR : 두 수의 값이 같습니다.");
			} else break;
			*/
	
		// }
		
				
		if(num1 < num2)
		{
			for(int i = num1; i <= num2; i++)
			{
				if(i % 2 == 0 || i % 3 == 0)
				{
					System.out.println(i);
					// count++;
					// sum += i;
				}
			}
		} else if(num2 < num1)
		{
			for(int i = num2; i <= num1; i++)
			{
				if(i % 2 == 0 || i % 3 == 0)
				{
					System.out.println(i);
					// count++;
					// sum += i;
				}
			}
		}
		
		// System.out.println("count = " + count);
		// System.out.println("sum = " + sum);
		
		scan.close();
	}

}
