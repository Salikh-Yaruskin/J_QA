package org.lection_3.thirdTask;

public class Main {
    public static void main(String[] args) {
        ReturnThreeNumber<Double, Double, Double> returnThreeNumber = (a, b, c) -> Math.pow(b, 2) - (4*a*c);

        System.out.println(returnThreeNumber.returnOne(3.0,7.0, -6.0));
    }
}
