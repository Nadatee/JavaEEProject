package beans;

import java.io.IOException;
import java.util.List;
import javax.ejb.Local;

import domain.ExcelData;

@Local
public interface POIBeanLocal<ExcelData> {

	public List<ExcelData> readExcel() throws IOException;	
	
	public ExcelData getExcelDataFromDB(String isoCountry);
	
	public List<ExcelData> getExcelDataDB();
	
	public void deleteExcelDataFromDB(List<ExcelData> excelDataList);
}
