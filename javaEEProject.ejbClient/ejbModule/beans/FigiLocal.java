package beans;

import java.util.List;

import javax.ejb.Local;


@Local
public interface FigiLocal<FigiData> {

	public List<FigiData> openFigi(); 
}
