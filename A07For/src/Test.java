
public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		// �ݺ��� --> ���� ����!!
		// for(�ʱⰪ; ����; ����) {}
		
		int i; // x, y �̷� �ǹ̾��� ���ĺ�(integer�� �̴ϼ�) --> i, j, k, ...
		
		//for + if ���ǹ�
		for ( i = 1; i <= 10; i++) // i++, i=i+1, i+=1
		{
			if (i % 3 == 0)
			{
				System.out.println(i);
			}
		}
		
		// �齽���� tab, new line
		System.out.print("abc\tdef\n");
		
		// 5�ڸ� ���ڷ� ���
		for (i = 1; i < 20; i++)
		{
			// System.out.print(i + "\t");
			System.out.printf("%05d\t", i); 
			// f(format) 
			// d(decimal) = 10�������� ǥ���ض�!
		}
		
		System.out.println("\n--------------------------------");
		
		// �޷¸���� 1��~31��(�α��ڷ�)
		for (i = 1; i <= 31; i++)
		{
			System.out.printf("%02d\t", i);
			
			if (i % 7 == 0)
			{
				System.out.println("");
			}
		}
		
		System.out.println("End i = " + i); 
	}

}

