import java.io.Serializable;

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
}
