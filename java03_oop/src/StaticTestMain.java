import java.util.Calendar;

public class StaticTestMain {

	public StaticTestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		StaticTest ss = new StaticTest();
		StaticTest ss2 = new StaticTest();
		
		ss.setAddr("��������");
		
		String address = ss2.getAddr();
		System.out.println("address="+ address);
		
		// static ��������� ��ü�������� �ʰ�� ����� �� �ִ�. 
		System.out.println("name="+ StaticTest.addr);

		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR));
	}

}