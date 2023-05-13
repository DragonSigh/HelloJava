package Seminar04;

import java.util.LinkedList;

public class task02 {
    public static void main(String[] args) {
        LinkedList<String> ordersList = new LinkedList<>();
        enqueue(ordersList, "Покупатель 1");
        enqueue(ordersList, "Покупатель 2");
        enqueue(ordersList, "Покупатель 3");

        System.out.println("Текущая очередь заказов:");
        System.out.println(ordersList);

        System.out.println("Взяли на обслуживание:  " + dequeue(ordersList));

        System.out.println("Текущая очередь заказов:");
        System.out.println(ordersList);

        System.out.println("Следующий на обслуживание: " + first(ordersList));

        System.out.println("Текущая очередь заказов:");
        System.out.println(ordersList);
    }

    public static void enqueue(LinkedList<String> given, String elem) {
        given.addLast(elem);
    }

    public static String dequeue(LinkedList<String> given) {
        return given.removeFirst();
    }

    public static String first(LinkedList<String> given) {
        return given.getFirst();
    }

    
}
