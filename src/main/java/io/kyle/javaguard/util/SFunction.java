package io.kyle.javaguard.util;

import java.io.Serializable;
import java.util.function.Function;

@FunctionalInterface
public interface SFunction<T,R> extends Function<T, R>, Serializable {
}
