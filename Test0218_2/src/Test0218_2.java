import java.util.Scanner;

public class Test0218_2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int count = 0;
		
		String[] msg = str.split(" ");
		
		for(int i = 0; i<msg.length; i++)
		{
			if(msg[i].equals(" ") == false)
				
			{
				count++;
			}
		}
		System.out.println(count - 1);
	}

}

