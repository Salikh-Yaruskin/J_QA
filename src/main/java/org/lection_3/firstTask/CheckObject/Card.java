package org.lection_3.firstTask.CheckObject;

public class Card implements CheckObj{
    private long numberCard;
    private long CVV;

    public Card(long numberCard, long CVV){
        this.numberCard = numberCard;
        this.CVV = CVV;
    }

    public long getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }
}
