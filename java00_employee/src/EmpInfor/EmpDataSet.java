package EmpInfor;

import java.util.HashMap;

public class EmpDataSet {
	public static HashMap<String, EmpVO> empList = new  HashMap<String, EmpVO>();

	public EmpDataSet() {
		
	}
	//�⺻������ ����
	public static void basicEmpSet() {
		empList.put("ȫ�浿", new EmpVO("11111","ȫ�浿","010-1234-5678",5000,"2020-05-05"));
		empList.put("����", new EmpVO("22222","����","010-8888-9999",6000,"2020-01-01"));
		empList.put("�Ѻ��", new EmpVO("66666","�Ѻ��","010-7777-8888",5500,"2020-10-10"));
		empList.put("������", new EmpVO("44444","������","010-5555-5555",7000,"2009-03-01"));
		empList.put("�ǻǻ�", new EmpVO("55555","�ǻǻ�","010-1212-3434",4500,"2012-08-09"));
	}
}
