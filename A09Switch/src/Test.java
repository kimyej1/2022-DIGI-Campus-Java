
public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		
		/* Switch
		 * if는 T/F 두가지 경우이므로, 경우의 수가 많을 때 Switch 사용하면 간결함
		 * 범위(x이상 y이하)에는 부적합, 딱 떨어지는 값일 때!
		 */
		int month = 2;
		
		// 방법 1 : 1~12월까지 다 일일이 입력
		switch(month)
		{
			case 1: 
				System.out.println("31");
				break;
			case 2:
				System.out.println("28");
				break;
			case 3:
				System.out.println("31");
				break;
			case 4:
				System.out.println("30");
				break;
			default: 
			// 내가 나열한 것중에 없으면 default (예) 6 입력했을 때
			// 가장 많이 쓰는 것을 default로
				System.out.println("31");
				break;
		}
		
		// 방법 2 : break 만날때까지 진행되는 특성 이용
		switch(month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("31");
				break;
			case 2:
				System.out.println("28");
				break;
			default:
				System.out.println("30");
				break;
		}
		
		// 방법 3: 가장 많이 쓰는걸 default로 두고 더 간결하게
		switch(month)
		{
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30");
				break;
			case 2:
				System.out.println("28");
				break;
			default:
				System.out.println("31");
				break;
		}
	}

}
