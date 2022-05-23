import java.io.IOException;

public class B23Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 4;
		int b = 1;
		int result;
		
		try {
			result = a / b; // b에 0 들어가면 오류날 수 있음! (오류 가능성이 있는 곳)
			System.out.println("result = " + result);
		} catch (ArithmeticException e) {
			System.out.println("Arithemetic Exception"); // ArithmeticException이 exception보다 작은 개념이라, 둘이 순서 바뀌면 unreachable code	됨 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		} finally { // try, catch 모두 여기는 무조건 지나감 (사용한 자원이 있다면 여기서 모두 반납!) 
			System.out.println("Finally");
		}
		
		System.out.println("END");
		
		String msg;
		msg = readMessage();
		System.out.println("msg = " + msg);
		
		try {
			msg = readMessage2(); // 여기에 Try/catch 필요 (throws IOException 때문에) 
			System.out.println("msg = " + msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} 
		
		
		
	}
	
	public static String readMessage2()throws IOException // Exception 해도 되지만, 너무 광범위함 + 문제가 생기면 너가 하지말고 시킨데다 던져
	{
		byte[] buffer = new byte[1024];
		System.out.println("문자열 입력하시오.");
		
		System.in.read(buffer);
		return new String(buffer);
		
	}
	
	public static String readMessage()
	{
		byte[] buffer = new byte[1024]; // network으로 던지려면 byte 타입이어야함! 
		System.out.println("문자열 입력하시오.");
		try {
			System.in.read(buffer);
			return new String(buffer); // 예외처리를 얘가 알아서 해버리면, 일 시킨 내가 캐치를 못할 수 있음 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
		
	}

}
