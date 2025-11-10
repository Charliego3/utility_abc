package org.github.lambda;

import java.util.Objects;

/**
 * lambda 受检异常再次抛出，不用捕获
 */
public class Lambdas {

    /**
     * Example:
     * .map(uncheck(name -> System.out.println(Class.forName(name))));
     *
     * @param consumer 消费者模型
     * @param <T>      入参类型
     * @param <E>      异常类型
     * @return 不受检消费者
     */
    public static <T, E extends Throwable> java.util.function.Consumer<T> uncheck(Consumer<T, E> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Throwable e) {
                throwAsUnchecked(e);
            }
        };
    }

    /**
     * Example:
     * {@code .forEach(uncheck((clazz, method) -> System.out.println(clazz.getDeclaredMethod(method).toString())));}
     *
     * @param consumer 双消费者模型
     * @param <T>      入参类型
     * @param <U>      入参类型
     * @param <E>      异常类型
     * @return 不受检消费者
     */
    public static <T, U, E extends Throwable> java.util.function.BiConsumer<T, U> uncheck(BiConsumer<T, U, E> consumer) {
        return (t, u) -> {
            try {
                consumer.accept(t, u);
            } catch (Throwable e) {
                throwAsUnchecked(e);
            }
        };
    }

    /**
     * Example:
     * {@code .map(uncheck(Class::forName));}
     *
     * @param function 函数模型
     * @param <T>      入参类型
     * @param <R>      出参类型
     * @param <E>      异常类型
     * @return 不受检函数模型
     */
    public static <T, R, E extends Throwable> java.util.function.Function<T, R> uncheck(Function<T, R, E> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Throwable e) {
                throwAsUnchecked(e);
                return null;
            }
        };
    }

    /**
     * Example:
     * {@code .map(uncheck((clazz, method) -> clazz.getDeclaredMethod(method)));}
     *
     * @param function 双函数模型
     * @param <T>      入参类型
     * @param <U>      入参类型
     * @param <R>      出参类型
     * @param <E>      异常类型
     * @return 不受检双函数模型
     */
    public static <T, U, R, E extends Throwable> java.util.function.BiFunction<T, U, R> uncheck(BiFunction<T, U, R, E> function) {
        return (t, u) -> {
            try {
                return function.apply(t, u);
            } catch (Throwable e) {
                throwAsUnchecked(e);
                return null;
            }
        };
    }

    /**
     * Example:
     * {@code .filter(test(name -> Objects.nonNull(Class.forName(name))));}
     *
     * @param predicate 断言模型
     * @param <T>       入参类型
     * @param <E>       异常类型
     * @return 不受检断言模型
     */
    public static <T, E extends Throwable> java.util.function.Predicate<T> test(Predicate<T, E> predicate) {
        return t -> {
            try {
                return predicate.test(t);
            } catch (Throwable e) {
                throwAsUnchecked(e);
                return false;
            }
        };
    }

    /**
     * Example:
     * {@code .filter(test((clazz, method) -> Objects.nonNull(clazz.getDeclaredMethod(method))));}
     *
     * @param predicate 双断言模型
     * @param <T>       入参类型
     * @param <U>       入参类型
     * @param <E>       异常类型
     * @return 不受检双断言模型
     */
    public static <T, U, E extends Throwable> java.util.function.BiPredicate<T, U> test(BiPredicate<T, U, E> predicate) {
        return (t, u) -> {
            try {
                return predicate.test(t, u);
            } catch (Throwable e) {
                throwAsUnchecked(e);
                return false;
            }
        };
    }

    /**
     * Example:
     * {@code .map(uncheck(() -> Class.forName("Invalid")));}
     *
     * @param supplier 提供者模型
     * @param <R>      出参类型
     * @param <E>      异常类型
     * @return 不受检提供者模型
     */
    public static <R, E extends Throwable> java.util.function.Supplier<R> uncheck(Supplier<R, E> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (Throwable e) {
                throwAsUnchecked(e);
                return null;
            }
        };
    }

    /**
     * Example:
     * {@code uncheck(() -> System.out.println(Class.forName("Invalid")));}
     *
     * @param runnable Runnable
     * @param <E>      异常类型
     */
    public static <E extends Throwable> java.lang.Runnable uncheck(Runnable<E> runnable) {
        return () -> {
            if (Objects.isNull(runnable)) {
                return;
            }

            try {
                runnable.run();
            } catch (Throwable e) {
                throwAsUnchecked(e);
            }
        };
    }

    @SuppressWarnings("unchecked")
    private static <E extends Throwable> void throwAsUnchecked(Throwable e) throws E {
        throw (E) e;
    }

}
