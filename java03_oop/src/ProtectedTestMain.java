import test.ProtectedTest2;

public class ProtectedTestMain extends ProtectedTest2 {

	ProtectedTestMain(){
		//���� ��Ű������ �ٸ� Ŭ������ defaultó�� ��밡��
		
		ProtectedTest pt = new ProtectedTest();
		System.out.println("pt.num="+ pt.num);
		pt.print();
		
		//ProtectedTest2 pt2 = new ProtectedTest2();
		
		//�ٸ� ��Ű���� Ŭ������ ��ü�� ������ �� ����.
		
		
		//Protected���������ڴ� �ٸ� ��Ű���ϰ�� ��ӹ޾� ����Ѵ�. 
		System.out.println("tel="+tel);
		telOutput();
		
		
		
	}
	public static void main(String[] args) {
		new ProtectedTestMain();
		
		ProtectedTest2 ppt = ProtectedTest2.getInstance();
		System.out.println(ppt.getTel());
		
	}
}