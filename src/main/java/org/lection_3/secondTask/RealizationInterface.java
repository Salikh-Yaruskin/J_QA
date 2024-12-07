package org.lection_3.secondTask;

public class RealizationInterface {
    public static void main(String[] args) {
        OnlyReturn<Integer> onlyReturn = x -> x % 13 == 0;
        int firstNum = 13;
        int secondNum = 15;
        System.out.println(onlyReturn.returnNum(firstNum));
        System.out.println(onlyReturn.returnNum(secondNum));
    }
}
