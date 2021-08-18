import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DBConnection{

	public StudentDAO() {
		
	}
	
	//�л���ü��ȸ
	public List<StudentVO2> allRecord(){
		List<StudentVO2> list = new ArrayList<StudentVO2>();
		try {
		
			dbConn();

//			String sql = "select Stu_Code, Major_Code,stu_pw, stu_name, stu_grade , "
//		               + "stu_email, stu_tel, stu_add,stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
//		               + " from student";
		
			String sql = " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
				     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
				     +"from student s , major m "
				     +"where s.major_code = m.major_code";
			
			
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO2 vo = new StudentVO2();
				vo.setStu_Code(rs.getInt(1));
				vo.setMajor_name(rs.getString(2));
				vo.setStu_pw(rs.getString(3));
				vo.setStu_name(rs.getString(4));
				vo.setStu_grade(rs.getString(5));
				vo.setStu_email(rs.getString(6));
				vo.setStu_tel(rs.getString(7));
				vo.setStu_add(rs.getString(8));
				vo.setStu_state(rs.getString(9));
				vo.setStu_date(rs.getString(10));
				vo.setStu_birth(rs.getString(11));				
				list.add(vo);
			}
			
		}catch(Exception e){
			System.out.println("�л���ü��ȸ ���� �߻�....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}

	//�л��˻�
//	public List<StudentVO2> searchRecord(String search,String fieldName) {
//		
//		List<StudentVO2> list = new ArrayList<StudentVO2>();
//		try {
//			dbConn();
//			
//			
//			
////				if(fieldName=="major_name") {
////					
////					String sql =  " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
////						     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
////						     +"from student s , major m "
////						     +"where s.major_code = m.major_code and "+fieldName+" like ? ";
////					
////							
////							
////							System.out.println("sql"+sql);
////							pstmt = con.prepareStatement(sql);
////							
////							
////							
////							pstmt.setString(1,"%"+search+"%"); // %��% //***����****
////							rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
////							
////							
////							while(rs.next()) {
////								StudentVO2 vo = new StudentVO2();
////								vo.setStu_Code(rs.getInt(1));
////								vo.setMajor_name(rs.getString(2));
////								vo.setStu_pw(rs.getString(3));
////								vo.setStu_name(rs.getString(4));
////								vo.setStu_grade(rs.getString(5));
////								vo.setStu_email(rs.getString(6));
////								vo.setStu_tel(rs.getString(7)); 
////								vo.setStu_add(rs.getString(8));
////								vo.setStu_state(rs.getString(9));
////								vo.setStu_date(rs.getString(10));
////								vo.setStu_birth(rs.getString(11));				
////								list.add(vo);
////							}
////					
////				}else {
//				
//					String sql =  "select Stu_Code, Major_Code, stu_pw, stu_name, stu_grade , "
//				               + "stu_email, stu_tel, stu_add, stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
//							+ " from Student where "+fieldName+" like ? ";
//
//					System.out.println("sql"+sql);
//					pstmt = con.prepareStatement(sql);
//					
//					
//					
//					pstmt.setString(1,"%"+search+"%"); // %��% //***����****
//					rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
//					
//					
//					while(rs.next()) {
//						StudentVO2 vo = new StudentVO2();
//						vo.setStu_Code(rs.getInt(1));
//						vo.setMajor_name(rs.getString(2));
//						vo.setStu_pw(rs.getString(3));
//						vo.setStu_name(rs.getString(4));
//						vo.setStu_grade(rs.getString(5));
//						vo.setStu_email(rs.getString(6));
//						vo.setStu_tel(rs.getString(7)); 
//						vo.setStu_add(rs.getString(8));
//						vo.setStu_state(rs.getString(9));
//						vo.setStu_date(rs.getString(10));
//						vo.setStu_birth(rs.getString(11));				
//						list.add(vo);
//					}
//				
//					
//					
//				//}
//				
//			}catch(Exception e) {
//				System.out.println("�л��˻����� �߻�.......");
//				e.printStackTrace();
//			}finally {
//				dbClose();
//			}
//			return list;
//		
//	
//	}	
	//�л��˻�
	public List<StudentVO2> searchRecord(String search,String fieldName) {
		
		List<StudentVO2> list = new ArrayList<StudentVO2>();
		
	//	if(fieldName=="major_name") {		
			try {
				dbConn();		
//				if(fieldName=="s.Stu_Code") {	
//					String sql =  " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
//						     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
//						     +"from student s , major m "
//						     +"where s.major_code = m.major_code and "+fieldName+" like ? ";						
//							System.out.println("sql"+sql);
//							pstmt = con.prepareStatement(sql);						
//							
//						
//							pstmt.setString(1,"%"+search+"%"); // %��% //***����****
//							rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������							
//							while(rs.next()) {
//								StudentVO2 vo = new StudentVO2();
//								vo.setStu_Code(rs.getInt(1));
//								vo.setMajor_name(rs.getString(2));
//								vo.setStu_pw(rs.getString(3));
//								vo.setStu_name(rs.getString(4));
//								vo.setStu_grade(rs.getString(5));
//								vo.setStu_email(rs.getString(6));
//								vo.setStu_tel(rs.getString(7)); 
//								vo.setStu_add(rs.getString(8));
//								vo.setStu_state(rs.getString(9));
//								vo.setStu_date(rs.getString(10));
//								vo.setStu_birth(rs.getString(11));				
//								list.add(vo);
//							}
//					
//				}else {
//				
					
//					String sql =  "select Stu_Code, Major_Code, stu_pw, stu_name, stu_grade , "
//				               + "stu_email, stu_tel, stu_add, stu_state, to_char(stu_date,'YY-MM-DD'),  stu_birth" 
//							+ " from Student where "+fieldName+" like ? ";
					String sql =  " SELECT s.Stu_Code ,m.major_name,s.stu_pw ,s.stu_name  ,s.stu_grade "
						     +",s.stu_email, s.stu_tel ,s.stu_add ,s.stu_state ,to_char(s.stu_date,'YY-MM-DD'),s.stu_birth  "
						     +"from student s , major m "
						     +"where s.major_code = m.major_code and "+fieldName+" like ? ";					
					
					System.out.println("sql"+sql);
					//------------------------------------------���⼭���;ȵ�
					pstmt = con.prepareStatement(sql);
					

					pstmt.setString(1,"%"+search+"%"); // %��% //***����****
					rs = pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
					
					while(rs.next()) {
						
						System.out.println("while�������� ����");
						StudentVO2 vo = new StudentVO2();
						vo.setStu_Code(rs.getInt(1));
						vo.setMajor_name(rs.getString(2));
						vo.setStu_pw(rs.getString(3));
						vo.setStu_name(rs.getString(4));
						vo.setStu_grade(rs.getString(5));
						vo.setStu_email(rs.getString(6));
						vo.setStu_tel(rs.getString(7)); 
						vo.setStu_add(rs.getString(8));
						vo.setStu_state(rs.getString(9));
						vo.setStu_date(rs.getString(10));
						vo.setStu_birth(rs.getString(11));				
						list.add(vo);
						System.out.println(vo.getStu_name());
					}
				
//					
//					
			//	}
				
			}catch(Exception e) {
				System.out.println("�л��˻����� �߻�.......");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			
		//}
		return list;
		}
	
	
	
	//�л�����	
	public int updateRecord(StudentVO3 vo) {
		//������ �����ϰ� ������ ��ɹ�
//		System.out.println(vo.allprint());
			//������ �̴��� �ȉ������ ������ �����ش� 
			//�������� �����ϸ� �����ϴ¸�ɾ �������ִ� �����Ͱ� �ִ� -> pstmt.executeUpdate()
		int cnt =0;
		try {
			dbConn();
			String sql = "update student set  Major_Code=?,stu_pw=?,stu_name=?,stu_grade=?,stu_email=?,stu_tel=?,stu_add=?,stu_state=?,stu_BIRTH=? where stu_code=?";
			//String sql = "update student set  major_name=?,stu_pw=?,stu_name=?,stu_grade=?,stu_email=?,stu_tel=?,stu_add=?,stu_state=?,stu_date = sysdate,stu_BIRTH=? where stu_code=?";

			pstmt = con.prepareStatement(sql);
				
			//pstmt.setInt(1, vo.getStu_Code());
			pstmt.setInt(1, vo.getMajor_Code());
			pstmt.setString(2, vo.getStu_pw());
			pstmt.setString(3, vo.getStu_name());
			pstmt.setString(4,vo.getStu_grade());
			pstmt.setString(5,vo. getStu_email());
			pstmt.setString(6,vo.getStu_tel()); 
			pstmt.setString(7,vo.getStu_add());
			pstmt.setString(8,vo.getStu_state());
			pstmt.setString(9,vo.getStu_birth());		
			pstmt.setInt(10,vo.getStu_Code());	 //*****
	
			
			
			//(LoggableStatement)pstmt
			cnt = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("DAO �л����� ���� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
			return cnt;
	}
	
	//���������� ������ȣ��������
		public int searchMajorCode(String majorname) {
			
			int result=0;
			try {
				dbConn();
				String sql = "select Major_Code"
						+ " from major where major_name like ? ";
				System.out.println("sql"+sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,majorname); // %��%
				rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
				
				while(rs.next())  {
					result = rs.getInt(1);
				System.out.println(result);
				}
				
			}catch(Exception e) {
				System.out.println("DAO ���������� ������ȣ�������� ���� �߻�.......");
				e.printStackTrace();
			}finally {
				
			}
			return result;
		}
	
	
	
	
	//�л��߰�
	public int insertRecord(StudentVO3 vo){
		//�߰�����Ŀ� �����ͺ��̽����� �߰��Ǿ���ϰ� �������̺�ȸ����Ͽ��� �߰��� ȸ���� ��µǾ���Ѵ�..
		int cnt=0;
		try {
			dbConn(); //��񿬰�
			String sql = "insert into student values(ST_CODE.nextval, ?,?,?,?,?, ?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getMajor_Code());
			pstmt.setString(2, vo.getStu_birth());
			pstmt.setString(3, vo.getStu_name());
			pstmt.setString(4,vo.getStu_grade());
			pstmt.setString(5,vo. getStu_email());
			pstmt.setString(6,vo.getStu_tel()); //int
			pstmt.setString(7,vo.getStu_add());
			pstmt.setString(8,vo.getStu_state());
			//pstmt.setInt(8,vo.getStu_date());
			pstmt.setString(9,vo.getStu_birth());		
		
			cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
			
		}catch(Exception e) {
			System.out.println("�л��߰����� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//�л�����
	public int deleteRecord(Object willBeRomoved) { //�����������Ұ��� �Ű������޾Ƽ� ó��-db���� ������ ��������� ���������
		int code = (Integer)willBeRomoved;
		int cnt=0;		
		try {
			dbConn();
			String sql = "delete from student where Stu_code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,code);
					
			cnt = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("StudentDAO ���ǻ��� ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;			
	}

	
	
	public static void main(String[] args) {
		new StudentDAO();
	}

}
