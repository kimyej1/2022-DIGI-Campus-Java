import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B44Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Byte : InputStream, OutputStream

		FileInputStream in = null; 	// stream�̹Ƿ� ��׵� byte
		FileOutputStream out = null;
		
		try {
			int c;
			out = new FileOutputStream("data.txt", false); // boolean : append�Ұų�? t(�� �ڿ� �ٿ�) /f(�Ź� ���� ��) 
			
			for(int i=1; i<=10; i++)
			{
				out.write(i);
			}
			out.flush(); // �޸� �� ��ﶧ������ �۾��� ���̻� �������� ���� 
			
			in = new FileInputStream("data.txt"); // data.txt�� ����� 
			
			while((c = in.read()) != -1) // while ���鼭 �����Ͱ� �ִ� ���� ������ (�����Ͱ� �󸶳� �ִ��� �𸣴ϱ�) 
			{
				System.out.print(c + " ");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally
		{
			if(in != null)
			{
				in.close(); // ��������, �� �ݾ��ֱ� 
							// ������ �̰͵� Try-catch �ȿ� �־��, �ȿ����ִ� ��쿡�� ������ �ȳ��µ�,
							// �׷� �ڵ尡 �ʹ� ������������ �� ���� throws IOException ���� ó��
			}
			if(out != null)
			{
				out.close();
			}

		}
/*
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try { // �����ϸ� eclipse-workspace > B44Byte �ؿ� data.txt ���ܳ����� 
			int c;
			out = new DataOutputStream(					// 3. �װ� �� ��Ƽ� �ѹ��� ���� 
				new BufferedOutputStream(				// 2. buffer �� ��� 
					new FileOutputStream("data.txt")	// 1. file output�� �ٷ� ������ ���� 
				)
			);
			
			for(int i=1; i<10; i++)
			{
				out.writeInt(i);
			}
			out.writeUTF("English �ѱ� ��� !@*#$^&");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
*/

	}
}
