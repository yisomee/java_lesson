import java.util.Scanner;
public class ArrayScoreException {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		do {
			try {
				System.out.print("�л���=");
				int cnt = Integer.parseInt(scan.nextLine());
		
				String name[]= new String[cnt];
				int jumsu[][]= new int [cnt+2][6];
				
				String title[]= {"����","����","����"};
				for(int i=0;i<cnt;i++) {
					System.out.print("�̸�=");
					name[i]	= scan.nextLine();
					for(int j=0;j<title.length; j++) {
						System.out.print(title[j]+"=");
						jumsu[i][j]= Integer.parseInt(scan.nextLine());
				
					}
				}
	
				for(int i=0; i<cnt; i++) {
					for(int j=0; j<3; j++) {
					jumsu[i][3]+= jumsu[i][j]; 
					jumsu[cnt][j]+= jumsu[i][j];
					}
				
					jumsu[i][4] = jumsu[i][3]/3;
				}
			
				for(int i=0;i<3;i++) {
					jumsu[cnt+1][i] = jumsu[cnt][i]/cnt;					
				}
			
				for(int i=0; i<cnt; i++) {
			
					for(int j=0; j<cnt; j++) {
					
						if(jumsu[i][3] < jumsu[j][3]) {
							jumsu[i][5]++;
						}	
					}
					jumsu[i][5]++;
				}
	
				for(int i=0; i<cnt-1;i++) {
					for(int j=0;j<cnt-1-i;j++) {
						if(jumsu[j][5] > jumsu[j+1][5]) {
						
							String nameTemp = name[j];
							name[j] = name[j+1];
							name[j+1]= nameTemp;
							
							for(int k=0;k<jumsu[j].length; k++) {
								int temp = jumsu[j][k]; 
								jumsu[j][k] = jumsu[j+1][k];
								jumsu[j+1][k] = temp;
							}
						}
					}
				}
		
					
				System.out.println("===================================================");
				System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
				System.out.println("===================================================");
				
				for(int i=0; i<cnt;i++) {
					System.out.print(name[i]+"\t");
					
					for(int j=0; j<jumsu[i].length;j++) {
						System.out.print(jumsu[i][j]+"\t");
					}
					System.out.println();
				}
			
				System.out.print("����\t");
				for(int i=0; i<3;i++) {
					System.out.print(jumsu[cnt][i]+"\t");
				}
				System.out.println();
				
				System.out.print("���\t");
				for(int i=0; i<3; i++) {
					System.out.print(jumsu[cnt+1][i]+"\t");
				}
				System.out.println();
			}catch(Exception e) {
				System.out.println("�����Դϴٿ�. ���ڸ� �Է����ּ���");
			}
		}while(true);
		

	}
}









