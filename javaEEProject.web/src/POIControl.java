import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import beans.POIBeanLocal;
import domain.ExcelData;

@Named()
@SessionScoped
public class POIControl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB private POIBeanLocal<ExcelData> poiLocal;
	@Inject POIModel poiModel;
	
	
	public ExcelData micInfo(String exchCode) {
		ExcelData excelData = new ExcelData();		
		
		excelData = poiLocal.getExcelDataFromDB(exchCode);
		return excelData;
	}
	
	public List<ExcelData> updateMicInfo() {
		List<ExcelData> excelDataList = new ArrayList<ExcelData>();	
		ExcelData excelData = new ExcelData();		
		excelDataList = poiLocal.getExcelDataDB();
		System.out.println("delete func: excelData =" + excelData.toString());
		if(!excelDataList.isEmpty()) {
			System.out.println("\n\n\n JEG ER KOMMET HERTIL \\n\\n\\n" );
			poiLocal.deleteExcelDataFromDB(excelDataList);
		}
		try {
			System.out.println("WHAT!!!!!!");
			excelDataList = poiLocal.readExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelDataList;
	}
}
