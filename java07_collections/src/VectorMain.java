import java.util.Calendar;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {
		//VectorTestŬ������ start()�޼ҵ带 ȣ���ϸ� Vector�� ���ϵȴ�.
		VectorTest vt = new VectorTest();
		Vector vvv = vt.start();
		
		String aaa = (String)vvv.elementAt(0);
		System.out.println("aaa="+aaa);
		Calendar ccc = (Calendar)vvv.get(1);
		System.out.println("ccc="+ccc);
		Integer iii = (Integer)vvv.elementAt(2);
		System.out.println("iii="+iii);
		MemberVO vo = (MemberVO)vvv.elementAt(3);
		vo.memberPrint();
		
		System.out.println(vvv.toString());// �ּҸ� ���ڷ�?
	}

	public static void main(String[] args) {
		new VectorMain();

	}
}
