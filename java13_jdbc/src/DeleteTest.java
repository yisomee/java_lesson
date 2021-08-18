import java.util.Scanner;

public class DeleteTest extends DBConnection{

	public DeleteTest() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("������ �����=");
			String name = scan.nextLine();
			
			//DB����
			dbConn();
	
			sql = "delete from emp where ename=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"���� ���ڵ尡 �����Ǿ����ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	public static void main(String[] args) {
		new DeleteTest(); 
	}
}
