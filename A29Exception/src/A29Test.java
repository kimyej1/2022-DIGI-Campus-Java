import java.util.Scanner;

public class A29Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub


		
		/*
		System.out.print("Insert age : ");
		
		try {
			age = scan.nextInt();
			System.out.println("age = " + age);
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		scan.close();
		*/
		
		age = getAge();
	}

	
	public static int getAge()
	{
		Scanner scan = new Scanner(System.in);
		int age = 0;
		System.out.print("Insert age : ");
		
		try {
			age = scan.nextInt();
			System.out.println("age = " + age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�߸��Է������ϱ� 1��� �����Ѵ�.");
			age = 1;
		}
				
		scan.close();
		return age;
	}
}
