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

        int player1CardWinner = HelpToCompleteHands.highValueSearch(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearch(cardsPlayer2);

        String winner;

         if(player1CardWinner > player2CardWinner) {
             player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por carta alta");
             winner = player1.getWinnerMessage();
             return winner;
         }
        player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por carta alta");
        winner = player2.getWinnerMessage();
        return winner;
    }

    

    public String par(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por par mas alto");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por par mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }


    public String dosPares(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por dos pares mas alto");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por dos pares mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }


    public String terna(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por terna mas alta");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por terna mas alta");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }



    public String escalera(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por escalera mas alta");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por escalera mas alta");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }


    public String color(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.findRepeatedPalo(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.findRepeatedPalo(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por valor mas alto con color");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por valor mas alto con color");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

    
    public String poker(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por poker mas alto");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por poker mas alto");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

    public String escaleraDeColor(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.valuesConsecutivesWithColor(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.valuesConsecutivesWithColor(cardsPlayer2);

        String winner;

        if(player1CardWinner > player2CardWinner) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por escalera de color");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner < player2CardWinner) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por escalera de color");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

    
    public String escaleraReal(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        boolean player1CardWinner = HelpToCompleteHands.findRoyalFlush(cardsPlayer1);
        boolean player2CardWinner = HelpToCompleteHands.findRoyalFlush(cardsPlayer2);

        String winner;

        if(player1CardWinner == true && player2CardWinner == false) {
            player1.setWinnerMessage("(Blanco)Jugador 1 gana por escalera real");
            winner = player1.getWinnerMessage();
            return winner;
        }
        if(player1CardWinner == false && player2CardWinner == true) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana por escalera real");
            winner = player2.getWinnerMessage();
            return winner;
        }
        return cartaAlta(player1, player2);
    }

}
