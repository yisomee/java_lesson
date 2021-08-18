import java.util.Scanner;
public class ArrayScore2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생수=");
		int cnt=Integer.parseInt(scan.nextLine());
		
		String name []= new String[cnt];
		int jumsu[][]=new int[cnt+2][6];
		
		String title[]= {"국어","영어","수학"};
		for(int i=0;i<cnt;i++) {
			System.out.print("이름=");
			name[i] =scan.nextLine();   //이름
			for(int j=0;j<title.length;j++) {
				System.out.print(title[j]);
				jumsu[i][j]=Integer.parseInt(scan.nextLine()); //과목
			}
		}
		
		for(int i=0; i<cnt; i++) {
			for(int j=0; j<3; j++) {
				jumsu[i][3]+= jumsu[i][j]; //개인별 총점
				jumsu[cnt][j]+= jumsu[i][j];// 과목별 총점
			}
			jumsu[i][4]=jumsu[i][3]/3; //개인별 평균
		}
		for(int i=0;i<3;i++) { 
			jumsu[cnt+1][i]=jumsu[cnt][i]/cnt; //*****과목별평균
		}
		
		//석차구하기
		for(int i=0; i<cnt;i++) {
			for(int j=0;j<cnt;j++) {
				if(jumsu[i][3]<jumsu[j][3]) {
					jumsu[i][5]++;
				}
			}
			jumsu[i][5]++;
		}
		
		// 석차순으로 오름차순
		for(int i=0; i<cnt-1;i++) {
			for(int j=0; j<cnt-1-i;j++) {
				if(jumsu[j][5]>jumsu[j+1][5]) {
					
					String nameTemp = name[j];
					name[j] = name[j+1];
					name[j+1]= nameTemp;
				
					for(int k=0;k<jumsu[j].length;k++) {
						int temp = jumsu[j][k];
						jumsu[j][k] = jumsu[j+1][k];
						jumsu[j+1][k] = temp;
					}
				}
				
			}
			
		}
		
		//=========================================================
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
		
		for(int i=0; i<cnt;i++) {
			System.out.print(name[i]+"\t");
			for(int j=0;j<jumsu[i].length;j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.print("총점\t");
		for(int i=0; i<3;i++) { 
			System.out.print(jumsu[cnt][i]+"\t");
			
		}
		System.out.println();
		
		System.out.print("평균\t");
		for(int i=0; i<3;i++) {
			System.out.print(jumsu[cnt+1][i]+"\t");
		}
		System.out.println();
		}
	}
		
		
		
		
		
		
		
		
		

