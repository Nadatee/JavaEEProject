package domain;

import java.util.List;

public class FigiData  {

	List<Paper> data;
	String error;
	
	public String getError() {				
		return error;		
	}	

	public List<Paper> getData() {
		return data;
	}

	public void setData(List<Paper> data) {
		this.data = data;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "FigiData [data=" + data + ", error=" + error + "]";
	}
	
}
