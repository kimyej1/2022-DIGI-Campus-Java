import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=5, b=4, c=2, d;
		
		d = a + b * c; // 곱셈부터 계산
		System.out.println(" + * : " + d);
		
		d = (a + b) * c; // 덧셈부터 계산
		System.out.println(" + * : " + d);
		
		/*
		 *  + operator
		 *  a + b : a, b : operand, 이항연산자
		 *  ++a : 단행연산자 
		 */
		
		d = a % b; // modular 5%2 = 2....1
		System.out.println(" % : "+ d);
		System.out.println(" a==b :" + (a==b));
		
		d = a & b; // and
		System.out.println(" & : " + d);
		
		d = a | b; // or
		System.out.println(" | : " + d);
		
		a = a <<3;
		System.out.println(" << : " + a);
		
		a = a >>1;
		System.out.println(" >> : " + a);
		
		/* 
		 * 논리 And, 논리 Or
		 */
		
		System.out.println(" AND : " + (5>3 && 5>1));
		System.out.println(" AND : " + (5>3 && 5<1));
		
		System.out.println(" OR : " + (5>3 || 5>1));
		System.out.println(" OR : " + (5>3 || 5<1));
		
		/*
		 * 삼항연산자: 모든 프로그램 랭귀지에 공통
		 * ?: 
		 * 조건? 참일 때 해야되는 일: 거짓일때 해야되는 일
		 */
		
		a = 5;
		b = 3;
		d = a > b ? a : b; // a가 b보다 큰가? 참이면 d에 a 넣고, 거짓이면 b 넣기
		System.out.println(" max1 : " + d);
		
		a = 5;
		b = 13;
		d = a > b ? a : b; // a가 b보다 큰가? 참이면 d에 a 넣고, 거짓이면 b 넣기
		System.out.println(" max2 : " + d);
		
		Scanner scan = new Scanner(System.in); // Ctrl+Shift+ O
		
		System.out.print(" Insert a : ");
		a = scan.nextInt();
		System.out.println(" a = " + a);
		
		System.out.print(" Insert b : ");
		b = scan.nextInt();
		System.out.println(" b = " + b);
		
		scan.close();
		
	}

}
