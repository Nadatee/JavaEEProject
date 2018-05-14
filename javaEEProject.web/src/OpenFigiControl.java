import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import beans.FigiLocal;
import domain.ExcelData;
import domain.FigiData;
import domain.Paper;

@Named()
@SessionScoped
public class OpenFigiControl  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB private FigiLocal<FigiData> ejb;
	@Inject OpenFigiModel model;
	@Inject POIControl poiControl;
	
	public List<FigiData> search() throws NullPointerException{
		List<FigiData> data = new ArrayList<FigiData>();
		List<Paper> papers = new ArrayList<Paper>();
		List<Paper> papersWithoutNullValues = new ArrayList<Paper>();
		List<PaperWithMicInfo> papersWithMic = new ArrayList<PaperWithMicInfo>();
		PaperWithMicInfo paperWithMic;
		ExcelData excelData = new ExcelData();
		List<ExcelData> excelDataList = new ArrayList<ExcelData>();
		List<Paper> paperList = new ArrayList<Paper>();
		List<FigiData> figiData = new ArrayList<FigiData>();
		
		try {
			model.setPaperID(model.getPaperID());		
			figiData = ejb.openFigi(model.getPaperID().getIdType(), model.getPaperID().getIdValue(), model.getPaperID().getCurrency(), model.getPaperID().getMicCode());

			model.setFigiData(figiData);

			int i = 0;	
		
			data = model.getFigiData();	
			for(FigiData info: data) {
				papers= info.getData();
				for(Paper paper: papers) {
					
					if(!paper.getExchCode().isEmpty() || paper.getExchCode() != null) {
						paperWithMic = new PaperWithMicInfo();
						papersWithoutNullValues.add(paper);
												
						excelData = poiControl.micInfo(paper.getExchCode());
						paperWithMic.setId(i++);
						paperWithMic.setPaper(paper);						
						paperWithMic.setExcelData(excelData);
												
						paperList.add(paper);						
						excelDataList.add(excelData);
						papersWithMic.add(paperWithMic);
						
					}
				}
			}
		} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					model.setShowTable(false);
		}				
		
		model.setPapers(papersWithoutNullValues);
		model.setPapersWithMicInfo(papersWithMic);		
		model.setShowTable(true);
		
		return data;
	}
	
//	public void addMicInfoToPaper(){
//		
//		List<PaperWithMicInfo> papersWithMic = model.getPapersWithMicInfo();
//		List<PaperWithMicInfo> papersWithMicList = new ArrayList<PaperWithMicInfo>();
//		PaperWithMicInfo mic = new PaperWithMicInfo();
//		for(PaperWithMicInfo paperMic: papersWithMic) {
//			System.out.println("Fuck it:" + paperMic.toString());
//			try {
//				if(model.getSelectedPaper().getExchCode() == paperMic.getPaper().getExchCode()) {					
//					mic.setPaper(paperMic.getPaper());
//					mic.setExcelData(paperMic.getExcelData());
//					papersWithMicList.add(mic);
//					//model.setPaperMic(mic);
//					model.setPapersWithMicInfo(papersWithMicList);
//					
//					System.out.println("Jeg var der:" + paperMic.toString());
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
//		}
//		//return mic;
//	}
	
	
//	public void micInfo() {
//		ExcelData excelData = new ExcelData();
//		
//		System.out.println("getMicInfo: ExchangeCode = " + model.getSelectedPaper().getExchCode());
//		excelData = poiControl.micInfo(model.getSelectedPaper().getExchCode());
//		
//		model.setPaperMic(new PaperWithMicInfo());
//		
//			PaperWithMicInfo paperWithMic = new PaperWithMicInfo();
//			paperWithMic.setId(1);
//			paperWithMic.setPaper(model.getSelectedPaper());
//			paperWithMic.setExcelData(excelData);
//			model.getPapersWithMicInfo().add(paperWithMic);
//		
//		System.out.println("MicInfo fun: " + excelData);
//		//return excelData;
//	}
}
