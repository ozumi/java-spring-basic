package hello.core.singleton;

public class StatefulService {
    //private int price; //상태를 유지하는 필드 => 여기가 문제

    public int order(String name, int price) {
        System.out.println(name + " ordered " + price);
        //this.price = price; //여기가 문제
        return price;
    }

    // 상태를 유지하는 필드를 굳이 리턴하지 말고 order함수에서 바로 return 하도록 변경함
//    public int getPrice() {
//        return price;
//    }
}
