package domain.impl;

import domain.Card;
import domain.HelpToCompleteHands;
import domain.Player;
import domain.constants.HandsConstants;
import domain.interfaces.IManosPoker;

import java.util.Arrays;


public class ManosPokerImpl implements IManosPoker {


    public String cartaAlta(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearch(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearch(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.CARTA_ALTA);
        return winner;
    }

    public String par(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearchInParInPar(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.PAR);
        return winner;
    }


    public String dosPares(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearchInParInTwoPar(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.DOS_PARES);
        return winner;
    }

    public String terna(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.highValueSearchThreeTimes(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.TERNA);
        return winner;
    }

    public String escalera(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.reviewConsecutiveValues(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.ESCALERA);
        return winner;
    }


    public String color(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.findRepeatedPalo(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.findRepeatedPalo(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.COLOR);
        return winner;
    }

    public String fullHouse(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.searchFullHouse(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.searchFullHouse(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.FULL_HOUSE);
        return winner;
    }

    public String poker(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.findFourRepeatedValues(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.POKER);
        return winner;
    }

    public String escaleraDeColor(Player player1, Player player2) {
        Card[] cardsPlayer1 = player1.hand.getHand();
        Card[] cardsPlayer2 = player2.hand.getHand();

        int player1CardWinner = HelpToCompleteHands.valuesConsecutivesWithColor(cardsPlayer1);
        int player2CardWinner = HelpToCompleteHands.valuesConsecutivesWithColor(cardsPlayer2);

        String winner = saysWinner(player1, player2, player1CardWinner, player2CardWinner, HandsConstants.ESCALERA_DE_COLOR);
        return winner;
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

    public String saysWinner(Player player1, Player player2, int player1CardWinner, int player2CardWinner, String handMsg) {

        String winner;
        String player1CadenaValue = HelpToCompleteHands.cardsToString(player1CardWinner);
        String player2CadenaValue = HelpToCompleteHands.cardsToString(player2CardWinner);

        if(player1CardWinner > player2CardWinner) {
            if(player1CadenaValue != null) {
                player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CadenaValue+" por "+handMsg);
            } else {
                player1.setWinnerMessage("(Blanco)Jugador 1 gana con carta "+player1CardWinner+" por "+handMsg);
            }
            winner = player1.getWinnerMessage();
            return winner;
        }

        if(player2CadenaValue != null) {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CadenaValue+" por "+handMsg);
        } else {
            player2.setWinnerMessage("(Negro)Jugador 2 gana con carta "+player2CardWinner+" por "+handMsg);
        }
        winner = player2.getWinnerMessage();
        return winner;
    }
}