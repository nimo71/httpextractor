package httpextractor.extractors.result;



public class Present<T> implements Optional<T> {
	private final T value; 
	
	public Present(T value) {
		if (value == null) throw new IllegalStateException("Present cannot have null value");
		this.value = value;
	}

	public boolean isPresent() {
		return true;
	}

	public T get() {
		return value;
	}

	public Optional<T> absent() {
		throw new IllegalStateException("Present values are not absent");
	}

}
