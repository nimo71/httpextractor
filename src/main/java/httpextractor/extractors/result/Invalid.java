package httpextractor.extractors.result;


public class Invalid<T> implements Validity<T> {
	
	private final String invalidValue;

	public Invalid(String invalidValue) {
		this.invalidValue = invalidValue;
	}

	@Override
	public boolean isPresent() {
		return true;
	}

	@Override
	public T get() {
		throw new IllegalStateException("Cannot get an invalid value");
	}

	@Override
	public boolean isValid() {
		return false;
	}
	
	@Override
	public String toString() {
		return this.invalidValue;
	}
}
