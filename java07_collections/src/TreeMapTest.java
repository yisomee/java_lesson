
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		TreeMap<String, MemberVO> tm = new TreeMap<String, MemberVO>();
		
		//TreeMap�� key, value �� ������.
		// key�� �������� �����Ѵ�. key= ȫ�浿,�̼���,��....
		tm.put("ȫ�浿", new MemberVO("ȫ�浿","��ȹ��","2020-10-10", 5000));
		tm.put("�̼���", new MemberVO("�̼���","�Ѱ���","2020-01-01", 6000));
		tm.put("�念��", new MemberVO("�念��","�ѹ���","2020-07-08", 3000));
		tm.put("�������", new MemberVO("�������","�λ��","2020-02-01", 7000));
		tm.put("���·�", new MemberVO("���·�","��ȹ��","2020-03-05", 6000));
		tm.put("���", new MemberVO("���","������","2021-02-10", 5000));
		
		System.out.println("======key�� �̿��Ͽ� ��ü������========");
		Set<String>keyList=tm.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			MemberVO vo = tm.get(ii.next());
			System.out.println(vo.toString());
		}
		System.out.println("===value�� �̿��� ��ü ������====");
		Collection<MemberVO> value =tm.values();
		Iterator<MemberVO> iii = value.iterator();
		while(iii.hasNext()) {
			MemberVO vo = iii.next();
			System.out.println(vo.toString());
		}
	}

	public static void main(String[] args) {
		new TreeMapTest();
	}

}
