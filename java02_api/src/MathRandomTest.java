
public class MathRandomTest {

	public static void main(String[] args) {
		// ����: ��ǻ�Ͱ� ����Ǵ� ���迡 0.0�� 1.0������ ���� �����ȴ�.
		
		// 100 -> 0~99
		//     -> 50~100
		
		//�������� ���ϴ� ���� ���� ���ϴ� ����!! 
		for(int i=1; i<1000;i++) {
			double ran = Math.random();
			
			int ranInt = (int)(ran*(6)) +1;
			//                   (����ȭ)( ����*(ū��-������+1)) +������
			
			System.out.println(ranInt+"\t");
			if(i%10==0) System.out.println();
			
		}

	}

}
