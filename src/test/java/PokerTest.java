
import domain.Card;
import domain.Hand;
import domain.Player;
import domain.enums.Palo;
import domain.impl.ManosPokerImpl;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;




public class PokerTest {
    @DisplayName("Blanco: 2H 3D 5S 9C KD  Negro: 2C 3H 4S 8C AH Negro gana. - con la carta alta: As ")
    @Test
    public void testCartaAlta() {

        // Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(2, Palo.C);
        listCard1[1] = new Card(3, Palo.D);
        listCard1[2] = new Card(4, Palo.H);
        listCard1[3] = new Card(8, Palo.S);
        listCard1[4] = new Card(6, Palo.C);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(2, Palo.C);
        listCard2[1] = new Card(3, Palo.D);
        listCard2[2] = new Card(4, Palo.H);
        listCard2[3] = new Card(5, Palo.S);
        listCard2[4] = new Card(6, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.cartaAlta(player1, player2);

        //Then
        final String expected = "Jugador 1 gana por carta alta";
        assertEquals(expected, actual);

    }

    @DisplayName("Blanco: 2H 3D 5S 9C KD  Negro: 2C 3H 4S 8C 2C Blanco gana. - con la carta alta: Rey ")
    @Test
    public void testCartaAlta2() {
    	
    	// Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(2, Palo.C);
        listCard1[1] = new Card(3, Palo.D);
        listCard1[2] = new Card(4, Palo.H);
        listCard1[3] = new Card(8, Palo.S);
        listCard1[4] = new Card(6, Palo.C);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(2, Palo.C);
        listCard2[1] = new Card(3, Palo.D);
        listCard2[2] = new Card(4, Palo.H);
        listCard2[3] = new Card(9, Palo.S);
        listCard2[4] = new Card(8, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.cartaAlta(player1, player2);

        //Then
        final String expected = "Jugador 2 gana por carta alta";
        assertEquals(expected, actual);
    }

    //par
    
    @DisplayName("Blanco: 2H 3D 5S KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con par: Rey ")
    @Test
    public void testPar() {
    	
    	// Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(2, Palo.C);
        listCard1[1] = new Card(2, Palo.D);
        listCard1[2] = new Card(4, Palo.H);
        listCard1[3] = new Card(8, Palo.S);
        listCard1[4] = new Card(6, Palo.C);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(2, Palo.C);
        listCard2[1] = new Card(3, Palo.D);
        listCard2[2] = new Card(4, Palo.H);
        listCard2[3] = new Card(4, Palo.S);
        listCard2[4] = new Card(6, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.par(player1, player2);

        //Then
        final String expected = "Jugador 2 gana por par más alto";
        assertEquals(expected, actual);
    }

	
    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 4S AC AH Negro gana. - con par: As ")
    @Test
    public void testPar2() {
        
    	// Given
    	
        //PLAYER 1

        Card[] listCard1 = new Card[5];
        listCard1[0] = new Card(6, Palo.C);
        listCard1[1] = new Card(6, Palo.D);
        listCard1[2] = new Card(4, Palo.H);
        listCard1[3] = new Card(8, Palo.S);
        listCard1[4] = new Card(6, Palo.C);
        Player player1 = new Player(new Hand(listCard1));

        //PLAYER 2

        Card[] listCard2 = new Card[5];
        listCard2[0] = new Card(2, Palo.C);
        listCard2[1] = new Card(3, Palo.D);
        listCard2[2] = new Card(4, Palo.H);
        listCard2[3] = new Card(4, Palo.S);
        listCard2[4] = new Card(6, Palo.C);
        Player player2 = new Player(new Hand(listCard2));

        // When
        ManosPokerImpl manosPoker = new ManosPokerImpl();
        final String actual = manosPoker.par(player1, player2);

        //Then
        final String expected = "Jugador 1 gana por par más alto";
        assertEquals(expected, actual);
    }

	/*
    //dos pares

    @DisplayName("Blanco: 2H 3D 3S KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con dos pares: Rey y Tres")
    @Test
    void testDosPares() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 3S AC AH Negro gana. - con dos pares: As y Tres ")
    @Test
    void testDosPares2() {
        fail("no implementado");
    }

    // terna

    @DisplayName("Blanco: 2H 3D KS KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con Terna: Rey ")
    @Test
    void testTerna() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H AS AC AH Negro gana. - con Terna: As ")
    @Test
    void testTerna2() {
        fail("no implementado");
    }


    // escalera
    @DisplayName("Blanco: 2H 3D 4S 5C 6D  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera ")
    @Test
    void testEscalera() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3H 4S 5C 6H Negro gana. - con Escalera ")
    @Test
    void testEscalera2() {
        fail("no implementado");
    }


    // color
    @DisplayName("Blanco: 2H 3H 5H KH 8H  Negro: 2C 3H 4S 8C AH Blanco gana. - con color ")
    @Test
    void testColor() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3C 4C AC RC Negro gana. - con color ")
    @Test
    void testColor2() {
        fail("no implementado");
    }

    //full house
    @DisplayName("Blanco: 2H 2D KS KC KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con full house ")
    @Test
    void testFullHouse() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 2H 3S AC AH Negro gana. - con full house ")
    @Test
    void testFullHouse2() {
        fail("no implementado");
    }

    // poker
    @DisplayName("Blanco: 2H 2D 2S 2C KD  Negro: 2C 3H 4S 8C AH Blanco gana. - con poker: 2 ")
    @Test
    void testPoker() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 2H 2S 2D KH Negro gana. - con poker: 2 ")
    @Test
    void testPoker2() {
        fail("no implementado");
    }


    // escalera color
    @DisplayName("Blanco: 2H 3H 4H 5H 6H  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera Color: Corazon")
    @Test
    void testEscaleraColor() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 2C 3C 4C 5C 6C Negro gana. - con Escalera Color: Trebol")
    @Test
    void testEscaleraColor2() {
        fail("no implementado");
    }


    // escalera real
    @DisplayName("Blanco: 10H JH QH KH AH  Negro: 2C 3H 4S 8C AH Blanco gana. - con Escalera Real: Corazon ")
    @Test
    void testEscaleraReal() {
        fail("no implementado");
    }

    @DisplayName("Blanco: 2H 3D 5S 8C KD  Negro: 10C JC QC KC AC Negro gana. - con Escalera Real: Trebol")
    @Test
    void testEscaleraReal2() {
        fail("no implementado");
    }*/
}