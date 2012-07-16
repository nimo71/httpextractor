package httpextractor.extractors.result;



public interface Optional<T> {

	boolean isPresent();

	T get();

}
