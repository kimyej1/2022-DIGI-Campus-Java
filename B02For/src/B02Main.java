import java.util.Scanner;

public class B02Main 
{

	public static void main(String[] args) 
	{
		// TODO for test
		
		String str = "kbstar good news";
		int no = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 's')
			{
				no++;
			} else
			{
				continue;
			}
		}
		
		/*
		 * for(�ʱⰪ; ����; ����){} 
		 * 
		 * 1
		 * 1 + 2
		 * 1 + 2 + 3
		 * ...
		 * 1 + 2 + 3 + ... + 9 + 10
		 */
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i ++)
		{
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		
		/* 
		 * 1. Count Down (10~0)
		 * 2. 1,3,5,7,...100 
		 * 3. 1st, 2nd, 3rd, 4th, ..., 99th
		 */
		
		for(int i = 10; i >= 0; i --)
		{
			System.out.println(i);
		}
		
		System.out.println("---------------------");
		
		for(int i = 1; i <= 100; i+=2) // i++�� �ϰ� �ؿ��� if�޸�, ���ʿ��� ����� ���� ��
		{
			System.out.println(i);
		}
		
		System.out.println("---------------------");
		
		for(int i = 1; i < 100; i ++)
		{
			String place = "";
			
			if(i>10 && i<20)
			{
				place = "th";
			}
			else
			{
				if(i % 10 == 1)
					place = "st";
				else if(i % 10 == 2)
					place = "nd";
				else if(i % 10 == 3)
					place = "rd";
				else
					place = "th";
			}
			
			System.out.println(i + place);
		}
		
		System.out.println("---------------------");
		
		/*
		 * While (����) // �ѹ��� �� �� ���� �ִ�
		 * {
		 *  	�������� �� ������ ������!! (���ѷ��� �� �� �ִ�) 
		 * }
		 * 
		 * do // ������ �ѹ��� ���� 
		 * {
		 * 
		 * } while (����)
		 */
		
		int counter = 1;
		while(counter <= 10)
		{
			System.out.println(counter); // �̷��Ը� ����.. ��� counter 1�̴ϱ� ���⼭ ���������� ���ϰ� ���ѷ��� 
			counter ++;
		}
		
		System.out.println("---------------------");
		
		/* 
		 * 1. Count Down (10~0)
		 * 2. 1,3,5,7,...100 
		 * 3. 1st, 2nd, 3rd, 4th, ..., 99th
		 */
		
		int i = 10;
		while(i >= 0)
		{
			System.out.println(i);
			i--;
		}
		
		System.out.println("---------------------");
		
		i = 1;
		while(i <= 100)
		{
			System.out.println(i);
			i+=2;
		}
		
		System.out.println("---------------------");
		
		i = 1;
		while(i < 100)
		{
			if(i < 10 || i > 20)
			{
				int remainder = i % 10;
				switch(remainder)
				{
					case 1:
						System.out.println(i + "st");
						break;
					case 2:
						System.out.println(i + "nd");
						break;
					case 3:
						System.out.println(i + "rd");
						break;
					default:
						System.out.println(i + "th");
						break;
				}
			} else
			{
				System.out.println(i + "th");
			}
			i++;
		}
		
		// Math.random() : 0 ~ 1 ������ ���� �Ǽ� 
		
		int rand = (int)(Math.random() * 10); // 0 ~ 10 ������ ���� ���� 
//		System.out.println("rand = " + rand);
		
		Scanner scan = new Scanner(System.in);
		int tries = 0;
		int input;
	
		do // ���� �ѹ��� ������ �õ��Ѵ�! 
		{
			System.out.print("Insert 1 ~ 10 : ");
			input = scan.nextInt();
			tries++;
			
			if(input != rand)
			{
				System.out.println("Wrong !!");
			}
			
		} while(rand != input); // rand�� input�� �������� ���ȿ� ��� ���� 
		
		System.out.println("Correct !! ... tries = " + tries);
		
		
		while(true) // ���ѷ���
		{
			System.out.print("[1] Push [2] Pop [3] Dump [4] Exit : ");
			input = scan.nextInt();
			
			if(input == 4)
			{
				break;
			}
		}
		
		/*
		 * ���ѷ��� ���鼭, ����ڷκ��� ������ �޾Ƽ� �������� ����Ѵ�.
		 * while������ 
		 * ����ڰ� 0 �Է��ϸ� ���� 
		 */
		
		while(true)
		{
			System.out.print("Insert table (0 = Exit) : ");
			int table = scan.nextInt();
			
			if(table == 0)
			{
				System.out.println("Exit...");
				break;
			} else
			{
				int num = 9;
				while(num > 0)
				{
					System.out.println(table + " * " + num + " = " + (table * num));
					num --;
				}
				System.out.println("---------------------");
			}
		}
			
		scan.close();

	}
}
