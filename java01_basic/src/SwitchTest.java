import java.util.Scanner;
class SwitchTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�����Է�=");
		int color = scan.nextInt();

		switch(color){
			case 1:
				System.out.println("����");
			    break;
			case 2:
				System.out.println("���");
				break;
			case 3:
				System.out.println("�Ķ�");
			case 4:
				System.out.println("�ʷ�");
				break;
			default:
				System.out.println("����");
				break;
		}
	}
}


// ctrl +  C = Y  ������ â ����. 
// �ݺ��� Ȱ�� for