import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		CollectionData data = new CollectionData();
		List<MemberVO> lst = data.getMember();
		
		// index 2�� �߰�. �������� �ϳ��� �ڷ� �и�
		
		MemberVO vo2 = new MemberVO("ZZZ","��ȹ�Ѱ���","2020-01-02",5000);
		lst.add(2, vo2);
		
		//lst.remove(1);// index ����
		//lst.remove(vo2);// ��ü������ ����
		
		for(int i =0;i<lst.size(); i++) {
			MemberVO vo = lst.get(i);
			vo.memberPrint();
		}
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
