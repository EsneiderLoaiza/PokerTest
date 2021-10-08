package domain.enums;

public enum Palo {

    C(0),
    D(0),
    H(0),
    S(0);

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
