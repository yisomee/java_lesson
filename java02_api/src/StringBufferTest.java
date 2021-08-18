
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}
	public void start() {
		StringBuffer sb1 = new StringBuffer();//16byte
		StringBuffer sb2 = new StringBuffer(100);//100byte

		// append(): ���ڿ��߰�
		sb1.append("Buffer append Test..");
		sb1.append(123456);
		
		//insert(): index��ġ ���� ����
		sb1.insert(5,"(��Ʈ������)");
		sb1.insert(15, 23235.21542554);
		//0123456 7
		//Buffe(Ʈ������)r a23235.21542554ppend Test..123456
		sb1.deleteCharAt(6);
		
		sb1.delete(1, 4); //index 1���� 4���� �����
		// 0123 45 67
		//Be(Ʈ������)r a23235.21542554ppend Test..123456
		
		sb1.replace(1,3,"(�ڹ�)");
		//B(�ڹ�)Ʈ������)r a23235.21542554ppend Test..123456
		
		sb1.reverse();
		//654321..tseT dnepp45524512.53232a r)�۹���Ʈ)����(B
		
		
		//Ȯ���� ���� Ȯ���ϱ� 
		System.out.println("sb1.capacity="+sb1.capacity());
		System.out.println("sb2.capacity="+sb2.capacity());
		System.out.println(sb1);
	}
	public static void main(String[] args) {
		new StringBufferTest();
	}

}
