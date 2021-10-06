package domain.interfaces;

import domain.Card;
import domain.Player;

public interface IManosPoker {

    public int countCartas(Card[] cartas, Player player);

    public String cartaAlta(Player player1, Player player2);

    public String par(Player player1, Player player2);

    public String dosPares(Player player1, Player player2);

}
