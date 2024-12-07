package org.lection_3.secondTask;

@FunctionalInterface
public interface OnlyReturn<T extends Number> {
    boolean returnNum(int count);
}
