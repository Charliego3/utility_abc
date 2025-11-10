package org.github.lambda;

@FunctionalInterface
public interface Supplier<R, E extends Throwable> {

    R get() throws E;

}
