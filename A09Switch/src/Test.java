
public class Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

		
		/* Switch
		 * if�� T/F �ΰ��� ����̹Ƿ�, ����� ���� ���� �� Switch ����ϸ� ������
		 * ����(x�̻� y����)���� ������, �� �������� ���� ��!
		 */
		int month = 2;
		
		// ��� 1 : 1~12������ �� ������ �Է�
		switch(month)
		{
			case 1: 
				System.out.println("31");
				break;
			case 2:
				System.out.println("28");
				break;
			case 3:
				System.out.println("31");
				break;
			case 4:
				System.out.println("30");
				break;
			default: 
			// ���� ������ ���߿� ������ default (��) 6 �Է����� ��
			// ���� ���� ���� ���� default��
				System.out.println("31");
				break;
		}
		
		// ��� 2 : break ���������� ����Ǵ� Ư�� �̿�
		switch(month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("31");
				break;
			case 2:
				System.out.println("28");
				break;
			default:
				System.out.println("30");
				break;
		}
		
		// ��� 3: ���� ���� ���°� default�� �ΰ� �� �����ϰ�
		switch(month)
		{
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30");
				break;
			case 2:
				System.out.println("28");
				break;
			default:
				System.out.println("31");
				break;
		}
	}

}
