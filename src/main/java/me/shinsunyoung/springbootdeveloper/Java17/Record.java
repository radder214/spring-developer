package me.shinsunyoung.springbootdeveloper.Java17;

public class Record {
    public static void main(String[] args) {
        Item item = new Item("juice", 3000);
        System.out.println("item.name : " + item.name);
        System.out.println("item.name() : " + item.name());
        System.out.println("==========================");
        System.out.println("item.price : " + item.price);
        System.out.println("item.price() : " + item.price());
        System.out.println("==========================");
        System.out.println("item.test : " + item.test);
        System.out.println("item.test : " + item.getTest());

    }

    // record 생성
    record Item(String name, int price) {
        // 자동으로 parameter 가 private final 로 정의된다.
        // getter 를 자동으로 만들기 때문에 annotation 이나 method 로 getter 를 따로 정의하지 않아도 된다.
        private static final String test = "apple";
        private String getTest() {
            return test;
        }
    }
}
/* 아래와 같이 출력
item.name : juice
item.name() : juice
==========================
item.price : 3000
item.price() : 3000
*/