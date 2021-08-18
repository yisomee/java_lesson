import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		try {
		//1. JVM �� jdbc����̺� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc ����̺� �ε� ���� -->" + cnfe.getMessage());
		}
			
		try {
			//2. DB����						����ip,localhost port ���������ͺ��̽�����
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
														//dbserver, ����, ���
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			//3. �������� �����. "���ڿ�"
			String sql = "select empno, ename, job, to_char(hiredate,'YYYY-MM-DD')hiredate, sal, comm, deptno"
						+ " from emp where sal>=? or job=? order by ename";
			
			//4. �������� �̿��Ͽ� preparedStatement ��ü����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//?�� ����
			pstmt.setInt(1, 3000);
			pstmt.setString(2, "������");
			
			
			//5.�����ϱ�
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//������ ���ڵ带 ó���Ѵ�.
				int empno = rs.getInt(1);//rs.getInt("empno");
				String ename = rs.getString(2);//rs.getString("ename");
				String job = rs.getString("job");//3
				String hiredate = rs.getString(4);
				int sal = rs.getInt(5);
				double comm = rs.getDouble(6); 
				int deptno=rs.getInt(7);
				
				System.out.println(empno +", "+ename+", "+job+", "+hiredate+", "+sal+", "+comm+", "+deptno);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(SQLException se) {
			System.out.println("DB���� ���� �߻�--->"+ se.getMessage());
		}
	}
	public static void main(String[] args) {
		new SelectTest();
	}
}
