package beans;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			String url = "https://openfigi.com/assets/local/exchange-code-mic-mapping.xls";
			URL exchange;
			try {
				exchange = new URL(url);
				Workbook wb = new HSSFWorkbook(exchange.openStream());
				Sheet sheet = wb.getSheetAt(0);
				for (Row row : sheet) {
					System.out.println("");
					for (Cell cell : row) {
			            System.out.print(" - ");
			            String text = cell.getStringCellValue();
			            System.out.print(text);
					}
				}
				
				wb.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		
	}

}
