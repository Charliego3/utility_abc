package org.github.lambda;

@FunctionalInterface
public interface Function<T, R, E extends Throwable> {

    R apply(T t) throws E;

}
