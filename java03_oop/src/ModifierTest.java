import test.DefaultData;

public class ModifierTest {

	public ModifierTest() {
	
	//LottoOOP lotto = new LottoOOP();
	//lotto.lottoStart();
	
		DefaultData dd = new DefaultData();
		//��ü��.�������
		//System.out.println("�̸�="+ dd.name);
		//System.out.println("tel"+dd.tel);
		System.out.println("�̸�="+ dd.getName());
		
		DefaultData dd2 = new DefaultData("�̼���", "010-8888-8888");
		dd2.sum();
		
		DefaultData.sum();
		DefaultData.getName();
	}
	

	public static void main(String[] args) {
		//����������
		// Ŭ���� : public, default(����)
		// �����ڸ޼ҵ�, �޼ҵ� : public, protected, default, private
		new ModifierTest();
		

	}

}
