
public class AaaBbbMain {

	public AaaBbbMain() {
		
	}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		//����Ŭ������ ��ü�� �����ϸ� ����Ŭ������ ���Եȴ�.
		AAA a = new BBB();
		a.output();
	
	
		System.out.println("b.tel="+ b.tel);//010-12234-1234
		//System.out.println("a.tel="+ a.tel);
		System.out.println("");
		System.out.println("a.name="+a.name);
		System.out.println("a.num="+a.num);
		
		BBB c = (BBB)a;
		c.output();
		Object obj = new BBB();
		BBB d =(BBB)obj;
		d.output();
		//����ȯ
		
	
	}
}
