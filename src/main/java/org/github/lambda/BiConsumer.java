package org.github.lambda;

@FunctionalInterface
public interface BiConsumer<T, U, E extends Throwable> {

    void accept(T t, U u) throws E;

}
