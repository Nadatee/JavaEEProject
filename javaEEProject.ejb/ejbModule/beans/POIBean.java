package beans;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import domain.ExcelData;


/**
 * Session Bean implementation class POIBean
 */
@Stateless
@LocalBean


public class POIBean implements POIBeanRemote, POIBeanLocal<ExcelData> {

	@PersistenceContext private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public POIBean() {
        // TODO Auto-generated constructor stub
    }
    
    List<String> list = new LinkedList<String>();
    List<String> oldData = new LinkedList<String>();
    String text, oldText;
    
//	@Schedule(hour="*",minute="*",second="*/30")
//	@Schedule(hour="*",minute="*/10")
   
    
    
    public List<ExcelData> readExcel() throws IOException {
        String url = "https://openfigi.com/assets/local/exchange-code-mic-mapping.xls";
        URL exchange = new URL(url);
        Workbook wb = new HSSFWorkbook(exchange.openStream());
        Sheet sheet = wb.getSheetAt(0);
        int rowNumber = sheet.getLastRowNum()+1;
        ExcelData data = new ExcelData();
        List<ExcelData> information = new ArrayList<ExcelData>();
        String [] dataStr = new String[3];

        for(int i = 1; i < rowNumber; i++) {
          try {
        	  Row row = sheet.getRow(i);
 
        	  if(row.getFirstCellNum() == 0 && row.getCell(0) != null) {
                    data = new ExcelData();
                    data.setRowNumber(i);
                    data.setMic(row.getCell(0).toString().trim());
                    dataStr[0] = row.getCell(0).toString().trim();
                    
                    data.setOperatingMic(row.getCell(1).toString().trim());
                    dataStr[1] = row.getCell(1).toString().trim();
                    
                    data.setMicExchangeName(row.getCell(2).toString().trim());
                    dataStr[2] = row.getCell(2).toString().trim();
                    
                    data.setCorpExchange(row.getCell(3).toString().trim());
                    data.setEquityExchangeCode(row.getCell(4).toString().trim());
                    data.setEquityExchangeName(row.getCell(5).toString().trim());
                    data.setCompositeCode(row.getCell(6).toString().trim());
                    data.setIsoCountry(row.getCell(7).toString().trim());
                    entityManager.persist(data);
                }
        	  else {
        		  data = new ExcelData();
        		  data.setRowNumber(i);
        		  data.setMic(dataStr[0]);
                                   
                  data.setOperatingMic(dataStr[1]);
                                    
                  data.setMicExchangeName(dataStr[2]);
                  data.setCorpExchange(row.getCell(3).toString().trim());
                  data.setEquityExchangeCode(row.getCell(4).toString().trim());
                  data.setEquityExchangeName(row.getCell(5).toString().trim());
                  data.setCompositeCode(row.getCell(6).toString().trim());
                  data.setIsoCountry(row.getCell(7).toString().trim());
                  entityManager.persist(data);
        	  }
         } catch (Exception e) {
              // TODO: handle exception
        	 e.printStackTrace();
          }
 
            information.add(data);
            System.out.println(data.toString());
        }
        System.out.println("row number is:" + rowNumber);
        wb.close();
        return information;
    }       
    
}
