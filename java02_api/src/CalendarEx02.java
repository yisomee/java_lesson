import java.util.*;

public class CalendarEx02 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
	
		System.out.print("�⵵=");
		int year = scan.nextInt();
		System.out.print("��=");
		int month = scan.nextInt();

		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month); 

		System.out.println("		"+year+"�� "+month+"��");
		System.out.println("��	��	ȭ	��	��	��	��	");


		cal.set(year,month-1,1); 
		                         
		  
		int end = cal.getActualMaximum(Calendar.DATE); 
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
		

		for(int i=1; i<=end; i++) {
			if(i==1) {
				for(int j=1; j<dayOfWeek; j++) {
					System.out.print("\t");
				}
			}
			
			System.out.print(+i+"\t");
			if(dayOfWeek%7==0) { 
				System.out.println();
			}
			dayOfWeek++;
		}
		System.out.println(" ");
	} 
}