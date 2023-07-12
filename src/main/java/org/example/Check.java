package org.example;
@FunctionalInterface
public interface Check<T, R> {
    R checkValue(T t1, T t2);

}
