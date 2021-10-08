package domain.impl;

import domain.Card;
import domain.Player;
import domain.interfaces.IManosPoker;

import java.util.Arrays;


public class ManosPokerImpl implements IManosPoker {


    public String cartaAlta(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = countCartas(cardsPlayer1);
        int player2Value = countCartas(cardsPlayer2);

         if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por carta alta";
         }
        return "(Negro)Jugador 2 gana por carta alta";
    }

    public int countCartas(Card[] cartas){
        int totalValue = 0;
        for(int i=0; i<5; i++) {
            totalValue = totalValue + cartas[i].getValueCard().getValueCard() + cartas[i].getPalo().getPaloValue();
        }
        return  totalValue;
    }

    public String par(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = compareCards(cardsPlayer1);
        int player2Value = compareCards(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por par más alto";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por par más alto";
        }
        return cartaAlta(player1, player2);
    }

    public int compareCards(Card[] cartas) {
        int repeatedValue = 0;
        for(int i=0; i<5; i++) {
            for (int j=1; j<5; j++) {
                if(cartas[i].getValueCard().getValueCard() == cartas[j].getValueCard().getValueCard()) {
                    repeatedValue = cartas[i].getValueCard().getValueCard();
                    return  repeatedValue;
                }
            }
        }
        return 0;
    }

    public String dosPares(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = helpToDosPares(cardsPlayer1);
        int player2Value = helpToDosPares(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por dos pares mas alto";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por dos pares mas alto";
        }
        return cartaAlta(player1, player2);
    }

    public int helpToDosPares(Card[] cartas) {
        int repeatedValue = 0;
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
             for(int j=1; j<5; j++) {
                 if(cartas[i].getValueCard().getValueCard() == cartas[j].getValueCard().getValueCard()) {
                     repeatedValue = cartas[i].getValueCard().getValueCard();
                     timesRepeated++;
                     if(timesRepeated == 2){
                         return  repeatedValue;
                     }
                 }
             }
        }
        return  repeatedValue;
    }

    public String terna(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = helpToTerna(cardsPlayer1);
        int player2Value = helpToTerna(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por terna mas alta";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por terna mas alta";
        }
        return cartaAlta(player1, player2);
    }

    public int helpToTerna(Card[] cartas){
        int repeatedValue = 0;
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
            for (int j=1; j<5; j++) {
                if(cartas[i].getValueCard().getValueCard() == cartas[j].getValueCard().getValueCard()) {
                    repeatedValue = cartas[i].getValueCard().getValueCard();
                    timesRepeated++;
                    if(timesRepeated == 3){
                        return  repeatedValue;
                    }
                }
            }
        }
        return 0;
    }

    public String escalera(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = helpToEscalera(cardsPlayer1);
        int player2Value = helpToEscalera(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por escalera mas alta";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por escalera mas alto";
        }
        return cartaAlta(player1, player2);
    }

    public int helpToEscalera(Card[] cartas){
        Arrays.sort(cartas);
        int increase = 0;
        for(int i=1; i<5; i++) {
            for (int j=0 ; j<5; j++){
                if(cartas[i].getValueCard().getValueCard() > cartas[j].getValueCard().getValueCard() && 
                cartas[j].getValueCard().getValueCard() == cartas[i].getValueCard().getValueCard() -1 &&
                cartas[i].getValueCard().getValueCard() < cartas[j].getValueCard().getValueCard() && 
                cartas[j].getValueCard().getValueCard() == cartas[i].getValueCard().getValueCard() +1){
                    increase++;
                }
                if(increase == 4) {
                    return cartas[4].getValueCard().getValueCard();
                }
            }
        }
        return 0;
    }
}
