import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		try {			
			// getLocalHost(): ���� �� ��ǻ���� IP�� �̿��ؼ� InetAddress ��ü �����ϱ� 
			InetAddress ia1 = InetAddress.getLocalHost();
			// �� ������ Ȯ�� �� �� �غ���...
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			System.out.println("hostAddr1->" + hostAddr1); // �� IP(cmd > ipconfig�� Ȯ��)
			System.out.println("hostName1->" + hostName1); // �� ��ǻ�� �̸�(��PC > �Ӽ��� ��ϵ� ����̽� �̸�), ���� URL�� ���Դٸ� �� ������ �̿��ϰ� �ִ� ���̴�
			
			
			// getByName(): URL �ּҷ� InetAddress ��ü�� �����ϱ�, IP�� URL �ּ� ������ ��ü�� ����. 
			// https: ���� ���õ� ��� �Ծ�(��������)
			// www: world wide web
			// domain: (nate.com ��)
			// ���� ������Ʈ�� www.domain�� ������ ��ü�� ����� �ش� �� ������ �ּҸ� �� �� �ִ� ���̴�...! 
			InetAddress nate = InetAddress.getByName("www.nate.com");
			System.out.println("nate->address-->: " + nate.getHostAddress());
			System.out.println("nate->name-->: " + nate.getHostName());
			// �˻�â�� IP �ּҸ� �׳� �ĵ� ����Ʈ�� ������ �Ǵ� ���� Ȯ���� �� �ִ�! lol
			
			
			// �ٵ� �ݴ�� IP�� ��ü�� ����� IP���� �����ְ� �������� ���������� ���Ѵ�. �ֳ��ϸ� IP�� ���� �ּҰ� �������� ���� �񽺹����� ���̱� �����̴�... 
			InetAddress nateIp = InetAddress.getByName("120.50.131.112");
			System.out.println("nateIP->address-->" + nateIp.getHostAddress());
			System.out.println("nateIP->name-->" + nateIp.getHostName());
			
			
			// getAllByName(): �ش� ������ ����ϴ� ��� IP �ּ� ���ϱ�
			// �����̳� ���̹����� ������ ����Ʈ������ IP �ּҸ� ������ ���� ��쵵 �ֱ� ������... �̰� ���� �ʿ��ϴ�  
			InetAddress[] ip = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ia : ip) {
				System.out.println("============================================================================");
				System.out.println("address-->" + ia.getHostAddress());
				System.out.println("name-->" + ia.getHostName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InetAddressTest();
	}
}

// ��ǻ�� ������ ����� �� �� ������ �޴� ��ǻ���� ip(�ּ�)�� �ʿ��ϴ�
// ip�� �ϳ��� ������, �������� port(2�� 16���� �� ����)�� �־ ���� ���� ��ǻ�Ϳ� ���ÿ� ����� �� �ִ�.
// (�� ��ǻ���� ip Ȯ��> cmd > ipconfig)
// (����IP�� ���ýø��� �ٲ�� IP, ����IP�� ������ �ʴ� ������ IP)
// ���� ��ǻ���� IPv4 �ּҸ� ��ü�� ����� ������ ���� �� �ִ�. (String)
// �̴� InetAddress Ŭ������ ���� ���� �� �ִ�. �ش� Ŭ������ Serializable(����ȭ)�� ����ϹǷ� 