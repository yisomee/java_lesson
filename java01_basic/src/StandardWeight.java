import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int age, sex, hei, wei;
		double stw, sti;
		String ass;

		System.out.print("����=");
		age = scan.nextInt();
		System.out.print("����(1:����,2:����)=");
		sex = scan.nextInt();
		System.out.print("Ű=");
		hei = scan.nextInt();
		System.out.print("����ü��=");
		wei = scan.nextInt();

		//���
	/*	if(age<=35){
			if(sex==1){
				stw=(hei-100)*0.90;
			} else{
				stw=(hei-100)*0.85;	
			}
		}else{
			if(sex==1){
				stw=(hei-100)*0.95;
			} else{
				stw=(hei-100)*0.90;	
			}
		} 
*/

		if(age<=35 && sex==1) stw =((hei-100)*0.95);
		else if(age<=35 && sex!=1)  stw =((hei -100)*0.90);
		else if(age>35 && sex==1)  stw =((hei -100)*0.90);
		else stw = ((hei-100)*0.85);
	    sti = (wei/stw)*100;

	/*	if(sti<=85){
			ass="������";
		}else if(sti<=95){
			ass="���ݸ�����";
		}else if(sti<=115){
			ass="ǥ����";
		}else if(sti<=125){
			ass="���ݺ���";
		}else
			ass="����";
*/
		if(sti<=85) ass="������";
	    else if(sti<=95) ass="���ݸ�����";
		else if(sti<=115) ass="ǥ����";
		else if(sti<=125) ass="���ݺ���";
		else ass="����";



		//���
		//System.out.printf("ǥ��ü��= %.0f", sti);
        System.out.printf("ǥ��ü��= %d", (int)sti);
		System.out.printf("����� ǥ��ü�������� %f ���� %s\n �Դϴ�.", sti, ass);


	}
}