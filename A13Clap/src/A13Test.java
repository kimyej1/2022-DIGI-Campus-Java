import java.util.Scanner;

public class A13Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int input, count, i, org;
		
		while(true)
		{
			System.out.print("Insert Number [0] to Exit : ");
			input = scan.nextInt();
			org = input; // �������� �ڼ� ��ĥ���� ���� ������ ����
			
			if(input == 0)
			{
				break;
			}
			
			count = 0; // �ϳ� ������ ó��(0)���� �ٽ� �ݺ��ؾ��ϴϱ�
			while(input > 0)
			{
				int one = input % 10; // ó�� ���ڰ� 123456�̸� ������ 6�� ��
				if(one == 3 || one == 6 || one == 9)
				{
					count++;
				}
				
				input = input / 10; // 123456 --> 12345�� �ٲ���� while �ٽ� ����(5�� ��)
			}
			
			for(i=1; i<=count; i++)
			{
				System.out.print("clap ");
			}
			
			if(count == 0)
			{
				System.out.println(org); // input ���⿡ ������ 0������(�ݺ��Ǵٰ� break�Ǵ� ������ input)
			}
			
			System.out.println(""); // �ٹٲ�
		}
		
		scan.close();			
		
	}

}
