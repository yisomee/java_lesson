package test;

public class ProtectedTest2 {
	protected String tel = "010-1234-8959";
	
	protected ProtectedTest2(){
		System.out.println("�ٸ���Ű���� �����ڸ޼ҵ�");
		
	}
	protected void telOutput() {
		System.out.println("��ȭ��ȣ="+ tel);
	}
	
	public String getTel() {
		return tel; //��ü������ �ȵ�. 
	}
	public static ProtectedTest2 getInstance() {// �����ȵǴϱ� static , getInstance �ܵ����� ȣ��
		return new ProtectedTest2();
		//getInstance() - static calendar ���Ἥ ��� ���°�...?
	}
}