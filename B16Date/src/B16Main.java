import java.util.Date;
import java.util.StringTokenizer;

public class B16Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date now = new Date(); // java.util.Date & java.sql.Date �� ���� 
		System.out.println("date = " + now.getClass());
		
		System.out.println("now = " + now);
		System.out.println("Month = " + now.getMonth());
		
		// ���ڿ�, tokenizer()
		
		StringTokenizer st = new StringTokenizer("C,C++,Java,Python,JS,HTML", ","); // ',' �������� �����ؼ� ������ (, = ������ Delimiter) 
		while(st.hasMoreTokens()) // �� �ɰ� �����Ͱ� �ִٸ�~ 
		{
			System.out.println(st.nextToken());
		}
		
	}

}
