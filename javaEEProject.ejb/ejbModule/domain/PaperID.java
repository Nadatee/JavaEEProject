package domain;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class PaperID {

	String idType , idValue, currency, micCode;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMicCode() {
		return micCode;
	}

	public void setMicCode(String micCode) {
		this.micCode = micCode;
	}
	
	public String toJson() {
		JsonObjectBuilder builder = Json.createObjectBuilder()
			.add("idType", this.idType)
			.add("idValue", this.idValue);
		if(currency != null) 
			builder.add("currency", this.currency);
				
		if(micCode != null) 
			builder.add("micCode", this.micCode);	
		
		return Json.createArrayBuilder().add(builder).build().toString();
	}		 
}
