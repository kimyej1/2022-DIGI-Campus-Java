import java.util.Scanner;

public class A12Test 
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
		
		int i;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("99������ ���ڸ� �Է��ϼ���(0�� �Է��ϸ� ����˴ϴ�) : ");
			i = scan.nextInt();
			
			if(i == 0) 
			{
				break;
			}

			if(i > 99)
			{
				System.out.println(" [Error] 99������ ���ڸ� �Է��ϼ���.");
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
