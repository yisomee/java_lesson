
public class TransactionTest extends DBConnection {

	public TransactionTest() {
		try {
			dbConn();
			
			//�ڵ� Commit�����ϱ�
			con.setAutoCommit(false);//true: �ڵ�Ŀ��, false:�ڵ�Ŀ������
			int abank= -5000, bbank=5000;
			
			//���
			sql="insert into a_bank(num,money) values(a_number.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, abank);
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(Math.abs(abank) +"���� ��ݵǾ����ϴ�.");
			}else {
				System.out.println(Math.abs(abank)+"�� ����� �����Ͽ����ϴ�.");
			}
			if(cnt>0) throw new Exception();
			
			//�Ա�
			sql = "insert into b_bank(num, money) values(b_number.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbank);
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println(Math.abs(bbank)+"���� �ԱݵǾ����ϴ�.");
			}else {
				System.out.println(Math.abs(bbank)+"�� �Ա��� �����Ͽ����ϴ�.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			}catch(Exception ee) {}
		}finally {
			dbClose();
		}
		
	}
	public static void main(String[] args) {
		new TransactionTest();
	}
}
