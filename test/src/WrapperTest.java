
public class WrapperTest {

	public WrapperTest() {
		//WrapperŬ������ �⺻���������� ������ ��ü�� �����Ű�� Ŭ�����̴�.
		//Byte, Short, Integer, Long
		//Float. Double
		//Boolean, 
		//Character
		
		int a = 1234;
		Integer i = Integer.valueOf(a);//new Integer(a);
		
		System.out.println(a);
		System.out.println(i);
		
		Object obj = a; //����ڽ�
		Object obj2 = i;
		System.out.println(obj);
		System.out.println(obj2);
		
		//1.1, 1.1, 1.3, 1.4, 5,6,7,8,9,12, 
		
		int x = i;//�����ڽ�
		System.out.println(x);
		
	}

	public static void main(String[] args) {
		new WrapperTest();

	}

}