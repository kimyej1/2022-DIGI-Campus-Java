import java.util.Scanner;

public class A14Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub
		/*
		 * random : 0~1 ������ ����
		 * 
		 * ���ѷ����� ���鼭 �ֻ��� ��ȣ�� �����ϴ� ���α׷�
		 * 1. �ֻ��� �������� �Է��ϼ���(guess)
		 * 2. �ֻ����� ������(diceFace)
		 * 3. ��������.. ������� ������� ���
		 * 4. Ʋ���� ������, �ֻ����� �����ְ�, �ٽ� ����
		 */
		
		int count =0;
		int diceFace, guess;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			diceFace = (int)(Math.random() * 6) + 1;
			System.out.print("�ֻ��� �������� �Է��ϼ��� : ");
			guess = scan.nextInt();
			
			count++;
			if(guess == diceFace) 
			{
				break;
			} else
			{
				System.out.println("������ �� : " + guess);
				System.out.println("�ֻ��� �� : " + diceFace);
			}
		}
		
		System.out.println("������ �� : " + guess);
		System.out.println("�ֻ��� �� : " + diceFace);
		System.out.println(count + "ȸ���� ���߼̽��ϴ�!");
		
		scan.close();
		
	}

}
