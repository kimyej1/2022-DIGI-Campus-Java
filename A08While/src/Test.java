import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		/* While
		 * ���α׷� ���� �� �ݵ�� ������ Ȯ���ض�!
		 * ���������� ������ �ִ°�? --> �� Ȯ��! (���ѷ��� ����)
		 */
		
		int i = 10;
		
		while(i>=0)
		{
			System.out.println(i);
			i--; // i++�� �ݴ�, i = i - 1 (i�� �ϳ��� �ٿ��ش�.)
		}
		
		// ���ѷ���
		Scanner scan = new Scanner(System.in);
		
		int input;
		// break
		// 1. ���� �ѷ��� �ݺ����� ����
		// 2. switch���� ����
		
		while(true)
		{
			System.out.print("Insert Number [0] to Exit :"); // 0 �Է��ؾ� �����ٰ� �˷���
			input = scan.nextInt();
			
			
			if(input == 0)
			{
				break;
			}
			
			System.out.println("input = " + input); // 0�� �ƴϸ� �׳� ��ȯ���ְ� �ݺ��� �ٽ� ���� 
			
			int sum = 0;
			
			for(i=1; i<=input; i++)
			{
				sum = sum + i; // sum += i;
			}
			
			System.out.println("1 + ... + " + input + " = " + sum);
			// "����" + ���� + "=" + sum
		}
		
		scan.close();
	
	}

}
