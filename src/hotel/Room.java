package hotel;

public class Room {

    private String type;
    private int price;
    private int total;

    public Room(String type, int price, int total) {
        this.type = type;
        this.price = price;
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
