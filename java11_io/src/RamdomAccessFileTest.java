import java.io.File;
import java.io.RandomAccessFile;

public class RamdomAccessFileTest {

	public RamdomAccessFileTest() {
		//���ϴ� ��ġ�� �����͸� �а� ���Ⱑ �����ϴ�.
		File f = new File("D://testFile/access.txt");
		try {
			// ��������: w, �б����� : r, �б⾲�� : rw
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String str = "Java input output test programing";
			raf.writeBytes(str);
			raf.writeInt(12345);
			
			//������ ��ġ �̵�
			raf.seek(10);
			raf.writeBytes("hong");
			
			// Ŀ���� ���������� �ű�� 
			raf.seek(raf.length());
			byte[] data = {65,66,67,68};
			raf.write(data);
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RamdomAccessFileTest();

	}

}
