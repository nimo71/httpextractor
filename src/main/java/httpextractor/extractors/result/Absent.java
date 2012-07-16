package httpextractor.extractors.result;


public class Absent implements Optional<Object>, Validity<Object> {

	public static final Optional<Object> INSTANCE = new Absent();

	private Absent() {}

	public boolean isPresent() {
		return false;
	}

	public Object get() {
		throw new IllegalStateException("Cannot get an absent object");
	}

	public boolean isValid() {
		return false;
	}

	public String getInvalid() {
		throw new IllegalStateException("An absent object has no validity");
	}

}
