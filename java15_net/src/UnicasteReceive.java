import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		try {
			ds = new DatagramSocket(15000);
			
			//�ޱ� ��� .................
			byte[]data = new byte[512];
			dp = new DatagramPacket(data,data.length);
			System.out.println("�ޱ�����..");
			ds.receive(dp);//�����͸� ���� ������ �����...
			//DatagramPacket���� ���۹��� �����͸� ������
			byte[] receiveData = dp.getData();
			int byteCount = dp.getLength();//���۹��� byte��
			String receiveStr = new String(receiveData,0,byteCount);
			System.out.println(receiveStr+"-----------");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
