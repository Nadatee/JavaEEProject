import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import beans.FigiLocal;
import domain.FigiData;

@Named()
@RequestScoped
public class OpenFigiControl  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB private FigiLocal<FigiData> ejb;

	@Inject OpenFigiModel model;
	
	public List<FigiData> search() {
		List<FigiData> data = new ArrayList<FigiData>();
		
		model.setPaperID(model.getPaperID());
		System.out.println("PaperID - Currency: " + model.getPaperID().getCurrency());
		List<FigiData> figiData = ejb.openFigi(model.getPaperID().getIdType(), model.getPaperID().getIdValue(), model.getPaperID().getCurrency(), model.getPaperID().getMicCode());
//		List<FigiData> figiData = ejb.openFigi(model.getPaperID().getIdType(), model.getPaperID().getIdValue(), null, null);

		model.setFigiData(figiData);
		model.setPaper(model.getPaper());
		
		data = model.getFigiData();	
		for(FigiData info: data) {
			model.setPaper(info.getData());
			System.out.println(info.toString());
		}
		
		model.setShowTable(true);
		
		return data;
	}


}
