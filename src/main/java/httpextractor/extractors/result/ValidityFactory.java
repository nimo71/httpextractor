package httpextractor.extractors.result;

import httpextractor.extractors.Absent;

public class ValidityFactory {

	@SuppressWarnings("unchecked")
	public static <T> Validity<T> absent() {
		return (Validity<T>) Absent.INSTANCE;
	}

}
