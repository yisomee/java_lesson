
public class ClassMain {

	public static void main(String[] args) {
		ClassTest ct = new ClassTest();
		//System.out.println("b=" + ct.b);
		
	 ClassTest ct2 = new ClassTest(5678);
	 
	 //�޼ҵ� ȣ�� : ��ü��.�޼ҵ��()
	 ct.sum();
	 ct.total(100, 200);
	 
	 ct2.total(1000,2000);
	 
	}
	//����Ŭ���� 

}
