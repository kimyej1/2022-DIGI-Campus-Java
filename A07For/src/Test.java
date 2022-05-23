
public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		// 반복문 --> 빠른 계산력!!
		// for(초기값; 조건; 증감) {}
		
		int i; // x, y 이런 의미없는 알파벳(integer의 이니셜) --> i, j, k, ...
		
		//for + if 조건문
		for ( i = 1; i <= 10; i++) // i++, i=i+1, i+=1
		{
			if (i % 3 == 0)
			{
				System.out.println(i);
			}
		}
		
		// 백슬래쉬 tab, new line
		System.out.print("abc\tdef\n");
		
		// 5자리 숫자로 출력
		for (i = 1; i < 20; i++)
		{
			// System.out.print(i + "\t");
			System.out.printf("%05d\t", i); 
			// f(format) 
			// d(decimal) = 10진법으로 표시해라!
		}
		
		System.out.println("\n--------------------------------");
		
		// 달력만들기 1일~31일(두글자로)
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

