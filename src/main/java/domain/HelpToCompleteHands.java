package domain;

import domain.enums.ValueCard;

public class HelpToCompleteHands {
	
	public void delDiezAlAs() {
		
	}
	
	public static int highValueSearch(Card[] cartas){
        int highValue = 0;
        for(int i=0; i<5; i++) {
            	if(cartas[i].getValueCard().getValue() > highValue) {
            		highValue = cartas[i].getValueCard().getValue();
            	}
        }
        return  highValue;
    }
	
	
	public static int highValueSearchInParInPar(Card[] cartas) {
        int repeatedValue = 0;
        for(int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {
                if(cartas[i].getValueCard().getValue() == cartas[j].getValueCard().getValue()) {
                    repeatedValue = cartas[i].getValueCard().getValue();
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
                 if(cartas[i].getValueCard().getValue() == cartas[j].getValueCard().getValue()) {
                     repeatedValue = cartas[i].getValueCard().getValue();
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
                if(cartas[i].getValueCard().getValue() == cartas[j].getValueCard().getValue()) {
                    repeatedValue = cartas[i].getValueCard().getValue();
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
                if(cartas[j].getValueCard().getValue() > cartas[j+1].getValueCard().getValue()) {
                    cartas[5].setValueCard(cartas[j].getValueCard());
                    cartas[j].setValueCard(cartas[j+1].getValueCard());
                    cartas[j+1].setValueCard(cartas[5].getValueCard());
                }
            }
        }

        for(int i=1; i<5; i++) {
            for (int j=i+1 ; j<5; j++){
                if(cartas[i].getValueCard().getValue() > cartas[j].getValueCard().getValue() &&
                cartas[j].getValueCard().getValue() == cartas[i].getValueCard().getValue() -1 &&
                cartas[i].getValueCard().getValue() < cartas[j].getValueCard().getValue() &&
                cartas[j].getValueCard().getValue() == cartas[i].getValueCard().getValue() +1){
                    increase++;
                }
                if(increase == 4) {
                    return cartas[4].getValueCard().getValue();
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
                if(cartas[i].getValueCard().getValue() == cartas[j].getValueCard().getValue()) {
                    repeatedValue = cartas[i].getValueCard().getValue();
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
                if(repeatedPalo == cartas[i].getPalo().getPaloValue() && cartas[i].getValueCard().getValue() > highValue) {
                    timesRepeated++;
                    highValue = cartas[i].getValueCard().getValue();
                    if(timesRepeated == 4){
                        return  highValue;
                    }
                }
        }
        return 0;
    }

    public static boolean findRoyalFlush(Card[] cartas){
        int itsRoyalFlush = 0;
        boolean winner = false;
        String repeatedPalo = cartas[0].getPalo().getPaloValue();
        for(int i=0; i<5; i++) {
            if(repeatedPalo == cartas[i].getPalo().getPaloValue()) {
                 if(cartas[i].getValueCard().getValue() == ValueCard.DIEZ.getValue() ||
                     cartas[i].getValueCard().getValue() == ValueCard.JOTA.getValue() ||
                     cartas[i].getValueCard().getValue() == ValueCard.QUEEN.getValue() ||
                     cartas[i].getValueCard().getValue() == ValueCard.KING.getValue() ||
                     cartas[i].getValueCard().getValue() == ValueCard.AS.getValue()) {
                    	
                        itsRoyalFlush++;
                 }
            }
        }
        if(itsRoyalFlush == 5){
                    winner = true;
                    return  winner;
                }
        return winner;
    }

}
