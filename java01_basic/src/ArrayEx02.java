
public class ArrayEx02 {

	public static void main(String[] args) {
		// ���� 1~1000������ ���� 100�� ����� �迭�� �����ϰ�
		//     ������ ������ ���� ū���� ���� ������, ����� ���Ͽ� ����϶�.
		
		int data[] = new int[100];
		
		for(int i=0; i<data.length;i++) {
			data[i]= (int)(Math.random()*1000)+1;
			System.out.println(data[i]);
		}
		
		int sum=0;
		int max = data[0];
		int min = data[0];
		for(int i=0;i<data.length;i++) {
			 sum+= data[i]; //���϶�� ���
			 if(max<data[i]) max = data[i];
			 else if(min>data[i]) min = data[i];	 
		}
		int ave = sum / data.length;
		System.out.println("��="+sum);
		System.out.println("���="+ave);
		System.out.println("�ּҰ�="+min);
		System.out.println("�ִ밪="+max);
	}
}
