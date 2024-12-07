package org.lection_3.firstTask.Devices;

import org.lection_3.firstTask.CheckObject.CheckObj;

public class IPhone<T extends org.lection_3.firstTask.PayMethod, V extends CheckObj> implements Phone<T, V> {

    private int balance;

    public IPhone(int balance){
        this.balance = balance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int replenishment(V v,T payMethod, int payment) {
        String result = payMethod.transfer(v, balance, payment);
        if (!result.equals("Error")) {
            balance -= payment;
            return balance;
        }
        return -1;
    }
}
