package me.shinsunyoung.springbootdeveloper.Java17;

public class TextBlock {
    public static void main(String[] args) {
        // 기존
        String sql1 = "SELECT * FROM ITEMS\n" +
                        "WHERE STSTUS = ON_SALE\n" +
                        "ORDER BY PRICE;";
        // 텍스트 블록
        String sql2 = """
                SELECT * FROM ITEMS
                WHERE STATUS = ON_SALE
                ORDER BY PRICE;
                """;
        System.out.println("============ sql1 ============");
        System.out.println(sql1);
        System.out.println("============ sql2 ============");
        System.out.println(sql2);
    }
}
/* 아래와 같이 출력
============ sql1 ============
SELECT * FROM ITEMS
WHERE STSTUS = ON_SALE
ORDER BY PRICE;
============ sql2 ============
SELECT * FROM ITEMS
WHERE STATUS = ON_SALE
ORDER BY PRICE;
*/