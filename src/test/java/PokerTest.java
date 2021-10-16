
import domain.Card;
import domain.Hand;
import domain.Player;
import domain.enums.Palo;
import domain.enums.ValueCard;
import domain.impl.ManosPokerImpl;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class PokerTest {
    @DisplayName("Blanco: 2H 3D 5S 9C KD  Negro: 2C 3H 4S 8C AH Negro gana. - con la carta alta: As ")
    @Test
    public void testCartaAlta() {

        // Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.NUEVE, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.cartaAlta(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 14 por carta alta";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);

    }

    @DisplayName("Blanco: 2H 3D 5S 9C KD  Negro: 2C 3H 4S 8C 2C Blanco gana. - con la carta alta: Rey ")
    @Test
    public void testCartaAlta2() {
    	
    	// Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.NUEVE, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.DOS, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.cartaAlta(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 13 por carta alta";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    //par
    
    @DisplayName("Blanco: 2H 3D 5S KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con par: Rey ")
    @Test
    public void testPar() {
    	
    	// Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.KING, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.par(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 13 por par mas alto";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

	
    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 4S AC AH Negro gana. - con par: As ")
    @Test
    public void testPar2() {
        
    	// Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.AS, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.par(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 14 por par mas alto";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }


    //dos pares

    @DisplayName("Blanco: 2H 3D 3S KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con dos pares: Rey y Tres")
    @Test
    public void testDosPares() {

        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.TRES, Palo.S);
        listCard1[3] = new Card(ValueCard.KING, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.dosPares(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 13 por dos pares mas alto";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 3S AC AH Negro gana. - con dos pares: As y Tres ")
    @Test
    public void testDosPares2() {

        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.TRES, Palo.S);
        listCard2[3] = new Card(ValueCard.AS, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.dosPares(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 14 por dos pares mas alto";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    // terna

    @DisplayName("Blanco: 2H 3D KS KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con Terna: Rey ")
    @Test
    public void testTerna() {

        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.KING, Palo.S);
        listCard1[3] = new Card(ValueCard.KING, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.terna(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 13 por terna mas alta";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H AS AC AH Negro gana. - con Terna: As ")
    @Test
    public void testTerna2() {

        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.AS, Palo.S);
        listCard2[3] = new Card(ValueCard.AS, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.terna(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 14 por terna mas alta";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }


    // escalera
    @DisplayName("Blanco: 2H 3D 4S 5C 6D  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera ")
    //@Ignore
    @Test
    public void testEscalera() {

        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard1[3] = new Card(ValueCard.CINCO, Palo.C);
        listCard1[4] = new Card(ValueCard.SEIS, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.escalera(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 6 por escalera mas alta";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 4S 5C 6H Negro gana. - con Escalera ")
    @Ignore
    @Test
    public void testEscalera2() {

        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.CINCO, Palo.C);
        listCard2[4] = new Card(ValueCard.SEIS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.escalera(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 13 por escalera mas alta";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }


    // color
    @DisplayName("Blanco: 2H 3H 5H KH 8H  Negro: 2C 3H 4S 8C AH Blanco gana. - con color ")
    @Test
    public void testColor() {
        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.H);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.H);
        listCard1[3] = new Card(ValueCard.KING, Palo.H);
        listCard1[4] = new Card(ValueCard.OCHO, Palo.H);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.color(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 13 por valor mas alto con color";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3C 4C AC RC Negro gana. - con color ")
    @Test
    public void testColor2() {
        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.C);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.C);
        listCard2[3] = new Card(ValueCard.AS, Palo.C);
        listCard2[4] = new Card(ValueCard.QUEEN, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.color(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 14 por valor mas alto con color";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    
    //full house
    @DisplayName("Blanco: 2H 2D KS KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con full house ")
    @Test
    public void testFullHouse() {
    	// Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.DOS, Palo.D);
        listCard1[2] = new Card(ValueCard.KING, Palo.S);
        listCard1[3] = new Card(ValueCard.KING, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.fullHouse(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 13 por full house";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 2H AS AC AH Negro gana. - con full house ")
    @Test
    public void testFullHouse2() {
    	// Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.DOS, Palo.H);
        listCard2[2] = new Card(ValueCard.AS, Palo.S);
        listCard2[3] = new Card(ValueCard.AS, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.fullHouse(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 14 por full house";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }
	
    // poker
    @DisplayName("Blanco: 2H 2D 2S 2C KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con poker: 2 ")
    @Test
    public void testPoker() {
    	// Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.DOS, Palo.D);
        listCard1[2] = new Card(ValueCard.DOS, Palo.S);
        listCard1[3] = new Card(ValueCard.DOS, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.poker(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 2 por poker mas alto";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 2H 2S 2D KH Negro gana. - con poker: 2 ")
    @Test
    public void testPoker2() {
    	// Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.DOS, Palo.H);
        listCard2[2] = new Card(ValueCard.DOS, Palo.S);
        listCard2[3] = new Card(ValueCard.DOS, Palo.C);
        listCard2[4] = new Card(ValueCard.KING, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.poker(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 2 por poker mas alto";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    
    // escalera color
    @DisplayName("Blanco: 2H 3H 4H 5H 6H  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera Color: Corazon")
    @Test
    public void testEscaleraColor() {
    	// Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.H);
        listCard1[2] = new Card(ValueCard.CUATRO, Palo.H);
        listCard1[3] = new Card(ValueCard.CINCO, Palo.H);
        listCard1[4] = new Card(ValueCard.SEIS, Palo.H);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.escaleraDeColor(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana con carta 6 por escalera de color";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3C 4C 5C 6C Negro gana. - con Escalera Color: Trebol")
    @Test
    public void testEscaleraColor2() {
    	// Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.C);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.C);
        listCard2[3] = new Card(ValueCard.CINCO, Palo.C);
        listCard2[4] = new Card(ValueCard.SEIS, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.escaleraDeColor(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana con carta 6 por escalera de color";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }
    

    // escalera real
    @DisplayName("Blanco: 10H JH QH KH AH  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera Real: Corazon ")
    @Test
    public void testEscaleraReal() {
        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DIEZ, Palo.H);
        listCard1[1] = new Card(ValueCard.JOTA, Palo.H);
        listCard1[2] = new Card(ValueCard.QUEEN, Palo.H);
        listCard1[3] = new Card(ValueCard.KING, Palo.H);
        listCard1[4] = new Card(ValueCard.AS, Palo.H);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DOS, Palo.C);
        listCard2[1] = new Card(ValueCard.TRES, Palo.H);
        listCard2[2] = new Card(ValueCard.CUATRO, Palo.S);
        listCard2[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.H);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.escaleraReal(player1, player2);

        //Then
        final String expected = "(Blanco)Jugador 1 gana por escalera real";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 10C JC QC KC AC Negro gana. - con Escalera Real: Trebol")
    @Test
    public void testEscaleraReal2() {
        // Given

        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(ValueCard.DOS, Palo.H);
        listCard1[1] = new Card(ValueCard.TRES, Palo.D);
        listCard1[2] = new Card(ValueCard.CINCO, Palo.S);
        listCard1[3] = new Card(ValueCard.OCHO, Palo.C);
        listCard1[4] = new Card(ValueCard.KING, Palo.D);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(ValueCard.DIEZ, Palo.C);
        listCard2[1] = new Card(ValueCard.JOTA, Palo.C);
        listCard2[2] = new Card(ValueCard.QUEEN, Palo.C);
        listCard2[3] = new Card(ValueCard.KING, Palo.C);
        listCard2[4] = new Card(ValueCard.AS, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.escaleraReal(player1, player2);

        //Then
        final String expected = "(Negro)Jugador 2 gana por escalera real";
        //System.out.println("expected***"+expected+" actual***"+actual);
        assertEquals(expected, actual);
    }
}