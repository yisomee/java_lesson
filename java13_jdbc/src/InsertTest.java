import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(ClassNotFoundException c) {
			System.out.println("����̺�ε�����");
		}
	}
	Connection conn;
	PreparedStatement pstmt;
	
	public InsertTest() {
		//�����ȣ, �����, �޿��� �Է¹޾� ���ڵ��߰�
		//�Ի����� ���糯¥�� �����Ѵ�.
		
		//������ BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("�����ȣ=");
			int empno = Integer.parseInt(br.readLine());
			System.out.print("�����=");
			String ename = br.readLine();
			System.out.print("�޿�=");
			int sal = Integer.parseInt(br.readLine());
			
			
			//DB�� ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
			String sql = "insert into emp(empno, ename, sal, hiredate) values(?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			//? ������
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setInt(3, sal);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("���ڵ尡 �߰� �Ǿ����ϴ�.");
			}else {
				System.out.println("���ڵ� �߰� ����");
			}
			
			
		}catch(IOException ie) {
			System.out.println("�������Է¿����߻�--->"+ie.getMessage());
		}catch(SQLException s) {
			System.out.println("�����ͺ��̽� ���� �����߻� --->"+ s.getMessage());
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
				
			}catch(Exception e) {
				System.out.println("�ݱ⿡��..");
			}
		}
	}

	public static void main(String[] args) {
		new InsertTest();

	}

}
