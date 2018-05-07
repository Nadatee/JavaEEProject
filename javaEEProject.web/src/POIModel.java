import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import domain.ExcelData;

@Named
@SessionScoped
public class POIModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ExcelData> excelDatas = new ArrayList<ExcelData>();
	private ExcelData excelData = new ExcelData();
	public ExcelData getExcelData() {
		return excelData;
	}

	public List<ExcelData> getExcelDatas() {
		return excelDatas;
	}

	public void setExcelDatas(List<ExcelData> excelDatas) {
		this.excelDatas = excelDatas;
	}

	public void setExcelData(ExcelData excelData) {
		this.excelData = excelData;
	}

	private String exchCode;

	public String getExchCode() {
		return exchCode;
	}

	public void setExchCode(String exchCode) {
		this.exchCode = exchCode;
	}	
}
