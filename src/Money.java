public class Money {
    private double value;
    private String currency;
    public Money(double value){
        this.value=value;
        this.currency="£";
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
