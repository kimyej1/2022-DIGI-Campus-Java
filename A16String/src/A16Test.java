
public class A16Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub
			// Car taxi = new Car();
		
		String str1 = "Hello World";
		String str2 = "hello world";
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		int length;
		length = str1.length();
		System.out.println("length = " + length);
		
		int i;
		
		for(i=0; i<length; i++)
		{
			char c = str1.charAt(i);
			System.out.println(i + " : " + c);
		}
		
		char third = str1.charAt(2);
		boolean isSame = str1.equalsIgnoreCase(str2);
		System.out.println("isSame = " + isSame);
		
		isSame = str1.equals(str2); // 두가지 비교할 때 사용
		System.out.println("isSame2 = " + isSame);
		
		String str3 = str1.replace('e', 'k'); // 문자니까 작은따옴표, char '' string ""
		// 한 문자씩만 바꿀 수 있음
		System.out.println("str3 = " + str3);
	
		str3 = str1.substring(2, 4);
		System.out.println("str3 = " + str3);
		
		str3 = str1.toUpperCase();
		System.out.println("str3 = " + str3);
		
		str1 = "prev";
		str2 = "next";
		str3 = str1 + str2;
		System.out.println(str3);
		str3 = "hello" + 123;
		System.out.println(str3);
		str3 = "12" + 34;
		System.out.println(str3);
		int a = 34;
		int b = 77;
		System.out.println("12"  + a);
		
		str3 = "ABC";
		System.out.println("str3 = " + str3 + ", a = " + a);
		
		System.out.println("(a, b) = (" + a + ", " + b + ")");
		
		printXY(a,b);
		printXY(3,4);
		
		for(a = 1; a<=9; a++)
		{
			for(b=1; b<=9; b++)
			{
				printXY(a,b);
			}
		}
	}
	
	public static void printXY(int x, int y)
	{
		System.out.println("(" + x + ", " + y + ")");
	}

}
