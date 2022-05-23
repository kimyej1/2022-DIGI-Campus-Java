import java.util.Scanner;

public class A14Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub
		/*
		 * random : 0~1 사이의 더블
		 * 
		 * 무한루프를 돌면서 주사위 번호를 예측하는 프로그램
		 * 1. 주사위 예측값을 입력하세요(guess)
		 * 2. 주사위를 던지기(diceFace)
		 * 3. 맞췄으면.. 몇번만에 맞췄는지 출력
		 * 4. 틀리면 추측값, 주사위값 보여주고, 다시 예측
		 */
		
		int count =0;
		int diceFace, guess;
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			diceFace = (int)(Math.random() * 6) + 1;
			System.out.print("주사위 예측값을 입력하세요 : ");
			guess = scan.nextInt();
			
			count++;
			if(guess == diceFace) 
			{
				break;
			} else
			{
				System.out.println("예측한 값 : " + guess);
				System.out.println("주사위 값 : " + diceFace);
			}
		}
		
		System.out.println("예측한 값 : " + guess);
		System.out.println("주사위 값 : " + diceFace);
		System.out.println(count + "회만에 맞추셨습니다!");
		
		scan.close();
		
	}

}
