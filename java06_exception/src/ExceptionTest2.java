
import java.util.Scanner;
import java.util.InputMismatchException;


public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest2() {
	}
	public void start() {
		do {
			try {
				//�μ��� �Է¹޾� ��Ģ�����Ͽ� ����϶�.
				System.out.print("ù���� ��=");
				int n1 = scan.nextInt();//---------------
				System.out.print("�ι�° ��=");
				int n2 = scan.nextInt();//---------------
				
				int plus = n1 + n2;
				int minus = n1 - n2;
				int mul = n1 * n2;
				int devide = n1 / n2;//-------------------
				System.out.println(n1+"+"+n2+"="+plus);
				System.out.println(n1+"-"+n2+"="+minus);
				System.out.println(n1+"*"+n2+"="+mul);
				System.out.println(n1+"/"+n2+"="+devide);
				
				String names[] = {"ȫ�浿","��浿"};
				for(int i=0; i<=names.length; i++) {
					System.out.println("names["+i+"]="+names[i]);
					
				}
				
			}catch(ArrayIndexOutOfBoundsException aioo) {////Exception���� ���� �;��Ѵ�
				System.out.println("�迭�� ÷�ڰ� �����Դϴ�.");
			}catch(Exception e) {// NumberException , ArithmeticException
				System.out.println("Exception -->"+e.getMessage());
			}
			
		}while(true);
		//	System.out.println("���α׷�����");
	}
	public static void main(String[] args) {
		ExceptionTest2 et = new ExceptionTest2();
		et.start();
	}
}
/*
  ����: �ϵ���� ���� ó�� ���α׷����� ������ �� ���� ������ ���Ѵ�. 
  ����ó��: ���α׷����� �����Ҽ��ִ� ������ Exception�̶�� �Ѵ�.
  
  1. ���
  try{
  	  ���๮;
  	  ���ܹ߻��� ���ɼ��� �ִ� ��ɾ� �Ǵ� ���ܹ߻��� ���ɼ��� ���� ��ɾ ��� ǥ���� �� �ִ�.
  	  
  }catch(��������){
  		���ܰ� �߻��ϸ� ������ ���๮
  }catch(��������){
  		���ܰ� �߻��ϸ� ������ ���๮
  
  }
  :
  :
  finally{
  		���ܰ� �߻��ϵ� ���ϵ� ������ ����Ǵ� ���๮;
  		��������
  }
  
 */






