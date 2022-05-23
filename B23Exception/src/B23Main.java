import java.io.IOException;

public class B23Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 4;
		int b = 1;
		int result;
		
		try {
			result = a / b; // b�� 0 ���� ������ �� ����! (���� ���ɼ��� �ִ� ��)
			System.out.println("result = " + result);
		} catch (ArithmeticException e) {
			System.out.println("Arithemetic Exception"); // ArithmeticException�� exception���� ���� �����̶�, ���� ���� �ٲ�� unreachable code	�� 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		} finally { // try, catch ��� ����� ������ ������ (����� �ڿ��� �ִٸ� ���⼭ ��� �ݳ�!) 
			System.out.println("Finally");
		}
		
		System.out.println("END");
		
		String msg;
		msg = readMessage();
		System.out.println("msg = " + msg);
		
		try {
			msg = readMessage2(); // ���⿡ Try/catch �ʿ� (throws IOException ������) 
			System.out.println("msg = " + msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
		
		
		
	}
	
	public static String readMessage2()throws IOException // Exception �ص� ������, �ʹ� �������� + ������ ����� �ʰ� �������� ��Ų���� ����
	{
		byte[] buffer = new byte[1024];
		System.out.println("���ڿ� �Է��Ͻÿ�.");
		
		System.in.read(buffer);
		return new String(buffer);
		
	}
	
	public static String readMessage()
	{
		byte[] buffer = new byte[1024]; // network���� �������� byte Ÿ���̾����! 
		System.out.println("���ڿ� �Է��Ͻÿ�.");
		try {
			System.in.read(buffer);
			return new String(buffer); // ����ó���� �갡 �˾Ƽ� �ع�����, �� ��Ų ���� ĳġ�� ���� �� ���� 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
		
	}

}
