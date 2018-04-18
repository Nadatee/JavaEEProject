package beans;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

@Local
public interface POIBeanLocal {

	public List<String> readExcel() throws IOException;
}
