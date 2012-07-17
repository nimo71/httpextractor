package httpextractor.extractors.result;


public class Valid<T> implements Validity<T> {
	private final T value;

	public Valid(T value) {
		if (value == null) throw new IllegalStateException("Null values are not valid");
		this.value = value;
	}

	@Override
	public boolean isPresent() {
		return true;
	}

	@Override
	public T get() {
		return value;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
