package hotel;

public class Bill {

    private String billNum;
    private String type;
    private String cusName;
    private int totalPrice;

    public Bill(String billNum, String type, String cusName, int totalPrice) {
        this.billNum = billNum;
        this.type = type;
        this.cusName = cusName;
        this.totalPrice = totalPrice;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}
