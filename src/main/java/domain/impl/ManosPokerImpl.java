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

        String winner;

         if(player1Value > player2Value) {
             player1.setWinnerMessage("(Blanco)Jugador 1 gana por carta alta");
             winner = player1.getWinnerMessage();
             return winner;
         }
        player2.setWinnerMessage("(Negro)Jugador 2 gana por carta alta");
        winner = player2.getWinnerMessage();
        return winner;
    }

    

    public String par(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer2);

        String winner;

        if(player1Value > player2Value) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por par mas alto");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value < player2Value) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por par mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }


    public String dosPares(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer2);

        String winner;

        if(player1Value > player2Value) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por dos pares mas alto");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value < player2Value) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por dos pares mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }


    public String terna(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer1);
        int player2Value = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer2);

        String winner;

        if(player1Value > player2Value) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por terna mas alta");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value < player2Value) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por terna mas alta");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }



    public String escalera(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer1);
        int player2Value = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer2);

        String winner;

        if(player1Value > player2Value) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por escalera mas alta");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value < player2Value) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por escalera mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

    
    public String poker(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer1);
        int player2Value = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer2);

        String winner;

        if(player1Value > player2Value) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por poker mas alto");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value < player2Value) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por poker mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

    public String color(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1Value = HelpToCompleteHands.findRepeatedPalo(cardsPlayer1);
        int player2Value = HelpToCompleteHands.findRepeatedPalo(cardsPlayer2);

        String winner;

        if(player1Value > player2Value) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por valor mas alto con color");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value < player2Value) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por valor mas alto con color");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

    public String escaleraReal(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        boolean player1Value = HelpToCompleteHands.findRoyalFlush(cardsPlayer1);
        boolean player2Value = HelpToCompleteHands.findRoyalFlush(cardsPlayer2);

        String winner;

        if(player1Value == true && player2Value == false) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por escalera real");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1Value == false && player2Value == true) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por escalera real");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

}
