import java.util.Scanner;

public class A12Answer 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		/*
		 * 99 ������ ���ڸ� �Է��Ѵ� --> �Է��� ���� 369������ ����� ����Ͻÿ�.
		 * ��1: 27 �Է��� ��� 27 ���
		 * ��2: 13, 31�� �Է��� ��� "clap"���
		 * ��3: 33 �Է��� ��� "clap clap" ���
		 * 0�� �Է��Ҷ����� ��� �ݺ��Ѵ�.
		 */
		
		int input, ten, one;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			int clapCount = 0; // �ڼ� ġ�� Ƚ��
			System.out.print("99������ ���ڸ� �Է��ϼ���(0�� �Է��ϸ� ����˴ϴ�) : ");
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
