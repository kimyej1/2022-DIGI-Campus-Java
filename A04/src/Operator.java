import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Mission 1.
		 * 두 숫자(정수) 입력받는다. operand1, operand2 이다.
		 * 연산의 결과는 result에 정수로 변환된다.
		 * 두 operand를 입력받아서 다음을 각각 출력해라.
		 * +, -, *, %, <<, &, ++, MAX
		 */
		
		int operand1, operand2, result, result1, result2, result3;
		Scanner scan = new Scanner(System.in); // Ctrl+Shift+ O
		
		System.out.print(" Insert operand1 : ");
		operand1 = scan.nextInt();
		
		System.out.print(" Insert operand2 : ");
		operand2 = scan.nextInt();
		
		
		
		result = operand1 + operand2;
		System.out.println(" + : " + result);
		
		result = operand1 - operand2;
		System.out.println(" - : " + result);
		
		result = operand1 * operand2;
		System.out.println(" * : " + result);
		
		result = operand1 % operand2;
		System.out.println(" % : " + result);
		
		result = operand1 << operand2;
		System.out.println(" << : " + result);
		
		result = operand1 & operand2;
		System.out.println(" & : " + result);
		
		result = (operand1 > operand2) ? operand1 : operand2;
		System.out.println(" MAX : " + result);
		
		result = ++operand1;
		System.out.println(" ++operand1 = " + result);
		
		result = ++operand2;
		System.out.println(" ++operand2 = " + result);
		
		result = operand1++;
		System.out.println(" operand1++ = " + result);
		
		result = operand2++;
		System.out.println(" operand2++ = " + result);
		
		System.out.println(operand1 >= operand2);
		
		operand1 = operand1 + 1;
		operand1 += 1;
		
		System.out.println(" != " + (operand1 != operand2));
		System.out.println(" NOT : " + !(5==3));
		
		double degree = 1.86;
		result = (int)degree + 1; // 형변환 : Type Casting
		System.out.println(result);

		
		scan.close();
		
	}

}
