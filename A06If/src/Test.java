
public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		int degree = 88;
		
		
		// 방법 1	
		if (degree >= 90) 
		{
			System.out.println("A");
		} else 
		{ // else라는건 이미 90점 미만이므로, 두번째 if문에 90< 생략
		
			if (degree >= 80) 
			{
				System.out.println("B");
			} else
			{
				System.out.println("F");
			}
		}
		
		
		// 방법 2
		if (degree >= 90)
		{
			System.out.println("AA");
		} else if (degree >= 80) // else if이므로 90보다 작다는 조건 이미 내포
		{
			System.out.println("BB");
		} else if (degree >= 70) // 80보다 작음
		{
			System.out.println("CC");
		} else
		{
			System.out.println("FF");
		}
		
		
		// 방법 3
		if (degree >= 90)
		{
			System.out.println("AAA");
		}
		if (degree >= 80 && degree < 90)
		{
			System.out.println("BBB");
		}
		if (degree >= 70 && degree < 80)
		{
			System.out.println("CCC");
		}
		if (degree < 70)
		{
			System.out.println("FFF");
		}
	}

}
