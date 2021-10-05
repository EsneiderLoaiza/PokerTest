package domain.impl;

import domain.Card;
import domain.Player;
import domain.interfaces.IManosPoker;


public class ManosPokerImpl implements IManosPoker {


    public String cartaAlta(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        int valuePlayer1 = countCartas(cardsPlayer1);
        int valuePlayer2 = countCartas(cardsPlayer1);
         if(cardsPlayer1[0].getValorCarta() == cardsPlayer1[0].getValorCarta()) {
            return "Prueba";
         }
        return "Prueba";
    }

    private int countCartas(Card[] cartas){
        return  1; //Cuenta cartas para sacar valor de cada mano
    }

    public String par(Player player1, Player player2) {
        if(player1.hand.equals(player2.hand)) {
            return cartaAlta(player1, player2);
        }
        return null;
    }

    public String dosPares(Player player1, Player player2) {
        if(player1.hand.equals(player2.hand)) {
            return cartaAlta(player1, player2);
        }
        return null;
    }
}
