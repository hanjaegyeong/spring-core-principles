package hello.core.singleton;
public class StatefulService {
//    private int price; //상태를 유지하는 필드
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price; //price를 바로 리턴하도록 바꿔버림. 공유필드 없애버리고
    }
//    public int getPrice() {
//        return price;
//    }
}