
public class If 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int age = 33;
		
		if (age < 20)
			System.out.println("�̼������Դϴ�."); // if���� true�϶��� ����, false�� ����
		
		if (age >=20 ) 
		{
			System.out.println("20�캸�� ������...");
			System.out.println("�����Դϴ�!");
		}
		
		
		boolean isMale = true;
		
		if (isMale == true) // ���ڸ�,
		{
			System.out.println("�����Դϴ�.");
		} else
			System.out.println("�����Դϴ�.");
		
		
		
		if (isMale) // ���ڸ�,
		{
			System.out.println("�����Դϴ�.");
		} else
			System.out.println("�����Դϴ�.");
		
		
		if (!isMale) // ���ڰ� �ƴϸ�, == ���ڸ�,
		{
			System.out.println("�����Դϴ�.");
		} else
			System.out.println("�����Դϴ�.");
		
		
		int degree = 88;
		
		if (degree >= 90) 
		{
			System.out.println("A");
		} else 
		{ // else��°� �̹� 90�� �̸��̹Ƿ�, �ι�° if���� 90< ����
		
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
