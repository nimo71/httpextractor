package httpextractor.extractors.result;


public class Invalid<T> implements Validity<T> {
	
	private final String invalidValue;

	public Invalid(String invalidValue) {
		this.invalidValue = invalidValue;
	}

	public boolean isPresent() {
		return true;
	}

	public T get() {
		throw new IllegalStateException("Cannot get an invalid value");
	}

	public boolean isValid() {
		return false;
	}
	
	public String getInvalid() {
		return this.invalidValue;
	}
}
