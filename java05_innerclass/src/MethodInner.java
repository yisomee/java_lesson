//�޼ҵ� �ȿ� ����Ŭ���������
public class MethodInner {
	String name="�������";
	public MethodInner() {
		System.out.println("MethodInner");
	}
	public void start() {
		//����Ŭ����
		class MethodInnerTest{
			int num=20;
			String email = "aaaa@nate.com";
			MethodInnerTest(){
				
			}
			MethodInnerTest(int num){
				this.num = num;
			}
			void emailOutput() {
				System.out.println("num="+num);
				System.out.println("email="+email);
				System.out.println("name="+name);
			}
		}
		
		// ����Ŭ���� ��ü�� ����
		MethodInnerTest mt = new MethodInnerTest(500);
		mt.emailOutput();
	}
	public static void main(String[] args) {
		MethodInner mi = new MethodInner();
		mi.start();

	}
}
