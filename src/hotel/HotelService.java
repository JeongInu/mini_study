package hotel;

import java.util.Scanner;

public interface HotelService {
    int roomNum();
    void setRooms();
    void chkIn(Scanner scan);
    void chkOut(Scanner scan);
}
