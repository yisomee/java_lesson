import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack= new Stack<String>();
		//stack�� �����Էµ� ������ ���߿� ��µȴ�. (FILO:frist in last out)
		//queue: first in first out
		// push(): �Է�, pop(): ��fur
		
		stack.push("ȫ�浿");
		stack.push("�������");
		stack.push("�̼���");
		stack.push("������");
		
		// empty() : stack��ü ������ false, ��ü�� ������ true
		while(!stack.empty()) {
			String name = stack.pop();
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
