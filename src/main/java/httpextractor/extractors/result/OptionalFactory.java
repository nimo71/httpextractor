package httpextractor.extractors.result;

import httpextractor.extractors.Absent;
import httpextractor.extractors.Present;

public class OptionalFactory {
	
	@SuppressWarnings("unchecked")
	public static <T> Optional<T> fromNullable(T value) {
		if (value == null) 
			return (Optional<T>) Absent.INSTANCE;
		
		return new Present<T>(value);
	}
}
