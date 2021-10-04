package domain;

import domain.enums.Palo;

public class Player {


    Card card1 = new Card(2, Palo.C);
    Card card2 = new Card(3, Palo.D);
    Card card3 = new Card(4, Palo.H);
    Card card4 = new Card(5, Palo.S);
    Card card5 = new Card(6, Palo.C);

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    public Card getCard4() {
        return card4;
    }

    public void setCard4(Card card4) {
        this.card4 = card4;
    }

    public Card getCard5() {
        return card5;
    }

    public void setCard5(Card card5) {
        this.card5 = card5;
    }
}
