
public class AbstractMain extends AbstractTest{

	public AbstractMain() {
	}

	//��ӹ��� �߻�Ŭ�������� ��� �߻�޼ҵ带 �������̵��Ѵ�. 
	public void print() {
		System.out.println("num="+num+", name="+name);
		
	}
	
	public void setData(int num, String name) {
		this.num = num;// super.num = num; 
		this.name = name;// super.name = name;
	}
	public void start() {
		numOutput();
		setData(5000,"�̼���");
		print();
	}
	
	
	public static void main(String[] args) {
		AbstractMain am = new AbstractMain();
		am.start();
	}

}