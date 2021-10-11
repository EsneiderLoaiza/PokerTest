package domain.impl;

import domain.Card;
import domain.HelpToCompleteHands;
import domain.Player;
import domain.interfaces.IManosPoker;

import java.util.Arrays;


public class ManosPokerImpl implements IManosPoker {


    public String cartaAlta(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearch(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearch(cardsPlayer2);

         if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por carta alta";
         }
        return "(Negro)Jugador 2 gana por carta alta";
    }

    

    public String par(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por par mas alto";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por par mas alto";
        }
        return cartaAlta(player1, player2);
    }


    public String dosPares(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por dos pares mas alto";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por dos pares mas alto";
        }
        return cartaAlta(player1, player2);
    }


    public String terna(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por terna mas alta";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por terna mas alta";
        }
        return cartaAlta(player1, player2);
    }



    public String escalera(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer1);
        int player2Value = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por escalera mas alta";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por escalera mas alto";
        }
        return cartaAlta(player1, player2);
    }

    
    public String poker(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer1);
        int player2Value = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por poker mas alto";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por poker mas alto";
        }
        return cartaAlta(player1, player2);
    }

    public String color(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.findRepeatedPalo(cardsPlayer1);
        int player2Value = HelpToCompleteHands.findRepeatedPalo(cardsPlayer2);

        if(player1Value > player2Value) {
            return "(Blanco)Jugador 1 gana por valor mas alto con color";
        }
        if(player1Value < player2Value) {
            return "(Negro)Jugador 2 gana por valor mas alto con color";
        }
        return cartaAlta(player1, player2);
    }

    public String escaleraReal(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        boolean player1Value = HelpToCompleteHands.findRoyalFlush(cardsPlayer1);
        boolean player2Value = HelpToCompleteHands.findRoyalFlush(cardsPlayer2);

        if(player1Value == true && player2Value == false) {
            return "(Blanco)Jugador 1 gana por escalera real";
        }
        if(player1Value == false && player2Value == true) {
            return "(Negro)Jugador 2 gana por escalera real";
        }
        return cartaAlta(player1, player2);
    }

}
