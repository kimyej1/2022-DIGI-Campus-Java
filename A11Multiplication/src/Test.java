import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		
	/* 
	 * ����ڷκ��� �Է��� ������ �ݺ��ؼ� �޴´�.
	 * 0�� �Է��ϸ� ���α׷� ����.
	 * ���ڸ� �Է��ϸ�.. �ش� ��(table)�� �������� ����Ͻÿ�.
	 */
		
		int input;
		Scanner scan = new Scanner(System.in);
	

		
		while(true)
		{
			
			System.out.print("���ڸ� �Է��ϼ���~ 0 ������ ����˴ϴ� : ");
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
