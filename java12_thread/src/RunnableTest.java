//1. �������̽����
public class RunnableTest implements Runnable{
	String msg;
	public RunnableTest() {
		
	}
	public RunnableTest(String msg) {
		this.msg=msg;
	}
	//������ ���������� run()�޼ҵ忡 �������̵�
	public void run() {
		int i = 1;
		while(true) {
			System.out.println(msg+"===>"+i++);
		}
	}
	
	public static void main(String[] args) {
		RunnableTest rt1 = new RunnableTest("ù��°������");
		RunnableTest rt2 = new RunnableTest("�ι�°������");
		
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		
		t1.start();
		t2.start();
		

	}

}
