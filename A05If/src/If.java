
public class If 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int age = 33;
		
		if (age < 20)
			System.out.println("미성년자입니다."); // if문이 true일때만 수행, false면 무시
		
		if (age >=20 ) 
		{
			System.out.println("20살보다 많군요...");
			System.out.println("성인입니다!");
		}
		
		
		boolean isMale = true;
		
		if (isMale == true) // 남자면,
		{
			System.out.println("남자입니다.");
		} else
			System.out.println("여자입니다.");
		
		
		
		if (isMale) // 남자면,
		{
			System.out.println("남자입니다.");
		} else
			System.out.println("여자입니다.");
		
		
		if (!isMale) // 남자가 아니면, == 여자면,
		{
			System.out.println("남자입니다.");
		} else
			System.out.println("여자입니다.");
		
		
		int degree = 88;
		
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
		
		System.out.println("***************************************");
		

		
		/*
		if (degree >= 90) 
		{
			System.out.println("A");
		}
		if (90 > degree >= 80) 
		{
			System.out.println("B");
		} 
		if (80 > degree >=70)
		{
			System.out.println("C");
		} else 
			{
				System.out.println("F");
			}
		 
		*/
		
		System.out.println("End");
		
		
	}

}
