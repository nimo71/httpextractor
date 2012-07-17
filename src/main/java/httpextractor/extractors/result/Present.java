package httpextractor.extractors.result;



public class Present<T> implements Optional<T> {
	private final T value; 
	
	public Present(T value) {
		if (value == null) throw new IllegalStateException("Present cannot have null value");
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
	public String toString() {
		return value.toString();
	}
}
