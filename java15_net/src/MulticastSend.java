import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend {
//224.0.0.0~239.255.255.255
	//225.0.0.24
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	public MulticastSend() {
		try {
			ms = new MulticastSocket();
			ia = InetAddress.getByName("225.0.0.24");
			String data = "��Ƽĳ��Ʈ ������ �̿��� ������ ����";
			dp = new DatagramPacket(data.getBytes(),data.getBytes().length,ia,17000);
		
			ms.send(dp);
			System.out.println("������Ϸ�");
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new MulticastSend();

	}

}
