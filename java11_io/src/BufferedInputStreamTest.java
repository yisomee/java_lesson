import java.io.BufferedInputStream;

public class BufferedInputStreamTest {

	public BufferedInputStreamTest() {
		try {
			// BufferedInputStream : ����Ʈ ������ ���ڸ� �о� ���ۿ� ������ ���پ� ���� �� �ִ� ��ü
			BufferedInputStream bis = new BufferedInputStream(System.in);
			byte data[] = new byte[10];
			System.out.print("�Է�=");
			int cnt = bis.read(data);
			System.out.println(new String(data));
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new BufferedInputStreamTest();

	}
}
