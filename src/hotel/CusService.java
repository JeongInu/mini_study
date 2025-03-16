package hotel;

import java.util.LinkedList;

public class CusService {
    private static LinkedList<Customer> cusQueue = new LinkedList<>();
    private String name;
    private String phoneNo;
    
    public CusService(){}

    public void cusMenu(){
        while(true){
            System.out.println("메뉴: 1.예약 2.예약확인 3.예약취소 4.종료");
            System.out.print("메뉴 입력: ");
            String menu = DataInput.sc.nextLine();
            switch(menu){
                case "1":
                    makeReserv();
                    break;
                case "2":
                    checkRes();
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }

    }
    

    public void makeReserv(){
        System.out.print("이름: ");
        name = DataInput.sc.nextLine();

        while (true) {
            System.out.print("전화번호: ");
            phoneNo = DataInput.sc.nextLine();
            if(phoneNo.matches("^\\d{3}-\\d{4}-\\d{4}$")){
                cusQueue.offer(new Customer(name,phoneNo));
                break;
            } else {
                System.out.println("000-0000-0000 형식으로 기입하시오");
            }
        }
        

    }

    public void checkRes(){
        System.out.print("이름: ");
        String name = DataInput.sc.nextLine();
        System.out.print("전화번호: ");
        String phoneNo = DataInput.sc.nextLine();
        for(int i=0;i<cusQueue.size();i++){
            if(cusQueue.get(i).getName().equals(name) && cusQueue.get(i).getPhoneNo().equals(phoneNo)){
                System.out.println("예약되어 있습니다.");
                return;
            }
        }
        System.out.println("예약되어 있지 않습니다.");
    }

    public void showCus(){
        for(int i=0;i<cusQueue.size();i++){
            System.out.println(cusQueue.get(i).getName());
            System.out.println(cusQueue.get(i).getPhoneNo());
        }
    }

}
