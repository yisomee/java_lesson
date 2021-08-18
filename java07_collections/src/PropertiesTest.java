import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Properties �÷���: key, value ��� String�� �÷����̴�.
		
		Properties prop = new Properties();
		
		//��ü�߰�
		prop.setProperty("���̹�", "http://www.naver.com");
		prop.setProperty("����Ʈ", "http://www.nate.com");
		prop.setProperty("����", "http://www.daum.net");
		prop.setProperty("����", "http://www.google.com");
		//getProperty(): Ű�� �̿��Ͽ� ��ü ������
		
		System.out.println(prop.getProperty("����"));
		
		// Ű ��� ��ü ���ϱ�
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {//��ü�� ���������� true, ������ false
			//Object obj = e.nextElement();
			String str = (String)e.nextElement();
			System.out.println("key="+str+", value"+prop.getProperty(str));
		}
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
