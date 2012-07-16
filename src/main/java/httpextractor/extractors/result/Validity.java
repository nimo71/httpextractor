package httpextractor.extractors.result;


public interface Validity<T> extends Optional<T> {

	public boolean isValid();
}
