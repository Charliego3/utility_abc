package org.github.lambda;

@FunctionalInterface
public interface Consumer<T, E extends Throwable> {

    void accept(T t) throws E;

}
