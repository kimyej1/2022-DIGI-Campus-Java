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
			// 몇 게임 할지 묻는다.
			// 0 게임이면 프로그램 종료
			
//			System.out.print("Insert game (0 to Exit) : ");
//			int game = scan.nextInt();
//			
//			if(game == 0)
//			{
//				System.out.println("Exit...");
//				break;
//			} else
//			{
//				for(int i=1; i<=game; i++) // 입력한 게임 횟수만큼 진행 
//				{
					/*
					 * 6개의 로또 번호(1-45)를 추출한다.
					 * 추출 과정에서 중복된 수는 제거.
					 * 게임당 03, 10, 20, 30, 35, 40 과 같은 형식으로 출력한다.
					 * 
						 * < 참고코드 >
						 * syso("%02d",3);
						 * 두 자리의 decimal로 출력하는데,
						 * 한 자리 수는 03과 같이 출력시키는
						 * 출력 Format 맞추는 함수 printf() 사용! 
					 */
					
//					System.out.println("\nGame no." + i);
					
					for(int n=0; n<lotto.length; n++)
					{
						lotto[n] = (int)((Math.random() * 45) + 1);
						
						for(int m=0; m<n; m++) //중복 제거를 위해 
						{
							if(lotto[n] == lotto[m])
							{
								n--;
								break;
							}
						}						
					}	
					Arrays.sort(lotto); // 오름차순 정렬 
					
//					for(int n=0; n<lotto.length; n++)
//					{
//						System.out.printf("%02d", lotto[n]); // 두자리 형식으로 출력 
//						System.out.print(" ");
//					}
					
					if(Arrays.equals(lotto, realLotto) == true)
					{
						System.out.println(cnt + "번 만에 맞추셨습니다!");
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
