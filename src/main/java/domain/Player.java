package domain;

import domain.enums.Palo;

import java.util.List;

public class Player {


    /*Card card1 = new Card(2, Palo.C);
    Card card2 = new Card(3, Palo.D);
    Card card3 = new Card(4, Palo.H);
    Card card4 = new Card(5, Palo.S);
    Card card5 = new Card(6, Palo.C);*/

    List<Card> cartas;

    public Player(List<Card> cartas) {
        this.cartas = cartas;
    }
}
