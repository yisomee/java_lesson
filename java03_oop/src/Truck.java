
// extendsŰ���带 �̿��Ͽ� Ŭ������ ��ӹ޴´�.
//		Ŭ������ 1���� ��ӹ������ִ�.
public class Truck extends Car{
	int speed = 100;
	public Truck() {
		System.out.println("Truck()������ �޼ҵ� ����");
		System.out.println("Truck.speed->"+speed);
		super.speedUp();
	}
	public Truck(String carName) {
		super(carName);
		//����Ŭ���� �����ڸ޼ҵ� ȣ��
		//�ݵ�� ù��° ���๮�̾�� �Ѵ�.
		
		//����Ŭ������ �����ڸ޼ҵ� ȣ��
		System.out.println("Truck(String)������ ����~~~");
	}
	//overriding : ����Ŭ������ �޼ҵ带 ����Ŭ�������� ������
	//				��ȯ��, �޼ҵ��, �Ű������� ���� �޼ҵ带 �������ϴ� ���̴�.
	public void speedUp() {
		speed += 10;
		if(speed>=SPEED_MAX) {
			speed=SPEED_MAX;
		}
		System.out.println("truck.speed="+speed);
	}
	public static void main(String a[]) {
		//��Ӱ��迡�� ��ü������ ����Ŭ������ �����ڰ� ���� ������ �ǰ�,
		//����Ŭ������ �����ڰ� ����ȴ�.
		Truck t = new Truck();
		System.out.println("t.speed="+ t.speed);
		//����Ŭ������ �޼ҵ� ȣ��
		t.speedUp();
		t.speedUp();
		t.speedDown();
		
		//����Ŭ������ �����ڸ� ���������� ȣ���ϱ�
		Truck tt = new Truck("�ҳ�Ÿ");
		System.out.println("tt.carName="+ tt.carName);
	}
}
