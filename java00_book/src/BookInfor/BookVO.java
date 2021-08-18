package BookInfor;

public class BookVO {
	private String code;
	private String bookName; //å�̸�
	private String author; // ����
	private String company;//ȸ��
	private String rental;// �뿩����
	private String rentaldate;//�뿩��¥
	 
	
	
	public BookVO() {  	
	}
	
	public BookVO(String code, String bookName,String author,String company,String rental,String rentaldate ) {
		this.code = code;
		this.bookName = bookName;
		this.author = author;
		this.company = company;
		this.rental = rental;
		this.rentaldate = rentaldate;
	}
	//public void bookPrint() {
		//System.out.printf("%d %10s %10s %10s %10s %12s\n",code,bookName,author,company,rental,rentaldate);
	//}
	
	public void bookPrint(BookVO oneBook) {
	String codePattern = setFiftyLetters(checkKorean(oneBook.getCode()));
	String bookNamePattern = setFiftyLetters(checkKorean(oneBook.getBookName()));
	String authorPattern = setFiftyLetters(checkKorean(oneBook.getAuthor()));
	String companyPattern = setFiftyLetters(checkKorean(oneBook.getCompany()));
	String rentalPattern = setFiftyLetters(checkKorean(oneBook.getRental()));
	String rentaldatePattern = setFiftyLetters(checkKorean(oneBook.getRentaldate()));
	
	System.out.printf(codePattern, oneBook.getCode());
	System.out.printf(bookNamePattern, oneBook.getBookName());
	System.out.printf(authorPattern, oneBook.getAuthor());
	System.out.printf(companyPattern, oneBook.getCompany());
	System.out.printf(rentalPattern, oneBook.getRental());
	System.out.printf(rentaldatePattern, oneBook.getRentaldate());
	System.out.println();
	}
	
	
	
	public static int checkKorean(String korean) {
		char[] charArray = korean.toCharArray();
		int realLength = charArray.length;
		for(int i=0; i<charArray.length; i++) {
			if(charArray[i] > 127) {
				realLength++;
			}
		}
		return realLength;
	}
	
	public static String setFiftyLetters(int realLength) {
		int space = 15 - realLength;
		String spaceStr = "";
		for(int i=0; i<space; i++) {
			spaceStr += " ";
		}
		String pattern = "%s" + spaceStr;
		return pattern;
	}
	
	
	
	
	
	//Ÿ��Ʋ ���
	public static void titlePrint() {
		System.out.printf("%s %10s %10s %11s %11s %10s\n","�����ڵ�","å�̸�","����","���ǻ�","���Ի���","����");
		System.out.println("==================================================================================");
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRental() {
		return rental;
	}
	public void setRental(String rental) {
		this.rental = rental;
	}
	public String getRentaldate() {
		return rentaldate;
	}
	public void setRentaldate(String rentaldate) {
		this.rentaldate = rentaldate;
	}
}


