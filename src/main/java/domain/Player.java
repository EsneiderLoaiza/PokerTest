package domain;

public class Player {

    public Hand hand;
    private String winnerMessage;

    public Player(Hand hand) {
        this.hand = hand;
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }

    public void setWinnerMessage(String winnerMessage) {
        this.winnerMessage = winnerMessage;
    }
}
