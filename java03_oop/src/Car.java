
public class Car{
	int speed=0;
	final int SPEED_MAX = 180;
	final int SPEED_MIN = 0;
	String carName ="�׷���";
	
	public Car() {
		System.out.println("Car()������ �޼ҵ� ����");
	}
	public Car(String carName) {
		this.carName = carName;
		System.out.println("Car(String)������ �޼ҵ� ����");
	}
	public void speedUp() {
		speed++;
		if(speed>=SPEED_MAX) speed=SPEED_MAX;
		System.out.println("speedUp-> speed="+ speed);
		
	}
	public void speedDown() {
		speed--;
		if(speed<SPEED_MIN) speed= SPEED_MIN;
		System.out.println("speedDown-> speed="+ speed);
		
	}
	
}


