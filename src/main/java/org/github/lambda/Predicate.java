package org.github.lambda;

@FunctionalInterface
public interface Predicate<T, E extends Throwable> {

    boolean test(T t) throws E;

}
