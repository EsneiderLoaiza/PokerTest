package domain;

import domain.enums.Palo;
import domain.enums.ValueCard;

public class Card {

    private ValueCard valueCard;
    private Palo palo;

    public Card(ValueCard valueCard, Palo palo) {
        this.valueCard = valueCard;
        this.palo = palo;
    }

    public Card() {
        super();
    }

    public ValueCard getValueCard() {
        return valueCard;
    }

    public void setValueCard(ValueCard valueCard) {
        this.valueCard = valueCard;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }
}
