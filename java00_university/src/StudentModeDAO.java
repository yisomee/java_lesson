import java.util.ArrayList;
import java.util.List;

public class StudentModeDAO extends DBConnection{

	int id =Integer.parseInt(AllStateSession.login_id); //�л���ȣ	

	public StudentModeDAO() {
		
	}
	
	public List<StudentModeVO2> allRecord3(){
		List<StudentModeVO2> list = new ArrayList<StudentModeVO2>();
		try {
			
			dbConn();

			String sql = " SELECT C.CLASS_CODE ,P.PROF_NAME,C.CLASS_DIV ,C.CLASS_NAME  ,c.CLASS_GRADE "
				     +",C.CLASS_TIME , C.CLASS_ROOM , C.TOT_MEM , C.REG_MEM , to_char(C.CLASS_DATE,'YY-MM-DD') "
				     +"from CLASS C , PROFESSOR P "
				     +"where P.PROF_CODE = C.PROF_CODE";
			
			
			pstmt = con.prepareStatement(sql);
				
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentModeVO2 vo = new StudentModeVO2();
				vo.setClass_code(rs.getInt(1));
				vo.setProf_name(rs.getString(2));
				vo.setClass_div(rs.getString(3));
				vo.setClass_name(rs.getString(4));
				vo.setClass_grade(rs.getString(5));
				vo.setClass_time(rs.getString(6));
				vo.setClass_room(rs.getString(7));
				vo.setTot_mem(rs.getInt(8));
				vo.setReg_mem(rs.getInt(9));
				vo.setClass_date(rs.getString(10));
							
				list.add(vo);
			}
				
		}catch(Exception e){
			System.out.println("classDAO allRecord ���� �߻�....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	
	//������û �޼ҵ�
	public int insertApplyClass(StudentModeVO3 vo) {
		System.out.println(id);
	
		int cnt=0;
		try {
			dbConn(); //��񿬰� 
			//���Ǽ��� - id�ߺ�x(pk),�����ο��ʰ���
			String sql = "insert into score(Class_Code,Stu_Code,class_time) values(?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,vo.getClass_code());
			pstmt.setInt(2,id);			
			
			cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
			
		}catch(Exception e) {
			System.out.println("�л����DAO ������û���� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
	}
	
	//������û�� ���������� ��û�ο� �����ϴ� �޼ҵ�
	public int updateRecord2(ClassVO vo) {
		int cnt=0;
		try {
			dbConn(); //��񿬰�
			String sql = "update class set reg_mem=reg_mem+1 where Class_code=?";
		
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1,vo.getClass_code());
			
			
			cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
			
		}catch(Exception e) {
			System.out.println("�л����DAO ������û�ο����� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		
		return cnt;
	}
	
	//������û�����ҷ����� �޼ҵ�
	public List<StudentModeVO2> selectClassRecord() {
		List<StudentModeVO2> list   = new ArrayList<StudentModeVO2>();
		
		try {
			dbConn();
			String sql = " SELECT C.CLASS_CODE ,P.PROF_NAME ,C.CLASS_NAME ,C.CLASS_DIV ,c.CLASS_GRADE "
				     +",C.CLASS_TIME , C.CLASS_ROOM , C.TOT_MEM , C.REG_MEM , S.CLASS_TIME "
				     +"from STUDENT ST,SCORE S ,CLASS C , PROFESSOR P "
				     +"where S.STU_CODE=? and S.STU_CODE = ST.STU_CODE AND S.CLASS_CODE= C.CLASS_CODE AND P.PROF_CODE = C.PROF_CODE";
			System.out.println("sql"+sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);	
			
			rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
				
				
			while(rs.next()) {
				StudentModeVO2 vo = new StudentModeVO2();
				vo.setClass_code(rs.getInt(1));
				vo.setProf_name(rs.getString(2));
				vo.setClass_div(rs.getString(3));
				vo.setClass_name(rs.getString(4));
				vo.setClass_grade(rs.getString(5));
				vo.setClass_time(rs.getString(6));
				vo.setClass_room(rs.getString(7));
				vo.setTot_mem(rs.getInt(8));
				vo.setReg_mem(rs.getInt(9));
				vo.setClass_date(rs.getString(10));
				
				list.add(vo);
			}
				
		}catch(Exception e) {
			System.out.println("StudentModeDAO������û�������� �߻�.......");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return list;

	}
	
	//�л��� ������û �Ѱ� ���� ����Ʈ 
	   public List<StudentModeVO2> allRecord2() {
	      
	      List<StudentModeVO2> list   = new ArrayList<StudentModeVO2>();
	      try {
	         //1.db����
	         dbConn();
	               
	         // �ڡڡڡڡ� STU_CODE ID�� �ٲ�ߵ�! �ڡڡڡڡ�
	         //2. preparestatement ����
	         sql = "SELECT C.CLASS_CODE, P.PROF_NAME, C.CLASS_NAME, C.CLASS_DIV, C.CLASS_GRADE, C.CLASS_TIME, "
	               + "C.CLASS_ROOM, C.TOT_MEM, C.REG_MEM, S.CLASS_TIME from STUDENT ST, SCORE S, CLASS C, PROFESSOR P "
	               + "where S.STU_CODE=1000060 and S.STU_CODE = ST.STU_CODE AND S.CLASS_CODE= C.CLASS_CODE AND P.PROF_CODE = C.PROF_CODE";
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            StudentModeVO2 vo = new StudentModeVO2();
	            vo.setClass_code(rs.getInt(1));
	            vo.setProf_name(rs.getString(2));     
	            vo.setClass_name(rs.getString(3));   
	            vo.setClass_div(rs.getString(4));   
	            vo.setClass_grade(rs.getString(5));
	            vo.setClass_time(rs.getString(6));
	            vo.setClass_room(rs.getString(7));
	            vo.setTot_mem(rs.getInt(8));
	            vo.setReg_mem(rs.getInt(9));
	            vo.setClass_date(rs.getString(10));
	            
	            list.add(vo);
	         }
	      }catch(Exception e) {
	         System.out.println("������û ����");
	         e.printStackTrace();
	      }finally{
	         dbClose();
	      }
	      return list;
	   }
	   

	   //�л��� ����Ȯ�� �ϴ� ����Ʈ
	   public List<StudentModeVO> allRecord() {
	      List<StudentModeVO> list   = new ArrayList<StudentModeVO>();
	      try {
	         //1.db����
	         dbConn();
	               
	         //2. preparestatement ����
	         sql = "select c.class_code, c.class_name, nvl(s.mid_score, 0), nvl(s.fin_score, 0), nvl(s.tot_score, 0) "
	               + "from score s join class c on c.class_code = s.class_code";
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            StudentModeVO vo = new StudentModeVO();
	            // class code > name
	            vo.setClass_code(rs.getInt(1));
	            vo.setClass_name(rs.getString(2));
	            vo.setMid_score(rs.getString(3));
	            System.out.println(vo.getMid_score());
	            vo.setFin_score(rs.getString(4));
	            System.out.println(Integer.parseInt(vo.getMid_score()));
	            vo.setTot_score(String.valueOf((Integer.parseInt(vo.getMid_score()) + Integer.parseInt(vo.getFin_score()))/2));

	            int totalScore = Integer.parseInt(vo.getTot_score());
	            String grade = "";
	            if(totalScore >= 95) {
	               grade = "A+";
	            } else if(totalScore >= 90) {
	               grade = "A";
	            } else if(totalScore >= 80) {
	               grade = "B+";
	            } else if(totalScore >= 70) {
	               grade = "B";
	            } else if(totalScore >= 65) {
	               grade = "C+";
	            } else if(totalScore >= 60) {
	               grade = "C";
	            } else {
	               grade = "F";
	            }
	            vo.setGrade(grade);
	            
	            list.add(vo);
	         }
	      }catch(Exception e) {
	         System.out.println("SCORE ����");
	         e.printStackTrace();
	      }finally{
	         dbClose();
	      }
	      return list;
	   } 
	   
	   //�������
	      public int deleteRecord(int willBeRemoved){
	         int code = willBeRemoved;
	         int cnt = 0;
	         try {
	            dbConn();
	            String sql = "delete from score where class_code=? and stu_code = ? ";
	            pstmt = con.prepareStatement(sql);
	            //pstmt.setInt(1, code);
	            pstmt.setInt(1, code);
	            pstmt.setInt(2, id);
	            cnt = pstmt.executeUpdate();
	            return cnt;
	         }catch(Exception e) {
	            System.out.println("������� ����");
	            e.printStackTrace();
	         }finally {
	            dbClose();
	         }
	         return 0;
	      }
	      
	      //������û�� ���������� ��û�ο� �����ϴ� �޼ҵ�
	         public int updateRecord3(ClassVO vo) {
	        	 
	            int cnt=0;
	            try {
	               dbConn(); //��񿬰�
	               String sql = "update class set reg_mem = reg_mem-1 where Class_code=?";

	               pstmt = con.prepareStatement(sql);
	               pstmt.setInt(1,vo.getClass_code());

	               cnt= pstmt.executeUpdate(); //��� ���ڵ尡 �߰��Ǿ�����.....
	               
	            }catch(Exception e) {
	               System.out.println("�л����DAO ������û�ο����� �߻�...");
	               e.printStackTrace();
	            }finally {
	               dbClose();
	            }

	            return cnt;
	         }
	      
	      //������û��ȸ
	      public List<StudentModeVO2> searchRecord(String search, String fieldName) {
	         List<StudentModeVO2> list = new ArrayList<StudentModeVO2>();
	         try {   
	            dbConn();
//	            
	            String sql = "SELECT C.CLASS_CODE,P.PROF_NAME,C.CLASS_NAME,C.CLASS_DIV,c.CLASS_GRADE,C.CLASS_TIME,C.CLASS_ROOM, C.TOT_MEM , "
	                  + "C.REG_MEM , S.CLASS_TIME from STUDENT ST,SCORE S ,CLASS C , PROFESSOR P where S.STU_CODE=1000060 and S.STU_CODE = ST.STU_CODE "
	                  + "AND S.CLASS_CODE= C.CLASS_CODE AND P.PROF_CODE = C.PROF_CODE and "+fieldName+" like ? ";
	         
	            System.out.println(search);
	            System.out.println(fieldName);
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, "%"+search+"%"); //"%��%
	            
	            rs = pstmt.executeQuery();
	            while(rs.next()) {
	               StudentModeVO2 vo  = new StudentModeVO2();
	               vo.setClass_code(rs.getInt(1));
	               vo.setProf_name(rs.getString(2));     
	               vo.setClass_name(rs.getString(3));   
	               vo.setClass_div(rs.getString(4));   
	               vo.setClass_grade(rs.getString(5));
	               vo.setClass_time(rs.getString(6));
	               vo.setClass_room(rs.getString(7));
	               vo.setTot_mem(rs.getInt(8));
	               vo.setReg_mem(rs.getInt(9));
	               vo.setClass_date(rs.getString(10));
	               list.add(vo);
	            }
	         }catch(Exception e) {
	            System.out.println("������û��ȸ ����");
	            e.printStackTrace();
	            
	         }finally {
	            dbClose();
	         }
	         return list;
	      }
	      
	      //�л��� �������������Ҷ� ���� �����ϱ�
	      public StudentVO setStudentProfile() {
	         StudentVO vo = new StudentVO();
	         try {
	            dbConn();
	            String sql = "select s.stu_code, m.major_name, s.stu_pw, s.stu_name, s.stu_grade, s.stu_email, "
	                  + "s.stu_tel,s.stu_add, s.stu_state, to_char(s.stu_date, 'YYYY-MM-DD'),s.stu_birth from student s "
	                  + "join major m on s.major_code=m.major_code where s.stu_code=" + id;
	            
	            
	            pstmt = con.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            while(rs.next()) {
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
	            }
	         }catch(Exception e) {
	            System.out.println("������������ �������� ����");
	            e.printStackTrace();
	         }finally {
	            dbClose();
	         }
	         return vo;
	      }
	      //�л��� ������������
	      public int updateRecord(StudentVO vo) {
	         int cnt = 0;
	         try {
	            dbConn();
	            String sql = "update student set stu_pw=?, stu_email=?, stu_tel=?, stu_add=? where stu_code=" + id;
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, vo.getStu_pw());
	            pstmt.setString(2, vo.getStu_email());
	            pstmt.setString(3, vo.getStu_tel());
	            pstmt.setString(4, vo.getStu_add());

	            cnt = pstmt.executeUpdate();
	         }catch(Exception e) {
	            System.out.println("��������");
	            e.printStackTrace();
	         }finally {
	            dbClose();
	         }
	         return cnt;
	      }
	      

	

}
