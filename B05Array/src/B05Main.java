import java.util.Arrays;
import java.util.Scanner;

public class B05Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] lotto = new int[6];
		int cnt = 0;
		Scanner scan = new Scanner(System.in);
		
		int[] realLotto = {15,23,29,34,40,44};
		while(true)
		{
			// �� ���� ���� ���´�.
			// 0 �����̸� ���α׷� ����
			
//			System.out.print("Insert game (0 to Exit) : ");
//			int game = scan.nextInt();
//			
//			if(game == 0)
//			{
//				System.out.println("Exit...");
//				break;
//			} else
//			{
//				for(int i=1; i<=game; i++) // �Է��� ���� Ƚ����ŭ ���� 
//				{
					/*
					 * 6���� �ζ� ��ȣ(1-45)�� �����Ѵ�.
					 * ���� �������� �ߺ��� ���� ����.
					 * ���Ӵ� 03, 10, 20, 30, 35, 40 �� ���� �������� ����Ѵ�.
					 * 
						 * < �����ڵ� >
						 * syso("%02d",3);
						 * �� �ڸ��� decimal�� ����ϴµ�,
						 * �� �ڸ� ���� 03�� ���� ��½�Ű��
						 * ��� Format ���ߴ� �Լ� printf() ���! 
					 */
					
//					System.out.println("\nGame no." + i);
					
					for(int n=0; n<lotto.length; n++)
					{
						lotto[n] = (int)((Math.random() * 45) + 1);
						
						for(int m=0; m<n; m++) //�ߺ� ���Ÿ� ���� 
						{
							if(lotto[n] == lotto[m])
							{
								n--;
								break;
							}
						}						
					}	
					Arrays.sort(lotto); // �������� ���� 
					
//					for(int n=0; n<lotto.length; n++)
//					{
//						System.out.printf("%02d", lotto[n]); // ���ڸ� �������� ��� 
//						System.out.print(" ");
//					}
					
					if(Arrays.equals(lotto, realLotto) == true)
					{
						System.out.println(cnt + "�� ���� ���߼̽��ϴ�!");
						break;
					} else
					{
						cnt++;
					}
//				}
//			}
//			break;
		}

		scan.close();
	}

}
