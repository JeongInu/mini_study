package hotel;

public class Customer {

    private String name;
    private String phoneNo;

    public Customer() {}

    public Customer(String name, String phoneNo) {
        super();
        this.name = name;
        this.phoneNo = phoneNo;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
