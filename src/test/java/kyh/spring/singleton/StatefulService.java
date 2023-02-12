package kyh.spring.singleton;

public class StatefulService {
//    private int price; //상태를 유지하는 필드
    private int price;

    /**
        공유필드를 사용하면 에러 발생.
        스트링 빈은 항상 무상태로(stateless)로 설계할 것!
     **/
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }
    public int getPrice() {
        return price;
    }
}
