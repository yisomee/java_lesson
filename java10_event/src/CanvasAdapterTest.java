import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CanvasAdapterTest extends MouseAdapter{
	MouseAdapterTest2.MyCanvas mc;
	public CanvasAdapterTest() {
		
	}
	public CanvasAdapterTest(MouseAdapterTest2.MyCanvas mc) {
		this.mc = mc;
	}
	//�޼ҵ� �� �������̵� 
	public void mouseReleased(MouseEvent me) {
		if(me.getButton()==1) {
			mc.x = me.getX();
			mc.y = me.getY();
			mc.repaint();
		}
	}
}
