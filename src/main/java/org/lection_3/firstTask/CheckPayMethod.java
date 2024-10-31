package org.lection_3.firstTask;

import org.lection_3.firstTask.CheckObject.CheckObj;

public interface CheckPayMethod<T extends CheckObj> {
    boolean check(T t);
}
