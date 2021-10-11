package domain.enums;

public enum Palo {

    C("C"),
    D("D"),
    H("H"),
    S("S");

    private String paloValue;

    Palo(String paloValue) {
        this.paloValue = paloValue;
    }

    public String getPaloValue() {
        return paloValue;
    }

    public void setPaloValue(String paloValue) {
        this.paloValue = paloValue;
    }
}
