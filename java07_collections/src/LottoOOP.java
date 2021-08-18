import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoOOP {
	Random random = new Random();
	Scanner scan= new Scanner(System.in);
	public LottoOOP() {
		
	}
	//1���Ӹ���� + ���ʽ� ����, �ߺ��˻�
	public void lottoCreate(int i) {
		//�ߺ�����, ����
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		int num=0;
		while(lotto.size()<7) {
			num=random.nextInt(45)+1;
			lotto.add(num);			
		
		}
		//lotto TreeSet��ȣ 7���� �ְ�, num���� ���������� ���� ��ȣ�� �ִ�.
		//���ʽ���ȣ�� �ζǹ�ȣ���� �����.  TreeSet��ȣ 6���� �ִ�.
		lotto.remove(num);
	
		lottoPrint(i, lotto.toString(), num);
		//toString : ���ڿ��θ���� �����ϴ� �޼ҵ�
	}

	// ���
	public void lottoPrint(int cnt, String lotto, int bonus) {
		System.out.print(cnt+"����");
		System.out.print(lotto);//��ȣ
		System.out.println(", bonus="+ bonus);
		
	}
	//��ӿ��� Ȯ���ϴ� �޼ҵ�
	public boolean yesNO() {
		do {
			System.out.println("����Ͻðڽ��ϱ�(y:��. n:�ƴϿ�)?");
			String qa =  scan.nextLine();
			//y:���, n:����, �׿� �ٽ� 
			if(qa.equalsIgnoreCase("y")) {
				return true;
			}else if(qa.equalsIgnoreCase("n")){
				return false;
			}
		}while(true);
	}
	
	public void lottoStart() {
		do {
			try {
			    System.out.print("���Ӽ�=");
			   	int game = Integer.parseInt(scan.nextLine());//NumberFormatException
			   	//����
			   	for(int i=1; i<=game; i++) {
			   		 lottoCreate(i);
			   	
			   	}
				//��ӿ���
			   	if(!yesNO()) {
			   		break;
			   	}
			}catch(NumberFormatException nfe) {
				System.out.println("���Ӽ��� ���� �����̾�� �մϴ�.");
			}
		}while(true);
	}
	
	public static void main(String a[]) {
		LottoOOP oop = new LottoOOP();
		oop.lottoStart();
	}
}















