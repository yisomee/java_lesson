import java.util.Scanner;
public class ArrayEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// �迭�� �̿��ϴ� ����
		//7(����,����,����,����,����,�ѱ���,����)������ ������ �Է¹޾� ������ ����� ���϶�.

		String[] title = {"����","����","����","����","����","�ѱ���","����"};
		int jumsu[] = new int[7];//0,0,0,0,0,0,0
		
		//�����Է�
		for(int idx=0;idx<title.length;idx++) {//idx=0
			System.out.print(title[idx]+"=");
			jumsu[idx] = scan.nextInt();
		}
		int tot = 0; //����
		for(int i=0; i<title.length; i++) {
			tot = tot +jumsu[i];
		}
		int ave = tot/ 7;
		System.out.println("����="+ tot);
		System.out.println("���="+ ave);
		}
	}