import java.util.Scanner;

public class Test0218 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		if(num1 < num2)
		{
			for(int i = num1; i <= num2; i++)
			{
				if(i % 2 == 0 || i % 5 == 0)
				{
					System.out.println(i);
					count++;
				}
			}
		} else if(num1 > num2)
		{
			for(int i = num2; i <= num1; i++)
			{
				if(i % 2 == 0 || i % 5 == 0)
				{
					System.out.println(i);
					count++;
				}
			}
		}
		
		System.out.println("count = " + count);
		
	}

}
