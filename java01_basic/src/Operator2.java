class Operator2 
{
	public static void main(String[] args) 
	{
		// ��Ʈ ������ : &, |, ^(XOR), ~ ->2���� �����͸� �̿��� ������
		int a = 12;
		int b = 4;
 
		int result = a & b; // 1:true, 0:false  ���� �ϳ��� false���� false
		System.out.println("result="+result);  //result=4
		//���� �ʱ�ȭ �Ҷ� ����Ѵ�. �����Ͱ� ������͵�. &�����ڷ� 0�� ���ϸ� �� false �� 0�� �����ϱ�

        int result2 = a | b;   // ���� �ϳ��� true ���� true 
		System.out.println("result2="+result2);    // result2=12


		int result3 = a ^ b;  // XOR : �� ���� �ٸ��� true     
		System.out.println("result3="+result3);    //result3=8

		int result4 = ~a; // -13
		System.out.println("result="+result4);// ~ ����
		// ������ �����͸� ȯ���ϴ� ��� : 2���� -> 1�Ǻ��� +1
		// 1�� ������ 0�� 1�� 1�� 0���� �ٲٴ� ���̴�.




		// ����Ʈ ������ : ��Ʈ�� �̵�
		// << : ��Ʈ�� �������� �̵�(�ڿ��� 0���� ä����) *���
		// >>(��ȣ�� ä����), >>>(0���� ä����) : ��Ʈ�� ���������� �̵�(�ڿ� ������ ����) /���

		int result5 = a << 2; //�������� 2bit �̵� �������� 0���� ä��  48  12*4
		System.out.println("result5="+result5);

		int result6 = a >> 2; //���������� 2bit�̵� ���� ���� �ڸ��� ��ȣ�� ä������. //12/4 = 3
		int result7 = result4 >> 2; //-4
		System.out.println("resutl6="+result6);
		System.out.println("resutl7="+result7);

		int result8 = result4 >>> 2;
		System.out.println("result8="+result8);

		//����.........���� ��ħ�� �����ؾ���. ī�信 �־�� ��.
		// ���� �޸��忡 �־ �̸��Ϸ� ������ ��. 










 

	}
}
