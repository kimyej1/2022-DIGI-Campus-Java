import java.util.Scanner;

public class A39Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		/*
		 * 10 ������ �� ���� �Է¹޾Ƽ�(n1,n2),
		 * 1~100 ������ �� �� n1, n2�� ����� ���
		 */
		
		Scanner scan = new Scanner(System.in);
	
		int num1;
		int num2;
		
		while(true)
		{
			System.out.print("10 ������ ���� �Է��ϼ��� : ");
			num1 = scan.nextInt();
			
			System.out.print("10 ������ ���� �� �Է��ϼ��� : ");
			num2 = scan.nextInt();
			
			if(num1 > 10 || num2 > 10 || num1 == 0 || num2 == 0)
			{
				System.out.println("ERROR : 1���� 10 ������ ���� �Է��ϼ���.");
			} else break;
		}
		
		System.out.println("---- " + num1 + "�� " + num2 + "�� ����� ----");
		
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
