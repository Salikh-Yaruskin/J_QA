package org.lection_1;


public interface Stealth<T> {
    boolean activateStealthMode(T t);

    boolean deactivateStealthMode(T t);
}
