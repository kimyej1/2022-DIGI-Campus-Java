import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class B55Main {
	/*
	 * mariaDB 2.7.3 jar ���� �ٿ�޾Ƽ�
	 * [project ��Ŭ�� > properties > Libraries > Module Path > Add external jars] �ؼ� �־��� 
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		final String driver = "org.mariadb.jdbc.Driver";
		final String dbHost = "localhost";
		final String dbPort = "3306";
		final String dbName = "mykb";
		final String dbPass = "";
		final String dbUser = "root";
		final String dbUrl = "jdbc:mariadb://" + dbHost + ":" + dbPort + "/" + dbName + "?characterEncoding=UTF-8";
								// 'UTF-8' �κ��� 'utf8mb4' ��� �ؾ��� ���� ����..
		
		// jdbc:mariadb://localhost:3306/mykb?char..
		System.out.println("Start DB : �ѱ�");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*
		 * DB������ $data = mysqli_fetch_array(); �ϸ� $data�� �ϳ��� �迭�� ���Ծ���
		 * ���⼭�� ResultSet�� �� 
		 */
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			System.out.println("OK Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			
			if(conn != null)
			{
				System.out.println("OK DB Connect");
			} else
			{
				System.out.println("Fail DB Connect");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Fail Driver Load");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		}
	
		
		Statement stmt;	 	// java.sql 
		String sql;
		try {
			
			String id = "mytestid";
			String name = "���̸��׽�Ʈ";
			int age = 12;
			String address = "�׽�Ʈ�ּ�";
			
			// Prepared Statement : ������ �� �������� �� �ڸ��� �־���! ��� ��û 
			
			stmt = conn.createStatement();
			sql = "insert into online (id, name, age, address) values (?, ?, ?, ?)"; // ������ �̸� �غ� 
			pstmt = conn.prepareStatement(sql);	// �̸� ���� ������ ?�ڸ��� �� �־��� 
			
			pstmt.setString(1, id); // 1��° ? ���� id�� �־� 
			pstmt.setString(2, name);
			pstmt.setString(3, Integer.toString(age)); // age : int -> String
			pstmt.setString(4, address);
			
			pstmt.executeUpdate(); // �̹� prepared �Ǿ��־ parameter�� sql �Ƚ��൵�� 
			
			
			while(rs.next()) // �����Ͱ� �ִ� ����.. 
			{
				// print : idx, id, name, age, address
//				int idx = rs.getInt("idx");
//				String id = rs.getString("id");
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String address = rs.getString("address");
				
//				System.out.println("idx = " + idx + ", id = " + id + ", name = " + name + ", age = " + age + ", address = " + address);
				
				// syso ��� ���� ��� 
				String dbResult = "";
				dbResult = dbResult.format(name + "\t" + id + "\t" + age + "\t" + address + "\t");
				System.out.println(dbResult);
			}
			
//			System.out.println("affectedCount = " + affectedCount);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(conn != null)
			{
				conn.close(); // main�� 'throw Exception'�� �ְų�, conn.close()�� try-catch�ȿ� �־�� �� 
			}
		}
	
		
//		create table online(
//				idx		int(10) 	auto_increment,
//				id		char(20)	unique,
//				name	char(20),
//				age		int(3)		default '0',
//				address	char(30),
//				
//				primary key(idx)
//		);
//		
		
		
	}

}
