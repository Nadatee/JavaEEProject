package domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: ExcelData
 *
 */
@Entity

public class ExcelData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int rowNumber;

	@NotNull
	private String mic;

	@NotNull
	private String operatingMic;

	@NotNull
	private String micExchangeName;

	@NotNull
	private String corpExchange;

	@NotNull
	private String equityExchangeCode;

	@NotNull
	private String equityExchangeName;

	@NotNull
	private String compositeCode;

	@NotNull
	private String isoCountry;

	public ExcelData() {
		super();
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getMic() {
		return mic;
	}

	public void setMic(String mic) {
		this.mic = mic;
	}

	public String getOperatingMic() {
		return operatingMic;
	}

	public void setOperatingMic(String operatingMic) {
		this.operatingMic = operatingMic;
	}

	public String getMicExchangeName() {
		return micExchangeName;
	}

	public void setMicExchangeName(String micExchangeName) {
		this.micExchangeName = micExchangeName;
	}

	public String getCorpExchange() {
		return corpExchange;
	}

	public void setCorpExchange(String corpExchange) {
		this.corpExchange = corpExchange;
	}

	public String getEquityExchangeCode() {
		return equityExchangeCode;
	}

	public void setEquityExchangeCode(String equityExchangeCode) {
		this.equityExchangeCode = equityExchangeCode;
	}

	public String getEquityExchangeName() {
		return equityExchangeName;
	}

	public void setEquityExchangeName(String equityExchangeName) {
		this.equityExchangeName = equityExchangeName;
	}

	public String getCompositeCode() {
		return compositeCode;
	}

	public void setCompositeCode(String compositeCode) {
		this.compositeCode = compositeCode;
	}

	public String getIsoCountry() {
		return isoCountry;
	}

	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}

	@Override
	public String toString() {
		return ("ExcelData Mic = " + mic + " OperatingMic = " + operatingMic + " micExchangeName = " + micExchangeName
				+ " corpExchange = " + corpExchange + " equityExchangeCode=" + equityExchangeCode
				+ " equityExchangeName = " + equityExchangeName + " compositeCode = " + compositeCode + " isoCountry = "
				+ isoCountry);
	}
}
