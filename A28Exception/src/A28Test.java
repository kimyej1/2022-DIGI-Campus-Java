import java.util.Scanner;

public class A28Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int x = 4;
		int y = 0;
		int result;

		
		if (x == 0 || y == 0)
		{
			System.out.println("ERROR : 0이 아닌 수를 입력하세요~");
		} else
		{	
			result = x / y;
			System.out.println("result = " + result);
		}
		
		try 
		{
			result = x / y;
			System.out.println("try result = " + result);
		
		} catch(ArithmeticException e) // 연산에서 오류가 났다
		{
			System.out.println("연산 오류..");
		
		} catch(Exception e) // 그 외
		{
			System.out.println("Divided by 0...");
			System.out.println(e.getMessage());
		}
		
		Scanner scan = new Scanner(System.in);
		
		// 숫자를 입력(int input)받는데 "홍길동"으로 입력
		
		System.out.print("숫자를 입력하세요 : ");
		
		try {
			int input = scan.nextInt();
			System.out.println("input = " + input);
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Fin");
		}
		
		scan.close();
	}
}
