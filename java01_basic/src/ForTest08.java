import java.util.Scanner;
class ForTest08  
{
	public static void main(String[] args) 
	{
	Scanner scan= new Scanner(System.in);
	System.out.print("�޴�[1. �簢���� ����, 2. ���ǳ���, 3. ����]?");
	int cnt=scan.nextInt();
	if(cnt==1) { 
		System.out.print("����=");
		int wid = scan.nextInt();
		System.out.print("����=");
		int hei = scan.nextInt();
		int result=(wid*hei);
		System.out.printf("�簢���� ����="+result);
		
	}else if (cnt==2) {
		System.out.print("������=");
		int r = scan.nextInt();
		double circle= r * r * 3.141592;
		System.out.print("���ǳ���="+ circle);
	}else if(cnt==3) {
		System.out.println("�޴��� �ٽü����ϼ���...");
	}
		
		
		
	}
}

			









/* 
�簢���� ���� = ����*����
���� ���� = ������*������*3.141592

����
�޴�[1. �簢���� ����, 2, ���� ����, 3.����]?1
����=
����=
�簢���� ����= 

�޴�[1. �簢���� ����, 2, ���� ����, 3.����]?2
������=
���� ����=

�޴�[1. �簢���� ����, 2, ���� ����, 3.����]?3

*/

