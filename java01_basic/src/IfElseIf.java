import java.util.Scanner;
class IfElseIf
{
public static void main(String[] args)
{
Scanner scan = new Scanner(System.in);


	// 1. �޿��Է�
	System.out.print("�޿��� �Է��ϼ���-->");
	int sal = scan.nextInt();
    double bonus = 0;
	if(sal>=10000 && sal<=20000){
		bonus = (sal * 0.2);
	}else if(sal>20000 && sal<=30000){
		bonus = (sal * 0.15);
	}else if(sal>30000 && sal<=40000){
		bonus = (sal * 0.1);
	}else if(sal>40000 && sal<=50000){
		bonus = (sal * 0.05);
	}
	System.out.printf("�޿�=%d, ���ʽ�=%.0f\n", sal, bonus);
  }
}

/*
    int bonus = 0;
	if(sal>=10000 && sal<=20000){
		bonus = (int)(sal * 0.2);
	}else if(sal>20000 && sal<=30000){
		bonus = (int)(sal * 0.15);
	}else if(sal>30000 && sal<=40000){
		bonus = (int)(sal * 0.1);
	}else if(sal>40000 && sal<=50000){
		bonus = (int)(sal * 0.05);
	}
	System.out.printf("�޿�=%d, ���ʽ�=%d\n", sal, bonus);

	*/