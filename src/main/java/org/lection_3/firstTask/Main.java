package org.lection_3.firstTask;

import org.lection_3.firstTask.CheckObject.Card;
import org.lection_3.firstTask.CheckObject.CheckObj;
import org.lection_3.firstTask.Devices.IPhone;
import org.lection_3.firstTask.Devices.Phone;

public class Main {
    public static void main(String[] args) {
        CheckObj card = new Card(1234123412341234L, 123L);
        PayMethod terminal = new Terminal();
        Phone iphone = new IPhone(1000);
        System.out.println(iphone.replenishment(card, terminal, 500));
    }
}
