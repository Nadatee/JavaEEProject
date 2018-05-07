import domain.ExcelData;
import domain.Paper;

public class PaperWithMicInfo {

	private int id;
	private Paper paper;
	private ExcelData excelData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public ExcelData getExcelData() {
		return excelData;
	}

	public void setExcelData(ExcelData excelData) {
		this.excelData = excelData;
	}

	@Override
	public String toString() {
		return "PaperWithMicInfo [id=" + id + ", paper=" + paper + ", excelData=" + excelData + "]";
	}	
}
