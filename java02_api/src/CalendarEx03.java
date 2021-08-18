import java.util.Scanner;
import java.util.Calendar;
class CalendarEx03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵=");
		int year = scan.nextInt();
		System.out.print("��=");
		int month = scan.nextInt();

		System.out.printf("\t\t%d�� %d��\n", year, month);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		//���� ��¥ �ð� ��ü ���ϱ�
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, 1);// ��¥���� 

		int week = date.get(Calendar.DAY_OF_WEEK); // 1���� ������������ ���ϴ°�

		//���� ��������
		//1,3,5,7,8,10,12 ->31��
		//4,6,9,11-> 30��
		//2 -> 28��,29��

	/*	int lastDay = 31;
		switch(month){
			case 4: 
			case 6:
			case 9:
			case 11:
				lastDay=30;break;
			case 2:
				// �⵵�� 4�� ����������, 100���� �ȳ������� �����̴�.
				// 400���� ���������� �����̴�
				if(year%4==0 && year%100!=0 || year%400==0){
					lastDay = 29;
				}else{
					lastDay = 28;
				}
		}
		*/
		
		int lastDay = date.getActualMaximum(Calendar.DATE); 
		//�������
		for(int s=1; s<week; s++){
			System.out.print("\t");
		}
		//��¥ ���
		for(int d=1; d<=lastDay;d++){
			System.out.print(d+"\t"); 
			if((d+week-1)%7==0){
				System.out.println();
			}
		}
		System.out.println();

	}
}
