package domain.interfaces;

import domain.Player;

public interface IManosPoker {

    public String cartaAlta(Player player1, Player player2);

    public String par(Player player1, Player player2);

    public String dosPares(Player player1, Player player2);

}
