
public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		int degree = 88;
		
		
		// ��� 1	
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
		
		
		// ��� 2
		if (degree >= 90)
		{
			System.out.println("AA");
		} else if (degree >= 80) // else if�̹Ƿ� 90���� �۴ٴ� ���� �̹� ����
		{
			System.out.println("BB");
		} else if (degree >= 70) // 80���� ����
		{
			System.out.println("CC");
		} else
		{
			System.out.println("FF");
		}
		
		
		// ��� 3
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
