import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
		// Map interface�� ��ӹ��� Ŭ������ key, value�� ����.
		//1. HashMap�� key�� value�����͸� �����Ѵ�.
		//2. TreeMap�� key�� value�� �����͸� �����ϰ�, key�������� ���ĵȴ�.
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "ȫ�浿");
		hm.put(100,"�������");
		hm.put(50,"�̼���");
		hm.put(25, "�念��");
		hm.put(33, "���·�");
		
		String name = hm.get(100); // int--> Integer
		System.out.println("100->"+ name);
		
		//HashMap���� key����� ���Ͽ� Set�� ����ش�.
		Set<Integer> keyList = hm.keySet();
		
		Iterator<Integer> ii = keyList.iterator();
		while(ii.hasNext()) {//��ü�� ������ true, ������ false
			int k = ii.next();
			System.out.println("key="+ k+", value="+ hm.get(k));
		}
		System.out.println("==========================================");

		
		HashMap<String , MemberVO> hm2 = new HashMap<String , MemberVO>();
		hm2.put("ȫ�浿", new MemberVO("ȫ�浿","��ȹ��","2020-10-10", 5000));
		hm2.put("�̼���", new MemberVO("�̼���","�Ѱ���","2020-01-01", 6000));
		hm2.put("�念��", new MemberVO("�念��","�ѹ���","2020-07-08", 3000));
		hm2.put("�������", new MemberVO("�������","�λ��","2020-02-01", 7000));
		hm2.put("���·�", new MemberVO("���·�","��ȹ��","2020-03-05", 6000));
		
		System.out.println( "======key�� �̿��� ���� ������ ======");
		// key���
		Set<String>memberkey= hm2.keySet();
		Iterator<String> iii = memberkey.iterator();
		while(iii.hasNext()) {
			String key = iii.next();
			MemberVO value = hm2.get(key);
			System.out.println(value.toString());
			//System.out.print(value.getName());
			//System.out.print(", "+value.getDepart());
			//System.out.print(", "+value.getHire());
			//System.out.println(", "+value.getSal());
			
		}
		System.out.println("=====value�� �̿��Ͽ� ���������� =====");
		
		Collection<MemberVO>values = hm2.values();
		Iterator<MemberVO> memberValue =values.iterator();
		while(memberValue.hasNext()) {
			MemberVO vo = memberValue.next();
			System.out.println(vo.toString());
		}
	}
	public static void main(String[] args) {
		new HashMapTest();

	}
}












