import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
	 * POI�ٿ�ε�
	 * jakarta.apache.org���� ���ʸ޴� poi�� �����Ѵ�
	 * 
	 * poi-bin-5.0.0-20210120.zip �ٿ�
	 * ������ Ǭ��
	 * poi-5.0.0.jar, commons-math3-3.6.1.jar build path�� �����Ѵ�.
	 * 
	 */
public class ExcelWrite {

	
	public ExcelWrite() {
		
	}
	//������ �����ϱ�
	public void start() {
		//1. workbook��ü�� ����
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//2. sheet��ü�� ����
		HSSFSheet sheet1 = workbook.createSheet();
		HSSFSheet sheet2 = workbook.createSheet("ȸ�����");//��Ʈ���� ȸ��������θ������
		
		//3. sheet�� �̿��ؼ� row��ü �����
		HSSFRow row = sheet2.createRow(0);//0,1,2,3,4 0���� ���Ѵٸ�
		//4. row�� �̿��ؼ� cell��ü ����� ���� ����
		row.createCell(0).setCellValue("��ȣ");
		row.createCell(1).setCellValue("�̸�");
		row.createCell(2).setCellValue("����ó");
		row.createCell(3).setCellValue("����");
		row.createCell(4).setCellValue("�����");
	
		//����� ���� �����Ͽ� ������ 
		HSSFRow row1 = sheet2.createRow(1);
		row1.createCell(0).setCellValue(100);
		row1.createCell(1).setCellValue("�ں���");
		row1.createCell(2).setCellValue("010-1234-5678");
		row1.createCell(3).setCellValue(25);
		row1.createCell(4).setCellValue(Calendar.getInstance());
		
		HSSFRow row2 = sheet2.createRow(2);
		row2.createCell(0).setCellValue(200);
		row2.createCell(1).setCellValue("�ڼ���");
		row2.createCell(2).setCellValue("010-1111-2222");
		row2.createCell(3).setCellValue(35);
		row2.createCell(4).setCellValue(Calendar.getInstance());
		
		HSSFRow row3 = sheet2.createRow(3);
		row3.createCell(0).setCellValue(300);
		row3.createCell(1).setCellValue("���ϱ�");
		row3.createCell(2).setCellValue("010-4545-5678");
		row3.createCell(3).setCellValue(40);
		row3.createCell(4).setCellValue(Calendar.getInstance());
		
		//5. ���Ϸ� ����
		File f = new File("D://testFile","member.xls");
		
		//1.���� �ƿ�ǲ��Ʈ�� 
		try {
			FileOutputStream fos = new FileOutputStream(f);
			
			//workbook�� write�޼ҵ带 ȣ���ϸ� ���Ϸ� ����
			workbook.write(fos);
			fos.close();
			workbook.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("������ ����Ϸ�");
		
		
	}
	public static void main(String[] args) {
		new ExcelWrite().start();;
	}
}
