package hotel;

public class Reservation {

    private String resNum;
    private String cusName;
    private String type;
    private int price;

    public Reservation(String resNum, String cusName, String type, int price) {
        this.resNum = resNum;
        this.cusName = cusName;
        this.type = type;
        this.price = price;
    }

    public String getResNum() {
        return resNum;
    }

    public void setResNum(String resNum) {
        this.resNum = resNum;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
