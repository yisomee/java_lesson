
public class ArrayEx04 {

	public static void main(String[] args) {
	int data[][] = new int[10][10];
	
	for(int row=0; row<data.length-1; row++) {
		for(int col=0; col<data[row].length-1;col++) {
			data[row][col] = (row+1)*(col+1);
			data[row][9] += data[row][col];// ���� ��
			data[9][col] += data[row][col];
		}
	}
		
		//���
		for(int d[]: data) {
			for(int r : d) {
				System.out.printf("%5d", r);
				
			}
			System.out.println();
		}
	}
}
	/*	int r,c; // r =��, c=��
		int num[][]= new int[10][10];
	
		for( r=0; r<9; r++){// ��
		for( c=0; c<9; c++) {//�� 
			num[r][c]= (r+1) * (c+1);  
			
		}
		num[0][r] = num[r][0];
	}
		
		for(int[] data : num) {
			for(int z : data) {
				System.out.print(z+"\t");
			}
			System.out.println();
			
		}
		*/
