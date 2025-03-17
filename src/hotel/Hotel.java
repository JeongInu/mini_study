package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    public static List<Customer> customers = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static List<Reservation> resers = new ArrayList<>();
    public static List<Bill> bills = new ArrayList<>();

    public static void welcome() {
        Scanner scan = new Scanner(System.in);
        HotelService hotel = new HotelService();
        CusService cus = new CusService();

        hotel.setRooms();

        while (true) {
            System.out.println("1. 객실 예약");
            System.out.println("2. 예약 확인");
            System.out.println("3. 예약 취소");
            System.out.println("4. Check In");
            System.out.println("5. Check Out");
            System.out.println("6. 종료");

            int pickMe = 0;

            while (true) {
                try {
                    pickMe = Integer.parseInt(scan.nextLine());
                    if (pickMe < 1 || pickMe > 6) {
                        System.out.println("1부터 6");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자");
                }
            }

            switch (pickMe) {
                case 1:
                    // 객실 예약
                    cus.setReservation(scan);
                    break;
                case 2:
                    // 예약 확인
                    cus.chkReservation(scan);
                    break;
                case 3:
                    // 예약 취소
                    cus.delReservation(scan);
                    break;
                case 4:
                    // Check In
                    hotel.chkIn(scan);
                    break;
                case 5:
                    // Check Out
                    hotel.chkOut(scan);
                    break;
                case 6:
                    // 종료하기
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("입력 값을 확인하세요.");
                    continue;
            }
        }
    }
}
