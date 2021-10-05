package domain.impl;

import domain.Card;
import domain.Player;
import domain.interfaces.IManosPoker;


public class ManosPokerImpl implements IManosPoker {


    public String cartaAlta(Player player1, Player player2) {
         if(player1.hand == player2.hand) {
            return "Prueba";
         }
        return "Prueba";
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
