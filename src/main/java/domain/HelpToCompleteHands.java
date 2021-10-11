package domain;

import domain.enums.ValueCard;

public class HelpToCompleteHands {
	
	public static int highValueSearch(Card[] cartas){
        int highValue = 0;
        for(int i=0; i<5; i++) {
            	if(cartas[i].getValueCard().getValueCard() > highValue) {
            		highValue = cartas[i].getValueCard().getValueCard();
            	}
        }
        return  highValue;
    }
	
	
	public static int highValueSearchInParInPar(Card[] cartas) {
        int repeatedValue = 0;
        for(int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {
                if(cartas[i].getValueCard().getValueCard() == cartas[j].getValueCard().getValueCard()) {
                    repeatedValue = cartas[i].getValueCard().getValueCard();
                    return  repeatedValue;
                }
            }
        }
        return repeatedValue;
    }
	
	
	public static int highValueSearchInParInTwoPar(Card[] cartas) {
        int repeatedValue = 0;
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
             for(int j=i+1; j<5; j++) {
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
	
	public static int highValueSearchThreeTimes(Card[] cartas){
        int repeatedValue = 0;
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {
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
	
	
	public static int reviewConsecutiveValues(Card[] cartas){
        //Arrays.sort(cartas);
        int increase = 0;
        int aux = 0;
        for(int i=1; i<5; i++) {
            for(int j=i+1 ; j<5; j++) {
                if(cartas[j].getValueCard().getValueCard() > cartas[j+1].getValueCard().getValueCard()) {
                    cartas[5].setValueCard(cartas[j].getValueCard());
                    cartas[j].setValueCard(cartas[j+1].getValueCard());
                    cartas[j+1].setValueCard(cartas[5].getValueCard());
                }
            }
        }

        for(int i=1; i<5; i++) {
            for (int j=i+1 ; j<5; j++){
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
	
	
	public static int findFourRepeatedValues(Card[] cartas){
        int repeatedValue = 0;
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {
                if(cartas[i].getValueCard().getValueCard() == cartas[j].getValueCard().getValueCard()) {
                    repeatedValue = cartas[i].getValueCard().getValueCard();
                    timesRepeated++;
                    if(timesRepeated == 4){
                        return  repeatedValue;
                    }
                }
            }
        }
        return 0;
    }

    public static int findRepeatedPalo(Card[] cartas){
        int highValue = 0;
        String repeatedPalo = cartas[0].getPalo().getPaloValue();
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
                if(repeatedPalo == cartas[i].getPalo().getPaloValue() && cartas[i].getValueCard().getValueCard() > highValue) {
                    timesRepeated++;
                    highValue = cartas[i].getValueCard().getValueCard();
                    if(timesRepeated == 4){
                        return  highValue;
                    }
                }
        }
        return 0;
    }

    public static boolean findRoyalFlush(Card[] cartas){
        int timesRepeated = 0;
        int increase = 0;
        boolean winner = false;
        String repeatedPalo = cartas[0].getPalo().getPaloValue();
        for(int i=0; i<5; i++) {
            if(repeatedPalo == cartas[i].getPalo().getPaloValue()) {
                timesRepeated++;
                if(cartas[i].getValueCard().getValueCard() == ValueCard.DIEZ.getValueCard()) {
                    increase++;
                }
                if(cartas[i].getValueCard().getValueCard() == ValueCard.JOTA.getValueCard()) {
                    increase++;
                }
                if(cartas[i].getValueCard().getValueCard() == ValueCard.QUEEN.getValueCard()) {
                    increase++;
                }
                if(cartas[i].getValueCard().getValueCard() == ValueCard.KING.getValueCard()) {
                    increase++;
                }
                if(cartas[i].getValueCard().getValueCard() == ValueCard.AS.getValueCard()) {
                    increase++;
                }
                if(timesRepeated == 4 && increase == 4){
                    winner = true;
                    return  winner;
                }
            }
        }
        return winner;
    }

}
