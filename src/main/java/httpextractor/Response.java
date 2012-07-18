package httpextractor;

public interface Response {
	
	public String contentType();

	void apply(Responder responder); 
}
