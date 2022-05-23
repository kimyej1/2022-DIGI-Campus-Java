import java.util.Arrays;
import java.util.Scanner;

interface Error
{
	public void gameError();
}

class Lotto implements Error
{
	private int[] lotto;
	
	public Lotto()
	{
		lotto = new int[6];
	}
	public void makeLotto()
	{
		for(int i=0; i<lotto.length; i++)
		{
			lotto[i] = (int)((Math.random() * 45) + 1);
			
			for(int j=0; j<i; j++)
			{
				if(lotto[i] == lotto[j])
				{
					i--;
					break;
				}
			}	
		}	
		sortLotto();
	}
	
	private void sortLotto()
	{
		for(int i=0; i<lotto.length; i++)
		{
			for(int j=i+1; j<lotto.length; j++)
			{
				if(lotto[j] < lotto[i])
				{
					int temp = lotto[j];
					lotto[j] = lotto[i];
					lotto[i] = temp;
				}
			}
		}
	}

	public void printLotto()
	{
		for(int i=0; i<lotto.length; i++)
		{
			System.out.printf("%02d", lotto[i]); // 두자리 형식으로 출력 
			System.out.print(" ");
		}
		System.out.println("");
		
	}
	
	@Override
	public void gameError() {
		// TODO Auto-generated method stub
		System.out.println("ERROR : Insert number between 1 ~ 5");
	}	
}

public class B06Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Lotto lotto = new Lotto();
		
		while(true)
		{
			System.out.print("Insert game 1 ~ 5 (0 to Exit) : ");
			int game = scan.nextInt();
			
			if(game == 0)
			{
				System.out.println("Exit...");
				break;

			} else if(game < 0 || game > 5)
			{
				lotto.gameError();		
			} else
			{
				for(int i=1; i<=game; i++)
				{
					lotto.makeLotto();
					lotto.printLotto();
				}
			}
		}
		scan.close();
	}
}
