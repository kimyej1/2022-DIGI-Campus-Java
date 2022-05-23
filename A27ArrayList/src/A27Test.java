import java.util.ArrayList;
import java.util.Scanner;

public class A27Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub

		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		strList.add("AA"); 		// AA -
		strList.add("BB"); 		// AA - BB
		strList.add("CC"); 		// AA - BB - CC
		strList.add(1, "DD"); 	// AA - DD - BB - CC
		
		strList.remove(2);		// AA - DD - CC -> BB가 2번자리였다는걸 기억하고있어야함
		strList.remove("BB");	// AA - DD - CC -> object 기준으로 지워달라고 요청
		
		/* DD가 있는가?
		 * 있으면 바꿔라 -> KK로 (없으면 못함)
		 */
		
		int index = strList.indexOf("DD");	// DD의 위치를 찾아줘 (없는거 찾아달라고 하면 결과로 -1 줌)
		if(index >= 0)						// DD의 위치가 -1이 아니라면~ ( = DD가 있다면)
		{
			strList.set(index, "KK");		// DD의 위치를 KK로 바꿔줘 : AA - KK - CC
		}
		
		for(int i = 0; i < strList.size(); i++) // array : length, list : size
		{
			System.out.println(strList.get(i));
		}
		
		System.out.println(strList);
		
		/*
		 * Scanner를 이용해... 수행할 명령을 입력받는다.
		 * [1] Add [2] Set [3] Remove [4] Show [0] Exit
		 * intList의 동작은 사용자명령 1~5로 결정된다.
		 *   - Add: 수를 입력받아 맨 뒤에 붙인다.
		 *   - Set: 0번째 값을 새로 입력받는 값으로 바꾼다.
		 *   - Remove: 0번째 데이터를 지운다.
		 */
		
		Scanner scan = new Scanner(System.in);
		boolean findFlag  = false;
				
		while(true)
		{
			System.out.print("수행할 명령을 입력하세요 [1] Add [2] Set [3] Remove [4] Show [0] Exit : ");
			int i = scan.nextInt();
			
			switch(i)
			{
				case 1:
					System.out.print("Add : ");
					int num1 = scan.nextInt();
					intList.add(num1);
					System.out.println(intList);
					break;

				case 2:
					System.out.print("Set : ");
					int num2 = scan.nextInt();
					intList.set(0, num2);
					System.out.println(intList);
					break;

				case 3:
					intList.remove(0);
					System.out.println(intList);
					break;

				case 4:
					System.out.println(intList);
					break;

				case 0:
					findFlag = true;
					break;
				default:
					System.out.println("Error: 0~4 사이의 수를 입력하세요");
					break;
			}
			
			if(findFlag == true)
			{
				break;
			}
			
		
			/*Scanner scan = new Scanner(System.in);
			
			while(true)
			{
				System.out.print("수행할 명령을 입력하세요 [1] Add [2] Set [3] Remove [4] Show [0] Exit : ");
				int i = scan.nextInt();
				
				if(i < 0 || i > 4)
				{
					System.out.println("[Error] 0~4 사이의 숫자를 입력하세요");
				} if(i == 1)
				{
					System.out.print("Add : ");
					int num = scan.nextInt();
					
					intList.add(num);
					System.out.println("Add " + num + " : " + intList);
	
				} if(i == 2)
				{
					System.out.print("Set : ");
					int num = scan.nextInt();
					
					intList.set(0, num);
					System.out.println("Set [0] to " + num + " : " + intList);
	
				} if(i == 3)
				{
					intList.remove(0);
					System.out.println("remove [0] : " + intList);
	
				} if(i == 4)
				{
					System.out.println("show intList : " + intList);
	
				} if(i == 0)
				{
					System.out.println("Exit");
					break;
				}
			}*/
		
		scan.close();
		}
	}
}
