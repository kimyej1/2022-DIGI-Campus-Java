import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=5, b=4, c=2, d;
		
		d = a + b * c; // �������� ���
		System.out.println(" + * : " + d);
		
		d = (a + b) * c; // �������� ���
		System.out.println(" + * : " + d);
		
		/*
		 *  + operator
		 *  a + b : a, b : operand, ���׿�����
		 *  ++a : ���࿬���� 
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
		 * �� And, �� Or
		 */
		
		System.out.println(" AND : " + (5>3 && 5>1));
		System.out.println(" AND : " + (5>3 && 5<1));
		
		System.out.println(" OR : " + (5>3 || 5>1));
		System.out.println(" OR : " + (5>3 || 5<1));
		
		/*
		 * ���׿�����: ��� ���α׷� �������� ����
		 * ?: 
		 * ����? ���� �� �ؾߵǴ� ��: �����϶� �ؾߵǴ� ��
		 */
		
		a = 5;
		b = 3;
		d = a > b ? a : b; // a�� b���� ū��? ���̸� d�� a �ְ�, �����̸� b �ֱ�
		System.out.println(" max1 : " + d);
		
		a = 5;
		b = 13;
		d = a > b ? a : b; // a�� b���� ū��? ���̸� d�� a �ְ�, �����̸� b �ֱ�
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
