
public class ArrayTest01 {

	public static void main(String[] args) {
		//�迭�� ���� ���������� ������ ������ ������ �� �ʿ��ϴ�.
		//�迭�� �ѹ� �����Ǹ� ũ�⸦ ������ �� ����.
		
		//�迭�� ���� (1���� �迭)
	    int[] data;//�޸� �Ҵ�ȵ�. 
		int num[] = new int[50]; //�����͸� �������� ����. ����:0 �Ǽ� 0.0 ���� false
		
		String name[] = new String[5];// �ټ����� ���� �� null
		
		num[2] = 100;
		name[1] = "ȫ�浿";

		System.out.println("num[1]=>"+num[1]);
		System.out.println("name[1]=>"+ name[1]);
		
		
		//num�迭�� ��� ���� ����϶�.
		// num[0], num[1], num[2], num[3], num[4]
		// �迭��. �迭�� ũ�⸦ ���Ͽ� �ش�. 
		// 
		for(int idx=0; idx<num.length; idx++) {//0
			System.out.println("num["+idx+"]="+ num[idx]);
		}
		
		//�迭 ������ �ʱⰪ �����ϴ� ���(�������ϴ� �ʱⰪ)
		int[] data2= new int[] {20,65,74,5,87,2};
		for(int i=0; i<data2.length;i++) {
			System.out.println("data2["+i+"]="+ data2[i]);
			
		}
		
		//�迭 ������ �ʱⰪ �����ϴ� ��� 2
		int data3[] = {8,7,5,37,75};
		for(int i =0; i<data3.length; i++) {
			System.out.println("data3["+i+"]="+ data3[i]);
		}
	}
}





















