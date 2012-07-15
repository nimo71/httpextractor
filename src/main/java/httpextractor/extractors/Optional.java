package httpextractor.extractors;



public interface Optional<T> {

	boolean isPresent();

	T get();

}
