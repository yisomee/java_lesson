import java.util.ArrayList;
import java.util.List;

public class CollectionData {

	public CollectionData() {
		
	}
	public List<MemberVO> getMember() {
		//ArrayList���� ��������� ��Ƽ� �����Ѵ�.
		//ArrayList<MemberVO> al = ArrayList<MemberVO>();
		List<MemberVO> al2 = new ArrayList<MemberVO>(); 
		
		al2.add(new MemberVO("AAAA","��ȹ��","2021-05-10",5000));
		al2.add(new MemberVO("BBBB","�ѹ���","2021-01-01",6000));
		al2.add(new MemberVO("CCCC","�λ��","2020-10-10",7000));
		al2.add(new MemberVO("DDDD","�ѹ���","2021-02-02",5000));
		al2.add(new MemberVO("EEEE","�λ��","2021-03-02",6500));
		
		return al2;
	}
}
