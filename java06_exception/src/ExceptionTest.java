//����ó�� 
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest() {
		
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
			}finally {
				//���ܹ߻��� ������� ������ ����
				System.out.println("finally �����...");
			}
			
		}while(true);
		//	System.out.println("���α׷�����");
		}
		public static void main(String[] args) {
			ExceptionTest et = new ExceptionTest();
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






