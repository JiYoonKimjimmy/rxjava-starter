package fp;

import java.util.Arrays;
import java.util.List;

public class Functional00 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // 함수형 프로그래밍
        for (Integer i : list) {
            String data = convert(i);
            System.out.println(data);
        }

        // 함수형 프로그래밍
        list.stream()
                .map(Functional00::convert)
                .forEach(System.out::println);
    }

    private static String convert(int i) {
        return switch (i) {
            case 1 -> "첫 번째";
            case 2 -> "두 번째";
            case 3 -> "세 번째";
            default -> "";
        };
    }
}
