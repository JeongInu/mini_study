package hotel;

import java.util.Random;
import java.util.Scanner;

public class HotelServiceImpl implements HotelService {

    CusServiceImpl cus = new CusServiceImpl();

    public int roomNum(){
        Random random = new Random();
        return random.nextInt(100)+1;
    }

    public void setRooms(){
        Hotel.rooms.add(new Room("일반",100000,5));
        Hotel.rooms.add(new Room("스위트",200000,3));
    }

    public void chkIn(Scanner scan){

        // 1. 예약 번호를 입력받고
        System.out.println("예약 번호를 입력해주세요.");
        String resNum = scan.nextLine();

        if(cus.isExist(resNum)){

            // 2. 객실 번호 출력 3. 예약 목록 삭제
            Hotel.resers.stream()
                    .filter(reser->reser.getResNum().equals(resNum))
                    .findFirst()
                    .ifPresent(reser -> {
                        String billNum;

                        if(reser.getType().equals("스위트")){
                            billNum = "S"+roomNum();
                        }else{
                            billNum = "N"+roomNum();
                        }
                        System.out.println("---------------------------------------------------------");
                        System.out.println("환영합니다. 객실 번호는 : " + billNum);
                        Hotel.bills.add(new Bill(billNum,reser.getType(),reser.getCusName(),reser.getPrice()));
                        Hotel.resers.remove(reser);

                    });
        }else{
            System.out.println("---------------------------------------------------------");
            System.out.println("예약 번호를 확인하세요.");
        }


    }

    public void chkOut(Scanner scan){

        System.out.println("투숙하신 객실 번호를 입력해주세요.");
        String roomNum = scan.nextLine();

        boolean isExist = Hotel.bills.stream().anyMatch(bill -> bill.getBillNum().equals(roomNum));

        if(isExist){

            System.out.println("계산서를 출력합니다.");

            Hotel.bills.stream()
                    .filter(bill -> bill.getBillNum().equals(roomNum))
                    .findFirst()
                    .ifPresent(bill -> {

                        // 계산서 출력
                        System.out.println("---------------------------------------------------------");
                        System.out.println("객실 번호: " + bill.getBillNum() +
                                "\n객실 유형: " + bill.getType() +
                                "\n고객 성함: " + bill.getCusName() +
                                "\n최종 가격: " + bill.getTotalPrice());

                        // 영수증 출력
                        System.out.println("납부 방식을 선택해주세요(1~3). 1.현금|2.신용카드|3.수표");
                        int pay = Integer.parseInt(scan.nextLine());

                        String payment = "";
                        switch (pay) {
                            case 1:
                                payment = "현금";
                                break;
                            case 2:
                                payment = "신용카드";
                                break;
                            case 3:
                                payment = "수표";
                                break;
                            default:
                                System.out.println("입력을 확인하세요.");
                                break;
                        }

                        System.out.println("영수증을 출력합니다.");
                        System.out.println("---------------------------------------------------------");
                        System.out.println("객실 번호: " + bill.getBillNum() +
                                "\n객실 유형: " + bill.getType() +
                                "\n고객 성함: " + bill.getCusName() +
                                "\n최종 가격: " + bill.getTotalPrice() +
                                "\n납부 방법: " + payment);

                    });

        }else{
            System.out.println("객실 번호를 확인해주세요.");
        }

    }

}
