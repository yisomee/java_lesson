class Operator1 
{
	public static void main(String[] args) 
	{
		//������ : ���������, ����(��)������, ��������, ���׿�����, ���Կ�����, ����Ʈ������, ���׿�����
		//1. ��������� : +,-,*,/(��,�Ǽ�) ,%(������)

		int num1 = 10;
		int num2 = 3;

		int result = num1 % num2;
		System.out.println("result = " + result);


//�ϵ� - ������ �Űܼ� �����ϴµ�, ���� stack�̶�� ������ �����.
// ������ ����� �ϴµ�, ���� �ִ°��� ���°��� �ѱ��� �̴�. ������������ ..
// ������ ������ �ǾƷ��� ���⶧���� ���߿� �����Ÿ��� ���� �� �ִ�. 
// �������� �޸𸮶�� �� �� �ִ�.

// 2. ���׿����� : ++(1����), --(1����)
        int a = 10;
		a = a + 1;
      // ���ʰ� �������� ������ ���ƾ� �Ѵ�. a,a
	  System.out.println("a ="+ a);
      //a++ 1�����ϴ� ����
	  a++;
	  System.out.println("a = " + a);
      //--a; 1�����ϴ� ����   a = a-1;
	  --a;    
	  System.out.println("a = " + a);

	  int b = a++; //12�� �ƴ϶� b�� 11�̰� a�� 12�� �ȴ�. 
	  System.out.println("b="+b+", a ="+a);
	   int c = ++a; //c�� 13�� �ǰ�, a�� 13�� �ȴ�. 
	  System.out.println("c="+c+", a ="+a);

	  int result2 = b + c++; //11+13  c->14 ++�� ���� �켱�����̱� ����.
	  System.out.println("result="+result2+",c="+c); // 24,14

// 3. ���Կ�����
//a=13
//b=11
//c=14

       a += 4;  // a = a+4;  a += 1;  a=a+1;    17
	   b -= 3;  // b = b-3;       8
	   c *= 2;  // c = c*2;       28
	   System.out.println("a="+ a+"b ="+b+" c="+c);

	   c += a + b;  // c  = c + a + b;
	   System.out.println("c=" +c);



//�񱳿�����: >, >=, <, <=, ==, !=

	   int x = 200;
	   int y = 300;
	   boolean boo = x > y; // false
	   boolean boo2 = x <y; //true
	   System.out.println("boo="+boo);
	   System.out.println("boo2="+boo2);



//���׿����� 
// �޿��� ���� �̻��̸� ���ʽ��� 50%�� �ش�.
// �޿��� ���� �̸��̸� ���ʽ��� 90%�� �ش�.

      int sal = 9000; //�޿�
	  //   ��� = (���ǽ�)? ���϶� : �����϶�         
			   
  double bonus = (sal >=10000)? sal*0.5 : sal*0.9;
  System.out.println("sal=" +sal+", bonus="+bonus);


//�������� : &&(and), ||(or), !(not)

int ave = 75;
   String grade = (ave>=70  &&  ave<80)? "c" : "�׿�" ;
   System.out.println("grade="+grade);

   char ch = 'A'; //char������ �����ϴ�.
   //ch++;  ch+1;
   ch = (char)(ch + 1);   
   // �������� ���� . char = 2byte(65000) < int 4byte(�ø� 21��) 
   // ��Ʈ�� ��Ŀ�� ��Ʈ���� ĳ�������� ������ ������ ����. 
   // ����ȯ���� �����ϴ�. 
   System.out.println("ch"+ch);

   char ch2 = (char)85;
   System.out.println("Ch2=" + ch2);  //Ch2=U
   // �� Ch2=U �� �����ĸ� ���ۿ� �ƽ�Ű�ڵ带 �˻��ϸ�  85 �� u�̴�.
   // A = 65 a = 97, 





	  









	 





	}
}
