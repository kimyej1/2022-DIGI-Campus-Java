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
			System.out.println("ERROR : 0�� �ƴ� ���� �Է��ϼ���~");
		} else
		{	
			result = x / y;
			System.out.println("result = " + result);
		}
		
		try 
		{
			result = x / y;
			System.out.println("try result = " + result);
		
		} catch(ArithmeticException e) // ���꿡�� ������ ����
		{
			System.out.println("���� ����..");
		
		} catch(Exception e) // �� ��
		{
			System.out.println("Divided by 0...");
			System.out.println(e.getMessage());
		}
		
		Scanner scan = new Scanner(System.in);
		
		// ���ڸ� �Է�(int input)�޴µ� "ȫ�浿"���� �Է�
		
		System.out.print("���ڸ� �Է��ϼ��� : ");
		
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
