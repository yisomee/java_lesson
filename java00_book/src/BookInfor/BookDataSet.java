package BookInfor;

import java.util.HashMap;

public class BookDataSet {
		public static HashMap<String, BookVO> bookList = new HashMap<String, BookVO>();
		
		public BookDataSet() {
			 
		}
		
			public static void basicBookSet() {
				bookList.put("�׷��Ա׷���", new BookVO("1001", "�׷��Ա׷���" ,"������","�ִϾ�迵��","���԰���","500"));
				bookList.put("������", new BookVO("1002", "������" ,"��ο�","�����ִϾ�","���԰���","500"));
				bookList.put("��å", new BookVO("1003", "��å" ,"������","��нż�","���԰���","400"));
				bookList.put("������å", new BookVO("1005", "������å" ,"��ȭ��","�����ִϾ�","���԰���","300"));
				bookList.put("����������", new BookVO("1006", "����������" ,"�迵��","���е���","���԰���","700"));
				bookList.put("�亸�ٿ���", new BookVO("1007", "�亸�ٿ���" ,"�̻���","å���","���԰���","800"));
				bookList.put("�����𸣴�", new BookVO("1008", "�����𸣴�" ,"��ȭ��","�����ִϾ�","���԰���","300"));
				bookList.put("ƼŸ��", new BookVO("1009", "ƼŸ��" ,"������","����","���԰���","300"));
				
			
		}
}
