public class MethodTest {
	//�������
	int num =12;
	String name="ȫ�浿";
	String tel;//null
	//������ �޼ҵ�: ������ �ڵ��߰�(JVM)
	//			��Ӱ��谡 �ƴҶ��� �߰����ش�
	//		�Ű������� ���������� �ٸ��ų� ������ ������ �޶�� �Ѵ�.
	MethodTest(){}
	MethodTest(String tel){
		System.out.println("����ó:"+tel);
	
	}
	//MethodTest(String name){	
	//}
	MethodTest(int num){
		
	}
	MethodTest(int num, String name){
		// this: ���簴ü(���� Ŭ����)
		this.num = num;
		this.name= name;
		String tel="12345";
		
		this.tel = "02-1234-1234";
		
	}
	MethodTest(String name, int num){
		//�����ڸ޼ҵ忡�� �ٸ� ������ �޼ҵ� ȣ���ϱ�
		//�����ڸ޼ҵ忡�� �ٸ������ڸ� ȣ���Ҷ��� �޼ҵ� ����
		//����ǥ���� �� ����. this��°� ����Ѵ�.
		//MethodTest(num, name); x
		//this()�̿��Ͽ� �ٸ� ������ �޼ҵ带 ȣ���Ҷ��� �ݵ�� ù��° ���๮�̿��� �Ѵ�.
		//System.out.println("===");
		this(num, name); 
		
	}
	
	
}