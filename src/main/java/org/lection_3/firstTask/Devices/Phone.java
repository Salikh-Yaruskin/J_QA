package org.lection_3.firstTask.Devices;

import org.lection_3.firstTask.CheckObject.CheckObj;
import org.lection_3.firstTask.PayMethod;

public interface Phone<T extends PayMethod, V extends CheckObj> {
    int replenishment(V v, T payMethod, int payment);
}
