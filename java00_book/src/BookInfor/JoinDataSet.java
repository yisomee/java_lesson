package BookInfor;

import java.util.HashMap;


public class JoinDataSet {
	public static HashMap<String, JoinVO> joinList = new HashMap<String, JoinVO>();
	
	public JoinDataSet() {
	}

	public static void basicJoinSet() {
		joinList.put("����", new JoinVO("����","1234","�躸��","010-2156-9756"));
		joinList.put("�Ѻ��", new JoinVO("�Ѻ��","5678","�ڶѺ�","010-8745-9632"));
		joinList.put("������", new JoinVO("������","0000","�̳���","010-7456-3215"));
		joinList.put("�ǻǻ�", new JoinVO("�ǻǻ�","0123","�ֻǻ�","010-7426-6654"));
		joinList.put("�޴���", new JoinVO("�޴���","0101","���޴�","010-7567-5896"));
	}
}
	
	
	
	
	

