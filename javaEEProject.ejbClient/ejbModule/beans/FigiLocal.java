package beans;

import java.util.List;
import javax.ejb.Local;

@Local
public interface FigiLocal<FigiData> {
	
	public List<FigiData> openFigi(String idType, String idValue, String currency, String micCode); 
}
