package hotel;

import java.util.LinkedList;

public class CusService {
    private static LinkedList<Customer> cusQueue = new LinkedList<>();
    private String name;
    private String phoneNo;
    
    public CusService(){}

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

    public void show(){
        for(int i=0;i<cusQueue.size();i++){
            System.out.println(cusQueue.get(i).getName());
            System.out.println(cusQueue.get(i).getNumber());
        }
    }

}
