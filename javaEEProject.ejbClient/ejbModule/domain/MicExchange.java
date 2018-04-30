package domain;

public class MicExchange {

	String mic, exchCode, error;	
	
	public MicExchange(String mic, String exchCode) {
		this.mic = mic;
		if(exchCode != null)
			this.exchCode = exchCode;
		else 
			this.error = exchCode;
	}	
}
