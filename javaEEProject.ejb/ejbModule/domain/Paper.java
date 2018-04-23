package domain;

public class Paper {

	String figi;
	String securityType;
	String marketSector;
	String ticker;
	String name;
	String uniqueID;
	String exchCode;
	String shareClassFIGI;
	String compositeFIGI;
	String securityType2;
	String securityDescription;
	String uniqueIDFutOpt; 
	String metadata;
    public String getMetaData() {
		return metadata;
	}
	
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	String error;
    
	public String getFigi() {
		return figi;
	}
	
	public void setFigi(String figi) {
		this.figi = figi;
	}
	
	public String getSecurityType() {
		return securityType;
	}
	
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	
	public String getMarketSector() {
		return marketSector;
	}
	
	public void setMarketSector(String marketSector) {
		this.marketSector = marketSector;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getExchCode() {
		return exchCode;
	}
	public void setExchCode(String exchCode) {
		this.exchCode = exchCode;
	}
	
	public String getShareClassFIGI() {
		return shareClassFIGI;
	}
	
	public void setShareClassFIGI(String shareClassFIGI) {
		this.shareClassFIGI = shareClassFIGI;
	}
	public String getCompositeFIGI() {
		return compositeFIGI;
	}
	
	public void setCompositeFIGI(String compositeFIGI) {
		this.compositeFIGI = compositeFIGI;
	}
	public String getSecurityType2() {
		return securityType2;
	}
	public void setSecurityType2(String securityType2) {
		this.securityType2 = securityType2;
	}
	public String getSecurityDescription() {
		return securityDescription;
	}
	public void setSecurityDescription(String securityDescription) {
		this.securityDescription = securityDescription;
	}
	public String getUniqueIDFutOpt() {
		return uniqueIDFutOpt;
	}
	public void setUniqueIDFutOpt(String uniqueIDFutOpt) {
		this.uniqueIDFutOpt = uniqueIDFutOpt;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}  
	
	@Override 
	public String toString() {
		return ("data:[\n \"figi: " + figi + "\n \"securityType: " + securityType + "\n \"marketSector: " + marketSector + 
				"\n \"ticker: " + ticker + "\n \"name: " + name + "\n \"uniqueID: " + uniqueID + "\n \"exchCode: " + exchCode +
				"\n \"shareClassFIGI: " + shareClassFIGI + "\n \"compositeFIGI: " + compositeFIGI + "\n \"securityType2: " + securityType2 + "\n \"securityDescription: " + securityDescription 
				+ "\n \"uniqueIDFutOpt: " + uniqueIDFutOpt + "\n \"metadata: " + metadata);					          
	}
}
