//package 

//�ʿ��� Ŭ������ ��ġ(��Ű����� Ŭ���� ���� �����Ѵ�.)
import java.util.Scanner;
import java.lang.String;//�������. compiler�� �����ϰ������� �ڵ����� import���ش�.
import java.util.Random;
import java.util.*; //��ƿ�̶�� ��Ű���ȿ� ��� Ŭ���� (������������.)
public class ClassTest {
	//�������
	
	// �������= ��������
	int a=100;
	String name="ȫ�浿";
	//��������� �ʱⰪ�� �ڵ����� �����ȴ�.
	//����(byte, short, int, long) :0 
	//�Ǽ�(float, double) : 0.0
	//��(boolean) : false
	//����(char) :
	//String, Scanner, Random = null
	int b;
	double c;
	String nameStr;//null
	Scanner scan;//null
	Random ran;//null
	//��ü������ �����ϴ�.
	Scanner scanner = new Scanner(System.in);
	//���๮�� ������� ���Ұ�
	//System.out.println("�ֹܼ��� ����ϱ�");
	int k= 100+500;
	//int dd[] = new int[10];
	//dd[3]=200;
	//���๮���� �޼ҵ� �ȿ��� ����� �Ѵ�.
	
	//�����ڸ޼ҵ� : ��ü�� �����Ҷ� �ѹ� ����Ǵ� �޼ҵ�
	// 			 �޼ҵ� ���� �ݵ�� Ŭ������� ���ƾ� �Ѵ�.
	//			 ��ü ������ ��ü�� �����͸� �ʱ�ȭ�� �� �ִ�.
	//		�����ڸ޼ҵ带 �������������� �����Ͻ� �����Ϸ��� 
	//		�Ű������� ���� �����ڸ޼ҵ带 �ڵ����� �߰� ���ش�.
	//		ClassTest(){}
	ClassTest(){//�ŰԺ���x
		//���๮ ���� 
		b= 1234;
		System.out.println("������ �޼ҵ尡 �����");
		
	}
	
	ClassTest(int a){
		System.out.println(a+"�޼ҵ� ����~~~");
	}
	
	//�޼ҵ�: �ϳ��� �������
	//		Ŭ������ ��ü ������ �޼ҵ带 ȣ���Ͽ��� ����ȴ�.
	// ��ȯ�� �޼ҵ��(�Ű�����, �Ű�����){
	//}
	// �޼ҵ�� ���� ��Ģ :
	//			�ҹ��ڷ� �����Ѵ�. �ռ����϶��� �ι�° �ܾ������ ù��° ���ڸ� �빮�ڷ�
	void sum() {
		//�����
		System.out.println("sum()�޼ҵ尡 �����");
	}
	void total(int a, int b) {
		System.out.println("���� "+(a+b));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
