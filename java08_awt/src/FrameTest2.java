import java.awt.Button;
import java.awt.Frame;

public class FrameTest2 {
	Frame frm = new Frame("����");
	Button btn = new Button("��ü�� �̿��� �����̳� �����");
	public FrameTest2() {
		frm.add(btn);
		
		frm.setSize(500,300);
		frm.setVisible(true);
	}

	public static void main(String[] args) {
		new FrameTest2();

	}

}
