import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		/*
		 * ����ڷκ��� year, month�� �Է¹޴´�.
		 * 2���� ��� ������ ���ǿ� ������.
		 *  - 4�� ����̸� 29���̰�, 4�� ����� �ƴϸ� 28���̴�.
		 *  - 4�� ����̸鼭 ���ÿ� 100�� ����̸�, �� ���� 28���̴�.
		 *  - �׸��� ���ÿ� 400�� ����̱⵵ �ϸ�, �� ���� 29���̴�.
		 *  
		 * �� ���� 1���� �Ͽ����̶�� �����ϰ�, �� ���� �޷��� ����϶�.
		 */
		
		int year, month, lastDay;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Insert Year :");
			year = scan.nextInt();
			
			System.out.print("Insert Month :");
			month = scan.nextInt();
			
			if(month>12 || month<=0)
			{
				break;
			}
			
			switch(month)
			{
				case 2:
					/* ��� 1: if �ȿ� if ��� */
					if(year % 4 ==0)
					{
						lastDay = 29;
						if(year % 100 ==0)
						{
							lastDay = 28;
							if(year % 400 ==0) 
							{
								lastDay = 29;
							} else { lastDay = 28; }
						} else { lastDay = 29; }
					} else { lastDay = 28; }
					
					/* ��� 2: else if ���
					if(year % 400 ==0) // ������ �Ųٷ� ū�ͺ��� ���� --> else�� �ɷ�����
					{
						lastDay = 29;
					} else if(year % 100 ==0) // 400�� ����� �ƴ��� ����
					{
						lastDay = 28;
					} else if(year % 4 ==0)
					{
						lastDay = 29;
					} else { lastDay = 28; } */
					
					/* ��� 3: 29���� ���Ǹ� ��Ƽ� ������ else�� ���� 
					if((year % 4 ==0) && !(year % 100 ==0) || (year % 400 ==0))
					{
						lastDay = 29;
					} else { lastDay = 28; } */
					/*
					if(year % 4 ==0)
					{ //����� 29���� �� ���ɼ��� �ִ� ��ġ!
						if(year % 100 ==0) // 100�� ���
						{
							if() // 400�� ���
							{
								lastDay = 29;
							} else
							{
								lastDay = 28; // 4�� 100���� �������µ� 400���δ� �ȳ�����
							}
						} else
						{
							lastDay = 29; // 4�δ� �������� 100���δ� �ȳ�����
						}
					} else
					{
						lastDay = 28;
					} */
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					lastDay = 30;
					break;
				default:
					lastDay = 31;
					break;
			}
			// �޷� ����ϱ�
			
			System.out.println("last day = " + lastDay);
		}
			
		scan.close();
	}

}
