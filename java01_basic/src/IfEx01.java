import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int first, second, add, minus, mul, devide;

		System.out.print("ù��° ����=");
		 first = scan.nextInt();
		System.out.print("�ι�° ����=");
		 second = scan.nextInt();

		if(first>0 && second>0){
			 add = first+second;
			 minus = first+second;
			 mul = first*second;
			 devide = first/second;
			System.out.printf("%5d + %5d = %5d\n", first, second, add);
			System.out.printf("%d - %d = %d\n", first, second, minus);
			System.out.printf("%d * %d = %d\n", first, second, mul);
			System.out.printf("%d / %d = %d\n", first, second, devide);

		}else{
			System.out.printf("�����͸� �߸��Է��ϼ̽��ϴ�.");

		}
	}
}

