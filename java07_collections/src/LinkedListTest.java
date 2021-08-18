import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		start();
	}
	public void start() {
		//LinkedListTest : List, Deque, Queue
		//					Queue�϶� �Է¼����� �����ϰ�, ����� ���� �Էµ� ��ü�� ��µȴ�.
		//					��µ� ��ü�� �÷��ǿ��� ��������. 
		//					Deque�϶��� ���ʿ��� �߰� ��ü�� �Է� �Ǵ� ����� �� �ִ�.
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//��ü �߰�
		ll.offer("ȫ�浿");
		ll.offer(new String("�������"));
		ll.offer(String.valueOf(1234));
		ll.offer(5678+"");
		
		System.out.println("size->"+ll.size());
		//��ü ������
		//String data = ll.pop();// ���Ͼտ��ִ� ��ü�� ������� �÷��ǿ����� ��������.
		//System.out.println("data="+ data);
		//System.out.println("size---->"+ll.size());
		
		//true :�÷��ǿ� ��ü�� ����.  false:�÷��ǿ� �����ִ� ��ü�� �ִ�.
		while(ll.isEmpty()) {// ��ü�� ������
			String data = ll.pop();
			int cnt = ll.size();
			System.out.println(data+", ������ü��="+cnt);
			
		}
	}

	public static void main(String[] args) {
		new LinkedListTest();
	}

}
