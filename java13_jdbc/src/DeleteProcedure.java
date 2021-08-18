import java.sql.CallableStatement;
import java.sql.Types;

public class DeleteProcedure extends DBConnection {

	public DeleteProcedure() {
		try {
			dbConn();
			
			sql= "{call mem_del(?,?)}";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, "ȫ�浿");			
			//������ ������� ���� ����
			cstmt.registerOutParameter(2, Types.INTEGER);
			
			cstmt.executeUpdate();
			if(cstmt.getInt(2)==1) {
				System.out.println("ȸ���� �����Ͽ����ϴ�");
			}else {
				System.out.println("��������...");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteProcedure();

	}

}
