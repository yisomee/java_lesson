package BookInfor;

import java.util.HashMap;

public class BookDataSet {
		public static HashMap<String, BookVO> bookList = new HashMap<String, BookVO>();
		
		public BookDataSet() {
			 
		}
		
			public static void basicBookSet() {
				bookList.put("그렇게그렇게", new BookVO("1001", "그렇게그렇게" ,"양지연","주니어김영사","구입가능","500"));
				bookList.put("달팽이", new BookVO("1002", "달팽이" ,"김민우","웅진주니어","구입가능","500"));
				bookList.put("산책", new BookVO("1003", "산책" ,"손현경","비밀신서","구입가능","400"));
				bookList.put("집과산책", new BookVO("1005", "집과산책" ,"김화요","웅진주니어","구입가능","300"));
				bookList.put("여행의이유", new BookVO("1006", "여행의이유" ,"김영하","문학동네","구입가능","700"));
				bookList.put("밥보다여행", new BookVO("1007", "밥보다여행" ,"이상정","책밥상","구입가능","800"));
				bookList.put("내가모르는", new BookVO("1008", "내가모르는" ,"김화요","웅진주니어","구입가능","300"));
				bookList.put("티타임", new BookVO("1009", "티타임" ,"정서진","따비","구입가능","300"));
				
			
		}
}
