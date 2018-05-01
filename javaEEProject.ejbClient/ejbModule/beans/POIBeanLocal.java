package beans;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

@Local
public interface POIBeanLocal<ExcelData> {

	public List<ExcelData> readExcel() throws IOException;	
	
	public Optional<ExcelData> read(String isoCountry);
}
