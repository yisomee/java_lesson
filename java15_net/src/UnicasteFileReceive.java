import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteFileReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteFileReceive() {
		receiveStart();
	}
	public void receiveStart() {
		try {
			ds = new DatagramSocket(16000);
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			FileOutputStream fos = null;
			
			while(true) {
				//�ޱ� ���
				System.out.println("�ޱ�����");
				ds.receive(dp);
				
				//������ ������ ���ϸ�, ���ϳ���, ������ ǥ������ Ȯ��
				byte[] receiveData = dp.getData();
				int len = dp.getLength();
				
				String part = new String(receiveData,0,4);
				if(part.equals("FN##")) {//���ϸ�
					String filename = new String(receiveData,4,len-4);
					System.out.println("filename--->"+filename);
					fos = new FileOutputStream(new File("D:\\download",filename));
					System.out.println("io��ü ������.");
				}else if(part.equals("$%#$")) {
					//������ �����ϋ�
					if(fos!=null) {
						fos.write(receiveData,4,len-4);
					}
				}else if(part.equals("^%$&")) {
					fos.close();
					fos = null;
					System.out.println("���Ϲޱ� �Ϸ�");
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UnicasteFileReceive();
	}

}
