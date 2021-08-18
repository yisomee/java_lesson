import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionAnswer {

	public ExceptionAnswer() {
		start();
	}
	public void start() {
		do {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("����1=");
				int a = scan.nextInt();
				System.out.print("����2=");
				int b = scan.nextInt();
				int c = a/b;
				System.out.println("c="+c);
		
				String names[] = {"�̼���","�������"};
				for(int i=0; i<=names.length; i++) {
					System.out.println("�̸�="+names[i]);
				}
			}catch(InputMismatchException imie) {
				System.out.println("������ �Է��Ͽ��� �մϴ�.");
				//imie.printStackTrace();// �����޽ñ� ����ִ� ���!! ��� �����ִ��� �˼�����. 
				System.out.println(imie.getMessage());//������ �����޽��� ��������.
			}catch(ArithmeticException ae) {
				System.out.println("0���� ������ �����ϴ�.");
				//ae.printStackTrace();
				System.out.println(ae.getMessage());
			}catch(ArrayIndexOutOfBoundsException aioo) {
				System.out.println("�迭�� ÷�ڰ��� �߸��Ǿ����ϴ�.");
				System.out.println(aioo.getMessage());
			}catch(NumberFormatException nfe) {
				System.out.println("���ڸ� �Է��Ͽ��� �մϴ�.");
			}
		
		}while(true);
		
		}

	public static void main(String[] args) {
		new  ExceptionAnswer();
	}
}
