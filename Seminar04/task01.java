package Seminar04;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class task01 {
    public static void main(String[] args) {

        String[] countries = {"DE", "CH", "AT", "NL", "FR"};

        LinkedList<String> initialList = new LinkedList<> (Arrays.asList(countries));
        Collections.shuffle(initialList);

        System.out.println("Начальный список:");
        System.out.println(initialList);
        
        System.out.println("Обратный список:");
        System.out.println(reverseLL(initialList));
    }

    public static LinkedList<String> reverseLL(LinkedList<String> given) {
        Collections.reverse(given);
        return given;
    }

}
