import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Mission 1.
		 * �� ����(����) �Է¹޴´�. operand1, operand2 �̴�.
		 * ������ ����� result�� ������ ��ȯ�ȴ�.
		 * �� operand�� �Է¹޾Ƽ� ������ ���� ����ض�.
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
		result = (int)degree + 1; // ����ȯ : Type Casting
		System.out.println(result);

		
		scan.close();
		
	}

}
