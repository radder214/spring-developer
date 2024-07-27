package me.shinsunyoung.springbootdeveloper.Java17;

public class Formatted_method {
    public static void main(String[] args) {
        String textBlock = """
                {
                    "id" : %d,
                    "name" : %s
                }
                """;
        System.out.println("======================================");
        System.out.println(textBlock.formatted(2, "juice"));
    }
}