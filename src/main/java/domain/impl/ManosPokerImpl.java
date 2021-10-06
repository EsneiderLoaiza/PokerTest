package domain.impl;

import domain.Card;
import domain.Player;
import domain.interfaces.IManosPoker;


public class ManosPokerImpl implements IManosPoker {


    public String cartaAlta(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = countCartas(cardsPlayer1, player1);
        int player2Value = countCartas(cardsPlayer2, player2);

         if(player1Value > player2Value) {
            return "Jugador 1 gana por carta alta";
         }
        return "Jugador 2 gana por carta alta";
    }

    public int countCartas(Card[] cartas, Player player){
        int totalValue = 0;
        int totalValuePalo = 0;
        for(int i=0; i<5; i++) {
            totalValue = totalValue + cartas[i].getValorCarta() + cartas[i].getPalo().getPaloValue();
            //totalValuePalo = totalValuePalo + cartas[i].getPalo().getPaloValue();
        }
        return  totalValue;
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
