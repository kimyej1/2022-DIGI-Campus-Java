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
		 * for(초기값; 조건; 증감){} 
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
		
		for(int i = 1; i <= 100; i+=2) // i++로 하고 밑에다 if달면, 불필요한 계산이 많이 생
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
		 * While (조건) // 한번도 안 돌 수도 있다
		 * {
		 *  	실행전에 꼭 눈으로 컴파일!! (무한루프 돌 수 있다) 
		 * }
		 * 
		 * do // 무조건 한번은 돈다 
		 * {
		 * 
		 * } while (조건)
		 */
		
		int counter = 1;
		while(counter <= 10)
		{
			System.out.println(counter); // 이렇게만 쓰면.. 계속 counter 1이니까 여기서 빠져나가지 못하고 무한루프 
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
		
		// Math.random() : 0 ~ 1 사이의 랜덤 실수 
		
		int rand = (int)(Math.random() * 10); // 0 ~ 10 사이의 랜덤 정수 
//		System.out.println("rand = " + rand);
		
		Scanner scan = new Scanner(System.in);
		int tries = 0;
		int input;
	
		do // 최초 한번은 무조건 시도한다! 
		{
			System.out.print("Insert 1 ~ 10 : ");
			input = scan.nextInt();
			tries++;
			
			if(input != rand)
			{
				System.out.println("Wrong !!");
			}
			
		} while(rand != input); // rand랑 input이 같지않은 동안엔 계속 돌기 
		
		System.out.println("Correct !! ... tries = " + tries);
		
		
		while(true) // 무한루프
		{
			System.out.print("[1] Push [2] Pop [3] Dump [4] Exit : ");
			input = scan.nextInt();
			
			if(input == 4)
			{
				break;
			}
		}
		
		/*
		 * 무한루프 돌면서, 사용자로부터 구구단 받아서 역순으로 출력한다.
		 * while문으로 
		 * 사용자가 0 입력하면 종료 
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
