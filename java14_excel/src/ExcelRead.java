import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelRead {

	public ExcelRead() {
		
	}
	public void start() {
		try {
			File file = new File("D://testFile","member.xls");
			FileInputStream fis = new FileInputStream(file);
			
			//byteCode�� InputStream�� excel ���Ϸ� ��ȯ�ϴ� Ŭ����
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			
			//1.workbook ��ü ������
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			
			//��Ʈ�� �� ���ϱ�
			int sheetCnt =workbook.getNumberOfSheets();
			System.out.println("��Ʈ�� = "+ sheetCnt);
			
			//2. sheet��ü ������
			
			HSSFSheet sheet = workbook.getSheet("ȸ�����");//workbook.getSheetAt(1)
			//���� �� ���ϱ�
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("���Ǽ� = " + rowCount);
			
			//����
			System.out.println("��ȣ\t�̸�\t����ó\t\t����\t�����");
			
			for(int rowIdx=1;rowIdx<rowCount;rowIdx++) {//1,2,3
				//3. �ఴü�� ���ϱ� 
				HSSFRow row = sheet.getRow(rowIdx);
				
				//���� ���ϱ�
				int cellCount = row.getPhysicalNumberOfCells();
				//System.out.println("���Ǽ� = " + cellCount);
				for(int cellIdx =0;cellIdx<cellCount;cellIdx++) {//0,1,2,3,4
					 HSSFCell cell = row.getCell(cellIdx);
					 //��ȣ, ����
					 if(cellIdx==0 || cellIdx==3) {
						 int data = (int)cell.getNumericCellValue(); 
						 System.out.print(data+"\t");
					 //�̸�, ����ó
					 }else if(cellIdx==1 || cellIdx==2) {
						 String data = cell.getStringCellValue();
						 System.out.print(data+"\t");
					 //�����
					 }else if(cellIdx==4) {//�����
						 Date date = cell.getDateCellValue();
						 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						 String dateStr = format.format(date);
						 System.out.println(dateStr);	 
					 }
				}
				//System.out.println();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ExcelRead().start();

	}
}
