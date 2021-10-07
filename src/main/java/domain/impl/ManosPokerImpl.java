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
        for(int i=0; i<5; i++) {
            totalValue = totalValue + cartas[i].getValorCarta() + cartas[i].getPalo().getPaloValue();
        }
        return  totalValue;
    }

    public int compareCards(Card[] cartas) {
        int previousValue = 0;
        int repeatedValue = 0;
        for(int i=0; i<5; i++) {
            previousValue = cartas[i].getValorCarta();
            for (int j=0; j<5; j++) {
                if(previousValue == cartas[i+1].getValorCarta() && previousValue%2 == 0) {
                    repeatedValue = previousValue;
                    return  repeatedValue;
                }
            }
        }
        return 0;
    }

    public String par(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = compareCards(cardsPlayer1);
        int player2Value = compareCards(cardsPlayer2);

        if(player1Value > player2Value) {
            return "Jugador 1 gana por par más alto";
        }
        if(player1Value < player2Value) {
            return "Jugador 2 gana por par más alto";
        }
        return cartaAlta(player1, player2);
    }

    public String dosPares(Player player1, Player player2) {
        if(player1.hand.equals(player2.hand)) {
            return cartaAlta(player1, player2);
        }
        return null;
    }
}
