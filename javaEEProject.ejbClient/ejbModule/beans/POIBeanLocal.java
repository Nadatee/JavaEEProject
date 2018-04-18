package beans;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;


@Local
public interface POIBeanLocal<ExcelData> {

	public List<ExcelData> readExcel() throws IOException;
	
	public void create(ExcelData excelData);
}
