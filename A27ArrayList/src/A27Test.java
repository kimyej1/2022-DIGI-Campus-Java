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
		
		strList.remove(2);		// AA - DD - CC -> BB�� 2���ڸ����ٴ°� ����ϰ��־����
		strList.remove("BB");	// AA - DD - CC -> object �������� �����޶�� ��û
		
		/* DD�� �ִ°�?
		 * ������ �ٲ�� -> KK�� (������ ����)
		 */
		
		int index = strList.indexOf("DD");	// DD�� ��ġ�� ã���� (���°� ã�ƴ޶�� �ϸ� ����� -1 ��)
		if(index >= 0)						// DD�� ��ġ�� -1�� �ƴ϶��~ ( = DD�� �ִٸ�)
		{
			strList.set(index, "KK");		// DD�� ��ġ�� KK�� �ٲ��� : AA - KK - CC
		}
		
		for(int i = 0; i < strList.size(); i++) // array : length, list : size
		{
			System.out.println(strList.get(i));
		}
		
		System.out.println(strList);
		
		/*
		 * Scanner�� �̿���... ������ ����� �Է¹޴´�.
		 * [1] Add [2] Set [3] Remove [4] Show [0] Exit
		 * intList�� ������ ����ڸ�� 1~5�� �����ȴ�.
		 *   - Add: ���� �Է¹޾� �� �ڿ� ���δ�.
		 *   - Set: 0��° ���� ���� �Է¹޴� ������ �ٲ۴�.
		 *   - Remove: 0��° �����͸� �����.
		 */
		
		Scanner scan = new Scanner(System.in);
		boolean findFlag  = false;
				
		while(true)
		{
			System.out.print("������ ����� �Է��ϼ��� [1] Add [2] Set [3] Remove [4] Show [0] Exit : ");
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
					System.out.println("Error: 0~4 ������ ���� �Է��ϼ���");
					break;
			}
			
			if(findFlag == true)
			{
				break;
			}
			
		
			/*Scanner scan = new Scanner(System.in);
			
			while(true)
			{
				System.out.print("������ ����� �Է��ϼ��� [1] Add [2] Set [3] Remove [4] Show [0] Exit : ");
				int i = scan.nextInt();
				
				if(i < 0 || i > 4)
				{
					System.out.println("[Error] 0~4 ������ ���ڸ� �Է��ϼ���");
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
