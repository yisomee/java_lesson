import java.util.Scanner;
class IfTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int num;

		System.out.print("0���� ū ������ �Է��ϼ���...");
		num = scan.nextInt();

		if(num/2 == num/2.0) //num%2==0
			System.out.printf("%d�� ¦���Դϴ�.",num);
		    System.out.println("End");
	}
			
	}
	


