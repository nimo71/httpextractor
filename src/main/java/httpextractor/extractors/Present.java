package httpextractor.extractors;


import httpextractor.extractors.result.Optional;
import httpextractor.extractors.result.OptionalFactory;

import com.google.common.base.Function;

public class Present<T> implements Optional<T> {
	private final T value; 
	
	public Present(T value) {
		if (value == null) throw new IllegalStateException("Present cannot have null value");
		this.value = value;
	}

	public <V> Optional<V> transform(Function<? super T, V> function) {
		V transformed = function.apply(value);
		return OptionalFactory.fromNullable(transformed);
	}

	public boolean isPresent() {
		return true;
	}

	public T get() {
		return value;
	}

	public Optional<T> absent() {
		throw new IllegalStateException("Present values are not absent");
	}

}
