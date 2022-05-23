import java.util.Scanner;

public class B07Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int [] ages = new int[3]; // 배열 이름은 복수형으로! 
		
		int sum = 0;
		for(int i = 0; i<ages.length; i++)
		{
			System.out.print("Insert Age " + (i+1) + " : ");
			ages[i] = scan.nextInt();
			sum += ages[i];
		}
		
		System.out.println("평균 = " + (double)sum/ages.length);
		System.out.printf("평균 = %.2f ", (double)sum/ages.length); // %~ 이 자리에 형식 맞춰서 ,뒤의 값을 넣어라 
		
		int a = 3, b = 12, c = 123;
		System.out.printf("a = %5d, b = %05d, c = %d", a, b, c);
		
		printArray(ages);
		// 12.34
		
		int result = add(1,2);
		
		int[][] ptr = new int[2][4]; // 2차원 배열 : 3행 5열 : 2차원 배열은 무조건 for문을 두번 돈다! 
		for(int i = 0; i < ptr.length; i++)
		{
			for(int j = 0; j < ptr[0].length; j++) // 2번씩 4번 = 총 8번 
			{
				System.out.printf("ptr[%d][%d] : ", i, j);
				ptr[i][j] = scan.nextInt(); // i행 j열 값을 입력받기 
			}
		}
		
		scan.close();
	}
	
	public static void printArray(int[] array) // static : 공유메모리 
	{
		System.out.println("print array...");
		for(int i=0; i<array.length; i++)
		{
			// array[0] = 11
			System.out.println("array[" + i + "] = " + array[i] );
			System.out.printf("array[%d] = %d\n", i, array[i]); // 같은 의미, printf로 하면 더 간결! 
		}
	}
	
	public static int add(int a, int b)
	{
		return a + b;
	}

}
