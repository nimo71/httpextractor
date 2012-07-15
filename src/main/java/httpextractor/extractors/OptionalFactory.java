package httpextractor.extractors;

public class OptionalFactory {
	
	@SuppressWarnings("unchecked")
	public static <T> Optional<T> fromNullable(T value) {
		return (value == null) ? 
				(Optional<T>) Absent.INSTANCE :
					new Present<T>(value);
	}
}
