package Seminar03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class task03 {
    public static void main(String[] args) {

        ArrayList<Integer> arrList = new ArrayList<>(10);
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            arrList.add(rand.nextInt(-100, 100));
        }

        System.out.println("Исходный список");
        System.out.println(arrList.toString());

        int min = Collections.min(arrList), max = Collections.max(arrList), sum = 0;

        for (int item : arrList) {
            sum += item;
        }

        float average = (float)sum / arrList.size();

        System.out.printf("Максимальный элемент: %s\n", max);
        System.out.printf("Минимальный элемент: %s\n", min);
        System.out.printf("Среднее арифметическое: %s\n", average);
    }
}
