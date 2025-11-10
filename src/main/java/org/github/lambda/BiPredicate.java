package org.github.lambda;

@FunctionalInterface
public interface BiPredicate<T, U, E extends Throwable> {

    boolean test(T t, U u) throws E;

}
