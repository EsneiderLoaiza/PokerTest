package domain;

import domain.enums.ValueCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HelpToCompleteHands {
	
	public static String convertValueToString(int valueCard) {
        String cadenavalueCard;
		if(valueCard == 11) {
            cadenavalueCard = "Jota";
            return cadenavalueCard;
        }
        if(valueCard == 12) {
            cadenavalueCard = "Queen";
            return cadenavalueCard;
        }
        if(valueCard == 13) {
            cadenavalueCard = "King";
            return cadenavalueCard;
        }
        if(valueCard == 14) {
            cadenavalueCard = "As";
            return cadenavalueCard;
        }
        return "x";
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
		
        ArrayList<Integer> valuesCard = new ArrayList<Integer>();
        
        for (int i=0; i<5; i++) {
            valuesCard.add(cartas[i].getValueCard().getValue());
        }
        Collections.sort(valuesCard);

        int valueConsecutive = 0;
        int highValue = 0;
        
        for(int i=0; i<5; i++) {
            if(i <= 3 && valuesCard.get(i) == (valuesCard.get(i+1)-1)) {
               valueConsecutive++;
               
               if(valueConsecutive == 4) {
                  highValue = valuesCard.get(4);
                  return highValue;
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

    public static int searchFullHouse(Card[] cartas) {
    	
        int isFullHouse = 0;
        int threeValuesRepeated = highValueSearchThreeTimes(cartas);
        int twoValuesRepeated = 0;

        for (int i=0; i<5; i++) {
            if(cartas[i].getValueCard().getValue() != threeValuesRepeated) {
                twoValuesRepeated = cartas[i].getValueCard().getValue();
                
                if(twoValuesRepeated == cartas[i].getValueCard().getValue()){
                    isFullHouse = threeValuesRepeated;
                    return isFullHouse;
                }
            }
        }

	    return 0;
    }

    public static int valuesConsecutivesWithColor(Card[] cartas) {

        String repeatedPalo = cartas[0].getPalo().getPaloValue();
        int timesRepeated = 0;
        for(int i=0; i<5; i++) {
            if(repeatedPalo == cartas[i].getPalo().getPaloValue()) {
                timesRepeated++;
                if(timesRepeated == 4){
                    return  reviewConsecutiveValues(cartas);
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
