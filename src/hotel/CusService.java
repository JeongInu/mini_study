package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CusService {
    private int resNum = 1;

    public void saveCusInfo(String name,String number){
        Hotel.customers.add(new Customer(name, number));
        System.out.println(name + "님의 정보가 저장되었습니다. 연락처 : " + number);
    }

    public String getDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

        return date.format(format);
    }

    public boolean isExist(String resNum){
        return Hotel.resers.stream().anyMatch(reser -> reser.getResNum().equals(resNum));
    }

    public void setReservation(Scanner scan){

        Hotel.rooms.stream()
                .filter(room -> room.getTotal() > 0)
                .forEach(room -> System.out.println(
                    "유형 : " + room.getType() +
                    " | 가격 : " + room.getPrice() +
                    " | 잔여 : " + room.getTotal()
                ));

        System.out.println("원하시는 유형의 방을 입력해주세요.");
        String type = scan.nextLine();
        System.out.println("몇 일이나 머무실 건가요?");
        int days = Integer.parseInt(scan.nextLine());
        System.out.println("예약자분의 성함을 알려주세요.");
        String name = scan.nextLine();
        //System.out.println("예약자분의 연락처를 알려주세요.");
        //String number = scan.nextLine();

        String number ="";
        while (true) {
            System.out.print("예약자분의 연락처를 알려주세요.");
            number = scan.nextLine();
            if(number.matches("^\\d{3}-\\d{4}-\\d{4}$")){
                break;
            } else {
                System.out.println("000-0000-0000 형식으로 기입하시오");
            }
        }

        String fNumber = number;

        Hotel.rooms.stream()
                .filter(room -> room.getType().equals(type))
                .findFirst()
                .ifPresent(room -> {

                    // 방 하나 까야함
                    room.setTotal(room.getTotal() - 1);

                    // 1. 고객 정보 저장
                    saveCusInfo(name, fNumber);

                    // 2. 예약 정보 저장
                    Hotel.resers.add(new Reservation(getDate()+"-"+resNum,name, room.getType(),room.getPrice()*days));

                    // 3. 예약 번호 출력
                    System.out.println(name+"님의 예약 번호 : " + getDate()+"-"+resNum);
                    
                    // 예약 번호 올려서 중복 방지
                    resNum ++;

                });

    }

    public void chkReservation(Scanner scan){
        System.out.println("예약 번호를 입력해주세요.");
        String resNum = scan.nextLine();

        if(isExist(resNum)){
            Hotel.resers.stream()
                    .filter(reser -> reser.getResNum().equals(resNum))
                    .findFirst()
                    .ifPresent(reser -> {

                        System.out.println("예약 번호: " + reser.getResNum() +
                                "\n객실 유형: " + reser.getType() +
                                "\n고객 이름: " + reser.getCusName() +
                                "\n가격: " + reser.getPrice());

                    });
        }else{
            System.out.println("예약 번호를 확인하세요.");
        }

    }

    public void delReservation(Scanner scan){
        System.out.println("예약 번호를 입력해주세요.");
        String resNum = scan.nextLine();

        if(isExist(resNum)){

            Hotel.resers.stream()
                    .filter(reser -> reser.getResNum().equals(resNum))
                    .findFirst()
                    .ifPresent(reser -> {
                        Hotel.resers.remove(reser);
                        System.out.println("예약 취소 완료");
                    });

        }else{
            System.out.println("예약 번호를 확인하세요.");
        }

    }

}
