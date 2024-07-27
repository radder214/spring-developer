package me.shinsunyoung.springbootdeveloper.Java17;

public class PatternMatching {
    public static void main(String[] args) {
        Object obj = 100;

        // 기존
        if(obj instanceof Integer) {
            Integer value1 = (Integer) obj;
            System.out.println("value1 : " + value1);
        }

        // 17 version
        if(obj instanceof Integer value2) {
            // 변수 obj가 Integer로 형변환된 value2 를 바로 사용할 수 있다.
            System.out.println("value2 : " + value2);
        }


        Object obj2 = "Hello, world!";
        if (obj2 instanceof String str) {
            // 변수 obj2가 String으로 형변환된 str을 바로 사용할 수 있다.
            System.out.println("The string is: " + str);
        } else {
            System.out.println("The object is not a string.");
        }
    }
}