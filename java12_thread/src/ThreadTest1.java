//1. ������Ŭ���� ���
public class ThreadTest1 extends Thread {
	String msg;
	public ThreadTest1() {}
	public ThreadTest1(String msg) {
		this.msg = msg;
	}
	//������ �����ڵ带 run()�� �������̵� �Ѵ�. 
	public void run() {
		for(int i=1;;i++) {
			System.out.println(msg+"="+i);
		}
	}
	public static void main(String[] args) {
		ThreadTest1 tt1 = new ThreadTest1("ù��°������");
		//3. ����������ϱ� ���ؼ��� start()�޼ҵ�ȣ��
		tt1.start();
		
		ThreadTest1 tt2 = new ThreadTest1("�ι�°������");
		tt2.start();
		
		ThreadTest1 tt3 = new ThreadTest1("����°������");
		tt3.start();

	}

}
