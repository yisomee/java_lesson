import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("�����Է�=");
		int max=scan.nextInt();
		
		//��ü��, Ȧ����, ¦����
		int total=0, odd=0, even=0;
		
		for(int i=1; i<=max; i++) {
			total += i;
			
			if(i%2==0) even +=i;
			else odd += i;
			
		}
	

		System.out.printf("1~%d������ ���� %d\n", max, total);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n", max, odd);
		System.out.printf("1~%d������ ¦���� ���� %d\n", max, even);


	}
}


/*
����
�����Է�=100
1~100������ ���� 5050
1~100������ Ȧ���� ���� 2500
1~100������ ¦���� ���� 2550

*/