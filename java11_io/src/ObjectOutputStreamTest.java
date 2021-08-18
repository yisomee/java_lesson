import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		try {
			File f = new File("D://testFile/object.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Memo memo = new Memo();
			
			oos.writeObject(memo); //��ü�� �޸� ���� �־����?/ 
			oos.close();
			fos.close();
			System.out.println("��ü ���� �Ϸ�");
			
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}
}
