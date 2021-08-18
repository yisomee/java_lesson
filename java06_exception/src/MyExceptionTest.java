import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest() {
		
	}
	public void start() {
		do {
			//������ ����(1~100)������ ���� �Է¹޾� �� �������� ���� ���Ͽ� ����϶�.
			try {
				System.out.print("�������Է��ϼ���(1~100)-->");
				int max = Integer.parseInt(scan.nextLine());// NumberFormatException
				// 1~100
				if(max<1 || max>100) {
					//throw : ���ܸ� ������ �߻���Ų��. 
					throw new MyException();
				}else {
					sum(max);
				}
				
			}catch (NumberFormatException nfe) {
				System.out.println("���ڸ� �Է��ϼ���...");
			}catch(MyException me) {
				System.out.println(me.getMessage());
			}
		}while(true);
	}
	public void sum(int max) {
		int tot= 0;
		for(int i =0; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"������ ���� "+tot);
	}

	public static void main(String[] args) {
		new MyExceptionTest().start();
		

	}

}
