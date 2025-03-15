package hotel;

public class Customer {

    private String name;
    private String number;
    public Object getName;

    public Customer() {}

    public Customer(String name, String number) {
        super();
        this.name = name;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
