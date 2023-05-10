package Seminar03;

import java.util.ArrayList;
import java.util.List;

public class task02 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 12, 123, 1234, 12345);
        List<Integer> result = new ArrayList<>();

        System.out.println("Исходный список");
        System.out.println(list.toString());

        for (Integer item : list) {
            if (item % 2 != 0) result.add(item);
        }

        System.out.println("Список без четных чисел");
        System.out.println(result.toString());

    }
}
