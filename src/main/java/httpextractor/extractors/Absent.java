package httpextractor.extractors;

import httpextractor.extractors.result.Optional;
import httpextractor.extractors.result.Validity;

import com.google.common.base.Function;

public class Absent implements Optional<Object>, Validity<Object> {

	public static final Optional<Object> INSTANCE = new Absent();

	private Absent() {}
	
	public <V> Optional<V> transform(Function<? super Object, V> function) {
		throw new IllegalStateException("Cannot transform an absent object");
	}

	public boolean isPresent() {
		return false;
	}

	public Object get() {
		throw new IllegalStateException("Cannot get an absent object");
	}

	public boolean isValid() {
		return false;
	}

}
