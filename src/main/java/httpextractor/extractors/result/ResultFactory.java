package httpextractor.extractors.result;


public class ResultFactory {

	public static <T> Optional<T> present(T value) {
		return new Present<T>(value);
	}
	
	public static <T> Optional<T> fromNullable(T value) {
		if (value == null) 
			return absent();
		
		return present(value);
	}

	@SuppressWarnings("unchecked")
	public static <T> Optional<T> absent() {
		return (Validity<T>) Absent.INSTANCE;
	}

	public static <T> Validity<T> valid(T valid) {
		return new Valid<T>(valid);
	}
}
