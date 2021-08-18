import java.util.Scanner;
import java.util.Calendar;

public class CalendarEx04 {
	
	int year, month, week, lastday;
	
	Calendar date = Calendar.getInstance();

	 CalendarEx04() {
		
	}

	 int getCalendar(String a) {
		 Scanner scan = new Scanner(System.in);
			System.out.print(a);
			return scan.nextInt();
	 }
	 
	 void setData() {
			year = (int)getCalendar("�⵵=");
			month = (int)getCalendar("��=");
		}
	 
	 
	 void setnow() {

			date.set(year, month-1, 1);
	 }
	 
	 void setdayofweek() {
		  week = date.get(Calendar.DAY_OF_WEEK);
	 }
	 
	 void setlastday() {
		  lastday = date.getActualMaximum(Calendar.DATE);
	 }
	 
	 void setresult() {
		
			for(int s=1; s<week; s++){
				System.out.print("\t");
			}
			
			for(int d=1; d<=lastday;d++){
				System.out.print(d+"\t"); 
				if((d+week-1)%7==0){
					System.out.println();
				}
			}
			System.out.println();
	 }
	 
	 void setoutput() {
			System.out.printf("\t\t%d�� %d��\n", year, month);
			System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	 }
	 
	 
	 void startCalendar() {
			setData();
			setoutput();
			setnow();
			setdayofweek();
			setlastday();
			setresult();
		}
	 
	 
	public static void main(String[] args) {
		CalendarEx04 cal = new CalendarEx04();
		cal.startCalendar();
		
		
	}

}