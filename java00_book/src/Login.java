

public class Login {
	private final String USERID = "admin";
	private final String USERPWD = "1234";
	
	public Login() {// �����ڸ�� ���� ���̵�, ���
		// ����ڸ�� ���̵�, ��� ������ BookManager�� �����س���!!! �Ф�
		
	}
	// �α��� üũ ���� (true:�α��μ���, false:�α��ν���)
	public boolean loginCheck(String userid, String userpwd) {
		if(userid.equals(USERID)&& userpwd.equals(USERPWD)){
			//�α��μ���
			return true;
		}else {
			//�α��� ����
			return false;
		}
	}
	
}




