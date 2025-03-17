package hotel;

import java.util.Scanner;

public interface CusService {
    void saveCusInfo(String name, String number);
    String getDate();
    boolean isExist(String resNum);
    void setReservation(Scanner scan);
    void chkReservation(Scanner scan);
    void delReservation(Scanner scan);
}
