import java.util.Date;
import java.util.StringTokenizer;

public class B16Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date now = new Date(); // java.util.Date & java.sql.Date 중 선택 
		System.out.println("date = " + now.getClass());
		
		System.out.println("now = " + now);
		System.out.println("Month = " + now.getMonth());
		
		// 문자열, tokenizer()
		
		StringTokenizer st = new StringTokenizer("C,C++,Java,Python,JS,HTML", ","); // ',' 기준으로 구분해서 나눠라 (, = 구분자 Delimiter) 
		while(st.hasMoreTokens()) // 더 쪼갤 데이터가 있다면~ 
		{
			System.out.println(st.nextToken());
		}
		
	}

}
