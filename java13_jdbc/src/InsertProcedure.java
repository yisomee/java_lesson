import java.sql.CallableStatement;
import java.sql.Types;

public class InsertProcedure extends DBConnection {

	public InsertProcedure() {
		try {
			//1. db연결
			dbConn();
			//					username, tel, return
			sql = "{call mem_insert(?,?,?)}";//프로시저를 호출하는 명령어
			CallableStatement cstmt = con.prepareCall(sql);
			
			cstmt.setString(1, "윤봉길");
			cstmt.setString(2, "010-4344-1112");
			cstmt.registerOutParameter(3, Types.INTEGER);//값을 받는 건데 ?여서 세팅은 해줘야할때
			
			cstmt.executeUpdate();
			
			if(cstmt.getInt(3)==1) {
				System.out.println("레코드가 추가되었습니다.");
			}else {
				System.out.println("추가실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new InsertProcedure();

	}

}

/*
 
 create or replace procedure mem_insert(p_username in member.username%type, p_tel in member.tel%type, p_result out number)
--p_result에 담긴값은 자바에서 받아낼 수 있다
is

begin
    -- 1:추가, 0:추가실패
    p_result :=1;
    insert into member(mem_no, username, tel, write_date)
    values(memSq.nextVal, p_username, p_tel, sysdate);
    
    --레코드 추가시 에러가 발생하면...
    exception
        when others then
            p_result:= 0;
end;
 
 
 */