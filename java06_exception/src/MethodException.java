import java.util.Scanner;

public class MethodException {

	public MethodException() throws ArithmeticException, NumberFormatException{
		start();
	}
	public void start() throws ArithmeticException, NumberFormatException{
		Scanner scan = new Scanner(System.in);
		System.out.print("�����Է�=");
		int n = Integer.parseInt(scan.nextLine());
		plus(150,n);
	}
	public void plus(int i, int j) throws ArithmeticException{
		int result = i+j;
		System.out.println(i+"+"+j+"="+result);
		devide(i, j);
	}
	public void devide(int i, int j) throws ArithmeticException{
		int result = i/j;
		System.out.println(i+"/"+j+"="+result);
	}

	public static void main(String[] args) {
		try {
			MethodException me = new MethodException();
		}catch(Exception e) {
			System.out.println("������ �߻��߽��ϴ�.--->"+ e.getMessage());
		}	
	}
}
