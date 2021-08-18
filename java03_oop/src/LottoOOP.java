
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoOOP {
	Random random = new Random();
	Scanner scan= new Scanner(System.in);
	public LottoOOP() {
		
	}
	public int[] lottoCreate() {
		int lotto[] = new int[7];
		for(int i=0; i<lotto.length; i++) {
			//�ζǹ�ȣ ����
			lotto[i] = random.nextInt(45)+1;			
			//�ߺ��˻� 
			i = doubleCheck(lotto, i);
		}
		return lotto;
	}
	//�ߺ��˻�
	public int doubleCheck(int lotto[], int i) {
		for(int j=0; j<i; j++) {
			if(lotto[j] == lotto[i]) {
				i--;
				break;
			}
		}
		return i ;
	}
	
	// ���
	public void lottoPrint(int cnt, int lotto[]) {
		System.out.print(cnt+"����");
		System.out.print( Arrays.toString(Arrays.copyOfRange(lotto, 0, 6)));//��ȣ
		System.out.println(", bonus="+ lotto[6]);
		
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
		    System.out.print("���Ӽ�=");
		   	int game = Integer.parseInt(scan.nextLine());
		   	//����
		   	for(int i=1; i<=game; i++) {
		   		int lotto[] = lottoCreate();
		   		Arrays.sort(lotto,0,6);//����
		   		lottoPrint(i,lotto);// ���
		   	}
			//��ӿ���
		   	if(!yesNO()) {
		   		break;
		   	}
		}while(true);
	}
	
	public static void main(String a[]) {
		LottoOOP oop = new LottoOOP();
		oop.lottoStart();
	}
}













