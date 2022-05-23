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
			org = input; // 마지막에 박수 안칠때를 위해 원본값 저장
			
			if(input == 0)
			{
				break;
			}
			
			count = 0; // 하나 끝나면 처음(0)부터 다시 반복해야하니까
			while(input > 0)
			{
				int one = input % 10; // 처음 숫자가 123456이면 나눠서 6만 봄
				if(one == 3 || one == 6 || one == 9)
				{
					count++;
				}
				
				input = input / 10; // 123456 --> 12345로 바꿔놓고 while 다시 돌림(5만 봄)
			}
			
			for(i=1; i<=count; i++)
			{
				System.out.print("clap ");
			}
			
			if(count == 0)
			{
				System.out.println(org); // input 여기에 넣으면 0만나옴(반복되다가 break되는 시점의 input)
			}
			
			System.out.println(""); // 줄바꿈
		}
		
		scan.close();			
		
	}

}
