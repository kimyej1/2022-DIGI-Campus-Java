import java.util.Scanner;

public class B07Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int [] ages = new int[3]; // �迭 �̸��� ����������! 
		
		int sum = 0;
		for(int i = 0; i<ages.length; i++)
		{
			System.out.print("Insert Age " + (i+1) + " : ");
			ages[i] = scan.nextInt();
			sum += ages[i];
		}
		
		System.out.println("��� = " + (double)sum/ages.length);
		System.out.printf("��� = %.2f ", (double)sum/ages.length); // %~ �� �ڸ��� ���� ���缭 ,���� ���� �־�� 
		
		int a = 3, b = 12, c = 123;
		System.out.printf("a = %5d, b = %05d, c = %d", a, b, c);
		
		printArray(ages);
		// 12.34
		
		int result = add(1,2);
		
		int[][] ptr = new int[2][4]; // 2���� �迭 : 3�� 5�� : 2���� �迭�� ������ for���� �ι� ����! 
		for(int i = 0; i < ptr.length; i++)
		{
			for(int j = 0; j < ptr[0].length; j++) // 2���� 4�� = �� 8�� 
			{
				System.out.printf("ptr[%d][%d] : ", i, j);
				ptr[i][j] = scan.nextInt(); // i�� j�� ���� �Է¹ޱ� 
			}
		}
		
		scan.close();
	}
	
	public static void printArray(int[] array) // static : �����޸� 
	{
		System.out.println("print array...");
		for(int i=0; i<array.length; i++)
		{
			// array[0] = 11
			System.out.println("array[" + i + "] = " + array[i] );
			System.out.printf("array[%d] = %d\n", i, array[i]); // ���� �ǹ�, printf�� �ϸ� �� ����! 
		}
	}
	
	public static int add(int a, int b)
	{
		return a + b;
	}

}
