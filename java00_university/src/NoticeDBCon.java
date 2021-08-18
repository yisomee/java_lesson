import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// ��Ȱ���ؼ� ������ �� Ŭ����
public class NoticeDBCon {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Failed to load JDBC driver!");
			cnfe.printStackTrace();
		}
	}
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
	String username = "c##TEST04";
	String password = "qazwsxedc";
	String sql;
	
	// ������
	public NoticeDBCon() {
	}
	
	// DB ����
	public void connectDB() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	// DB ����
	public void closeDB() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
