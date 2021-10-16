package domain.interfaces;

import domain.Card;
import domain.Player;

public interface IManosPoker {


    public String cartaAlta(Player player1, Player player2);

    public String par(Player player1, Player player2);

    public String dosPares(Player player1, Player player2);

    public String terna(Player player1, Player player2);

    public String escalera(Player player1, Player player2);

    public String color(Player player1, Player player2);
    
    public String poker(Player player1, Player player2);

    public String escaleraDeColor(Player player1, Player player2);

    public String escaleraReal(Player player1, Player player2);

}
