package beans;
import java.io.IOException;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 * Session Bean implementation class POIBean
 */
@Stateless
@LocalBean

public class POIBean implements POIBeanRemote, POIBeanLocal {

    /**
     * Default constructor. 
     */
    public POIBean() {
        // TODO Auto-generated constructor stub
    }
    
//	@Schedule(hour="*",minute="*",second="*/30")
//	@Schedule(hour="*",minute="*/10")
	public void readExcel() throws IOException {
		String url = "https://openfigi.com/assets/local/exchange-code-mic-mapping.xls";
		URL exchange = new URL(url);
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

	}

}
