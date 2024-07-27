package me.shinsunyoung.springbootdeveloper.Java17;

public class Record {
    public static void main(String[] args) {
        Item item = new Item("juice", 3000);
        System.out.println("item.name : " + item.name);
        System.out.println("item.name() : " + item.name());
        System.out.println("==========================");
        System.out.println("item.price : " + item.price);
        System.out.println("item.price() : " + item.price());

    }
    record Item(String name, int price) {
        // 자동으로 parameter 가 private final 로 정의된다.
    }
}