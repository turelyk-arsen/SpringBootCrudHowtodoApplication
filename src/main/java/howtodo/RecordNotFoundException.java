package howtodo;

public class RecordNotFoundException extends Exception {
    
	public String mes;
	
	public RecordNotFoundException (String mes) {
		this.mes = mes;
	}
}
