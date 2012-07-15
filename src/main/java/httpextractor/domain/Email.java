package httpextractor.domain;

public class Email {
	private String addr;

	public Email(String emailString) {
		addr = emailString;
	}
	
	public String toString() {
		return addr;
	}

}
