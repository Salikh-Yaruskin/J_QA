package org.lection_3.firstTask;

import org.lection_3.firstTask.CheckObject.Card;

public class Terminal extends PayMethod<Card> {
    private CardValidator validator;

    public Terminal() {
        this.validator = new CardValidator();
    }

    @Override
    public String transfer(Card card, int balance, int countMoney) {
        if (validator.check(card) && CheckBalance(balance, countMoney)) {
            int answer = balance - countMoney;
            return String.valueOf(answer);
        }
        return "Error";
    }
}

class CardValidator {
    public boolean check(Card card) {
        long num = String.valueOf(card.getNumberCard()).length();
        long cvv = String.valueOf(card.getCVV()).length();
        if(num == 16 && cvv == 3){
            return true;
        }
        System.out.println("Формат вашей карты не соответствует правильному!");
        return false;
    }
}
