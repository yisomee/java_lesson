import java.util.Calendar;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
		
	}
	public Vector start() {
		//vector �÷���
		Vector v = new Vector();
		
		String username = "ȫ�浿";
		Integer num = 25010;
		Calendar cal = Calendar.getInstance();
		MemberVO vo = new MemberVO("�������","��ȹ��","2021-06-10",1000);
		
		//Vector��ü�� �ٸ� ��ü �߰��ϱ�
		v.add(username);
		v.addElement(num);
		v.add(1, cal);
		v.addElement(vo);
	
		return v;
	}
	
	//public static void main(String[] args) {
	//	new VectorTest().start();
	//}
}
/*

List(interface): index�� �����Ѵ�.
		��������� �����Ѵ�.
		

*/
