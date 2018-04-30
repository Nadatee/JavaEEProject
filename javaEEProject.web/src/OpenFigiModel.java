import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import domain.FigiData;
import domain.Paper;
import domain.PaperID;

@Named
@RequestScoped
public class OpenFigiModel implements Serializable {

	private static final long serialVersionUID = 1L;	

	private PaperID paperID = new PaperID();

	private List<FigiData> figiData = new ArrayList<FigiData>();
	
	private List<Paper> paper = new ArrayList<Paper>();
	
	private boolean showTable = false;

	public boolean isShowTable() {
		return showTable;
	}

	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
	}

	public List<Paper> getPaper() {
		return paper;
	}

	public void setPaper(List<Paper> paper) {
		this.paper = paper;
	}

	public List<FigiData> getFigiData() {
		return figiData;
	}

	public void setFigiData(List<FigiData> figiData) {
		this.figiData = figiData;
	}

	public PaperID getPaperID() {
		return paperID;
	}

	public void setPaperID(PaperID paperID) {
		this.paperID = paperID;
	}
}
