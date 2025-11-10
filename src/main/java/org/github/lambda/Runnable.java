package org.github.lambda;

@FunctionalInterface
public interface Runnable<E extends Throwable> {

    void run() throws E;

}
