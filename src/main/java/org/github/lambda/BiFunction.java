package org.github.lambda;

@FunctionalInterface
public interface BiFunction<T, U, R, E extends Throwable> {

    R apply(T t, U u) throws E;

}
