import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import domain.FigiData;
import domain.Paper;
import domain.PaperID;

@Named
@SessionScoped
public class OpenFigiModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private PaperID paperID = new PaperID();
	private List<FigiData> figiData = new ArrayList<FigiData>();
	private List<Paper> papers = new ArrayList<Paper>();
	private boolean showTable = false;
	private List<PaperWithMicInfo> papersWithMicInfo;
	private PaperWithMicInfo paperMic;
	
	public PaperWithMicInfo getPaperMic() {
		return paperMic;
	}

	public void setPaperMic(PaperWithMicInfo paperMic) {
		this.paperMic = paperMic;
	}

	public List<PaperWithMicInfo> getPapersWithMicInfo() {
		return papersWithMicInfo;
	}

	public void setPapersWithMicInfo(List<PaperWithMicInfo> papersWithMicInfo) {
		this.papersWithMicInfo = papersWithMicInfo;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	public boolean isShowTable() {
		return showTable;
	}

	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
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
