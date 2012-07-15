package httpextractor.extractors;

public class ValidityFactory {

	@SuppressWarnings("unchecked")
	public static <T> Validity<T> absent() {
		return (Validity<T>) Absent.INSTANCE;
	}

}
