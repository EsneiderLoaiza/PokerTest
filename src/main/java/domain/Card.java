package domain;

import domain.enums.Palo;

public class Card {

    private int valorCarta;
    private Palo palo;

    public Card(int valorCarta, Palo palo) {
        this.valorCarta = valorCarta;
        this.palo = palo;
    }

    public Card() {
        super();
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }
}
