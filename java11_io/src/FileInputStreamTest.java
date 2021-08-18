import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInputStreamTest {

	public FileInputStreamTest() {
		// ������ ������ �о� ���Ϸ� ����ϱ� 
		File srcFile = new File("C:\\workspace.java\\java02_api\\src/CalendarTest.java");//C:\workspace.java\java02_api\src
		File tarFile = new File("D://testFile/CalendatTestEx.java");
		
		try {
			FileReader fr = new FileReader(srcFile);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter(tarFile);
			
			while(true) {
				String str = br.readLine();
				// ���� �����Ͱ� ���� �� null 
				if(str == null)break;
				fw.write(str+"\n");
				System.out.println(str);
			}
			fw.close();
			br.close();
			fr.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileInputStreamTest();

	}

}
