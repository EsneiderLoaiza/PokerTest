package domain.enums;

public enum Palo {

    C(11),
    D(12),
    H(13),
    S(14);

    private int paloValue;

    Palo(int paloValue) {
        this.paloValue = paloValue;
    }

    public int getPaloValue() {
        return paloValue;
    }

    public void setPaloValue(int paloValue) {
        this.paloValue = paloValue;
    }
}
