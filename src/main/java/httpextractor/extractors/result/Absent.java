package httpextractor.extractors.result;


public class Absent implements Validity<Object>, Optional<Object> {

	public static final Optional<Object> INSTANCE = new Absent();

	private Absent() {}

	@Override
	public boolean isPresent() {
		return false;
	}

	@Override
	public Object get() {
		throw new IllegalStateException("Cannot get an absent object");
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String toString() {
		return "";
	}
}
