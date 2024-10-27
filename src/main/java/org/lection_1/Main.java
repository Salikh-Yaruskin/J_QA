package org.lection_1;

import static org.lection_1.BombClass.*;

public class Main {
    public static void main(String[] args) {
        Tank Tiger = new Tank("German", "Tiger", 123, 43, 100, "KwK 36", 5, 50);
        Tank T34 = new Tank("USSR", "T34", 321, 6, 60, "F-34", 3, 80);

        System.out.println("Общее количество созданных танков: " + Tank.getCountAllTank());

        Tiger.deploy();

        for (int i = 0; i < 6; i ++){
            T34.fire(Tiger);
        }

        System.out.println("------------------------------------------");

        Aircraft aircraft1 = new Aircraft("USSR", "K-12", 100, 1, 10, FRAGMENTATION);
        Aircraft aircraft2 = new Aircraft("USSR", "K-12", 100, 1, 10, FRAGMENTATION);

        aircraft2.takeOff();
        aircraft1.takeOff();
        System.out.println(Aircraft.getTotalAircraftInAir());
        aircraft1.fire(aircraft1);
        aircraft1.fire(aircraft1);
        aircraft1.replenishment(10);
        aircraft1.landing();
        aircraft1.takeOff();
        aircraft1.fire(aircraft1);
        System.out.println(Aircraft.getTotalAircraftInAir());
    }
}
