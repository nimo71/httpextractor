package httpextractor.extractors;


public class Valid<T> implements Validity<T> {
	private T value;

	public Valid(T value) {
		if (value == null) throw new IllegalStateException("Null values are not valid");
		this.value = value;
	}

	public boolean isPresent() {
		return true;
	}

	public T get() {
		return value;
	}

	public boolean isValid() {
		return true;
	}

}
