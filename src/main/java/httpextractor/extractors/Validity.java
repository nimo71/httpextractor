package httpextractor.extractors;


public interface Validity<T> extends Optional<T> {

	public boolean isValid();
}
