class PrintfTest 
{
	public static void main(String[] args) 
	{
		// format : ���� ����
		// ����: %10d, �Ǽ�: %10.3f, ���ڿ�: %8s, %o(Octal:8����), 
		// %x(Hex:16����), %c(Char)
		// ����� : \n, \t, \\, \", \'

		int num = 1234;
		System.out.printf("num������ ���� %d�Դϴ�.\n", num);
		System.out.printf("������ \"����\"  \t���\\��...\n");

		double num2 = 2548.2351;
			System.out.printf("num2=%10.3f�̴�.\n", num2);

		String namekor = "ȫ�浿";
		String nameEng = "hong";
		System.out.printf("�̸��� %-10s�̴�.\n", namekor); // - ���ʹ�ġ
		System.out.printf("�̸��� %10s�̴�.\n", nameEng); // �����ʹ�ġ 

		int num3= 12;
		System.out.printf("%d, %o, %x\n", num3, num3, num3);


	}
}
