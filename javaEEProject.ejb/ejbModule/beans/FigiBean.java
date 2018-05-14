package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import domain.FigiData;
import domain.PaperID;

/**
 * Session Bean implementation class FigiBean
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@RolesAllowed("role1")
public class FigiBean implements FigiRemote, FigiLocal<FigiData> {

	String PATH = "https://api.openfigi.com/v1/mapping";
	@Resource private SessionContext ctx;
	
	
	public FigiBean() {
	}
	
	@Override
	@RolesAllowed("role1")
	public List<FigiData> openFigi(String idType, String idValue, String currency, String micCode ) {
		
		List<FigiData> data = new ArrayList<FigiData>();
		PaperID paperID = new PaperID();
		System.out.println("Fra FigiBean idType: " + idType);
				
		paperID.setIdType(idType);
		paperID.setIdValue(idValue);
		paperID.setCurrency(currency);
		paperID.setMicCode(micCode);
		
		data = getPapersFromFigi(paperID);
		return data;
	    
	}

	private List<FigiData> getPapersFromFigi(PaperID paperID) {
				
		Client client = ClientBuilder.newClient();
		List<FigiData> data = client.target(PATH).request("text/json").post(Entity.entity(paperID.toJson(), "text/json"),
				new GenericType<List<FigiData>>() {
				});
		client.close();
		return data;
	}

//	private List<MicExchange> getMicExchanges(List<PaperID> paperIDs, List<FigiData> data) {
//		
//    	List<MicExchange> micExchanges = new ArrayList<MicExchange>();
//    	for(int i = 0; i<paperIDs.size(); i++) {
//    		String mic = paperIDs.get(i).getMicCode();
//	    	for(Paper paper : data.get(i).getPapers()) {
//	    		if(paper.getExchCode() != "") {    			
//	    			micExchanges.add(new MicExchange(mic, paper.getExchCode()));
//	    		}  
//	    		else {
//		    		micExchanges.add(new MicExchange(mic, data.get(i).getError()));
//		    	}
//	    	}
//    	}
//    	return micExchanges;
//    }	
	
}
