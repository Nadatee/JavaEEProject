package beans;
import java.io.IOException;
import java.net.URL;
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
import jpa.ExcelData;


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
    List<ExcelData> data = new LinkedList<ExcelData>();
    List<String> oldData = new LinkedList<String>();
    String text, oldText;
    
//	@Schedule(hour="*",minute="*",second="*/30")
//	@Schedule(hour="*",minute="*/10")
	
    
    
    
    public List<ExcelData> readExcel() throws IOException {
        String url = "https://openfigi.com/assets/local/exchange-code-mic-mapping.xls";
        URL exchange = new URL(url);
        Workbook wb = new HSSFWorkbook(exchange.openStream());
        Sheet sheet = wb.getSheetAt(0);
        ExcelData data = new ExcelData();
        List<ExcelData> information = new LinkedList<ExcelData>();
  
        for (Row row : sheet) {
          try {
//              if(row.getRowNum() == 0)  
//            	  row = sheet.getRow(1);
        	  if(row.getFirstCellNum() == 0 && row.getCell(0).toString() != "") {
                    data = new ExcelData();
                    data.setMic(row.getCell(0).toString().trim());
                    data.setOperatingMic(row.getCell(1).toString().trim());
                    data.setMicExchangeName(row.getCell(2).toString().trim());
                    data.setCorpExchange(row.getCell(3).toString().trim());
                    data.setEquityExchangeCode(row.getCell(4).toString().trim());
                    data.setEquityExchangeName(row.getCell(5).toString().trim());
                    data.setCompositeCode(row.getCell(6).toString().trim());
                    data.setIsoCountry(row.getCell(7).toString().trim());
                    entityManager.persist(data);
                }
         } catch (Exception e) {
              // TODO: handle exception
          }
 
            information.add(data);
            System.out.println(data.getMic());
        }
        wb.close();
        return information;
    }   
    
    public void create(ExcelData excelData) {
    	entityManager.persist(excelData);
    }
		    
    
//	public List<String> readExcel() throws IOException {
//		String url = "https://openfigi.com/assets/local/exchange-code-mic-mapping.xls";
//		URL exchange = new URL(url);
//		Workbook wb = new HSSFWorkbook(exchange.openStream());
//		Sheet sheet = wb.getSheetAt(0);
//		for (Row row : sheet) {
//			System.out.println("");
//			
//			for (Cell cell : row) {
//	            System.out.print(" - ");
//	            System.out.println("Test: " + cell.getRow());
//	            text = cell.getStringCellValue();
//	            if(!text.isEmpty() || text != null ) {
//	            	oldText = text;
//	            	 System.out.print("old text: " + oldText);
//	            }
//	            else 
//	            	text = oldText;
//	            
//	           // System.out.println(text);	           
//	            
//	            list.add(text);
//			}
//		}
//		wb.close();
//		return list;
//	}
    
        
        
}
