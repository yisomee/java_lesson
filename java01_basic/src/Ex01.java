import java.util.Scanner;
class Ex01 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

	    System.out.print("����=");
		int n1 = input.nextInt() ;

		System.out.print("����=");
		int n2 = input.nextInt();

		int result = (n1>n2)? n1 : n2;
			


        System.out.println(n1+"�� "+n2+"�߿� ū ���� "+result+ "�Դϴ�.");



	}
}

/*

   �� ���� �Է¹޾� ū���� ����϶�.
*/