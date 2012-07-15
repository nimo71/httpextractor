package httpextractor.extractors;


public class Invalid<T> implements Validity<T> {

	public String errorValue;
	
	public Invalid(String errorValue) {
		this.errorValue = errorValue;
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
	
	public String getInvalidValue() {
		return errorValue;
	}

}
