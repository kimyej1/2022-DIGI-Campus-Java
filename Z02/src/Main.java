
public class Main 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub

		// �迭 10�� ������
		// 3, 6, 9, 12, ... �ִ´�.
		// �迭�� �� ���� ���Ͻÿ�
		
		int[] array = new int[10];
		int total = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = (i + 1) * 3;
			System.out.println(array[i]);
			total += array[i];
		}
		
		System.out.println("total = " + total);
		
	}

}
