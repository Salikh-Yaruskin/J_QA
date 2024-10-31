package org.lection_3.firstTask;

import org.lection_3.firstTask.CheckObject.CheckObj;

public abstract class PayMethod<T extends CheckObj>{
    boolean CheckBalance(int balance, int count){
        if (balance < 0)
            return false;
        return (balance - count) >= 0;
    }

    public abstract String transfer(T t, int balance ,int countMoney);
}
