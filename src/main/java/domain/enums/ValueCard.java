package domain.enums;

public enum ValueCard {

    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10),
    JOTA(11),
    QUEEN(12),
    KING(13),
    AS(14);

    private int valueCard;

    ValueCard(int valueCard) {
        this.valueCard = valueCard;
    }

    public int getValueCard() {
        return valueCard;
    }

    public void setValueCard(int valueCard) {
        this.valueCard = valueCard;
    }
}
