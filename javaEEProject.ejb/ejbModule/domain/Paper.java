package domain;

public class Paper {

	String idType;
	String idValue;
	String Currency;
	String MicCode;

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
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getMicCode() {
		return MicCode;
	}

	public void setMicCode(String micCode) {
		MicCode = micCode;
	}
}
