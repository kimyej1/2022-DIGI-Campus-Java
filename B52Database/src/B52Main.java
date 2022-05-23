import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class B52Main {
	/*
	 * mariaDB 2.7.3 jar 파일 다운받아서
	 * [project 우클릭 > properties > Libraries > Module Path > Add external jars] 해서 넣었음 
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
								// 'UTF-8' 부분을 'utf8mb4' 라고 해야할 수도 있음..
		
		// jdbc:mariadb://localhost:3306/mykb?char..
		System.out.println("Start DB : 한글");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*
		 * DB에서는 $data = mysqli_fetch_array(); 하면 $data에 하나씩 배열로 들어왔었음
		 * 여기서는 ResultSet에 들어감 
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
			stmt = conn.createStatement();
			sql = "insert into online (id, name, age, address) values ('kbstar', '국민은행', '33', '서울')";
			int affectedCount = stmt.executeUpdate(sql);	// data에 영향을 주는 것 : executeUpdate()
			
			System.out.println("affectedCount = " + affectedCount);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(conn != null)
			{
				conn.close(); // main에 'throw Exception'을 넣거나, conn.close()를 try-catch안에 넣어야 함 
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
