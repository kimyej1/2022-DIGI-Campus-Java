import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B44Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Byte : InputStream, OutputStream

		FileInputStream in = null; 	// stream이므로 얘네도 byte
		FileOutputStream out = null;
		
		try {
			int c;
			out = new FileOutputStream("data.txt", false); // boolean : append할거냐? t(응 뒤에 붙여) /f(매번 새로 써) 
			
			for(int i=1; i<=10; i++)
			{
				out.write(i);
			}
			out.flush(); // 메모리 다 비울때까지는 작업을 더이상 진행하지 않음 
			
			in = new FileInputStream("data.txt"); // data.txt를 열어봐 
			
			while((c = in.read()) != -1) // while 돌면서 데이터가 있는 족족 가져옴 (데이터가 얼마나 있는지 모르니까) 
			{
				System.out.print(c + " ");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally
		{
			if(in != null)
			{
				in.close(); // 열었으니, 꼭 닫아주기 
							// 원래는 이것도 Try-catch 안에 넣어야, 안열려있는 경우에도 오류가 안나는데,
							// 그럼 코드가 너무 지저분해지니 맨 위에 throws IOException 으로 처리
			}
			if(out != null)
			{
				out.close();
			}

		}
/*
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try { // 실행하면 eclipse-workspace > B44Byte 밑에 data.txt 생겨나있음 
			int c;
			out = new DataOutputStream(					// 3. 그걸 또 모아서 한번에 버려 
				new BufferedOutputStream(				// 2. buffer 에 모아 
					new FileOutputStream("data.txt")	// 1. file output을 바로 버리지 말고 
				)
			);
			
			for(int i=1; i<10; i++)
			{
				out.writeInt(i);
			}
			out.writeUTF("English 한글 漢字 !@*#$^&");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
*/

	}
}
