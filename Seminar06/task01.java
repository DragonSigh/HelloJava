package Seminar06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class task01 {

    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {

        Laptop laptopOne = new Laptop(0, 8, 13.3, 1.37, 1339.69, "Apple", "MacBook Pro", "Ultrabook", "Intel Core i5 2.3GHz");
        Laptop laptopTwo = new Laptop(1, 8, 13.3, 1.34, 898.94, "Apple", "Macbook Air", "Ultrabook", "Intel Core i5 1.8GHz");
        Laptop laptopThree = new Laptop(2, 16, 15.4, 1.83, 2537.45, "Apple", "MacBook Pro", "Ultrabook", "Intel Core i7 2.7GHz");
        Laptop laptopFour = new Laptop(3, 8, 15.6, 1.86, 1339.69, "HP", "250 G6", "Notebook", "Intel Core i5 7200U 2.5GHz");
        Laptop laptopFive = new Laptop(4, 4, 15.6, 2.1, 400.00, "Acer", "Aspire 3", "Notebook", "AMD A9-Series 9420 3GHz");

        HashSet<Laptop> setLaptops = new HashSet<>(Arrays.asList(laptopOne, laptopTwo, laptopThree, laptopFour, laptopFive));

        filterLaptops(setLaptops);

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода! Попробуйте ещё раз.");
            return false;
        }
    }

    private static ArrayList<Double> getValues() {
        String userInput = "";
        Double minValue = null, maxValue = null;

        System.out.println("Введите минимальное значение:");
        userInput = iScanner.next();
        if (isDigit(userInput)) {
            minValue = Double.parseDouble(userInput);
        }

        System.out.println("Введите максимальное значение:");
        userInput = iScanner.next();
        if (isDigit(userInput)) {
            maxValue = Double.parseDouble(userInput);
        }

        ArrayList<Double> result = new ArrayList<Double>(Arrays.asList(minValue, maxValue));
        return result;        
    }

    public static void filterLaptops(HashSet<Laptop> inputSet) {
        Scanner iScanner = new Scanner(System.in);
        String userInput = "";
        Boolean filtrationNeed = true;
        Map<Integer, ArrayList<Double>> criteriaMap = new HashMap<>();
        
        while (filtrationNeed) {
            System.out.println("Введите цифру, соответствующую необходимому критерию или 0, чтобы выполнить:");
            System.out.println("1 - RAM");
            System.out.println("2 - Inches");
            System.out.println("3 - Price");
            System.out.println("0 - [Execute Filter]");

            userInput = iScanner.next();

            switch (userInput.charAt(0)) {
                case '1':
                    criteriaMap.put(1, getValues());
                    continue;
                case '2':
                    criteriaMap.put(2, getValues());
                    continue;
                case '3':
                    criteriaMap.put(3, getValues());
                    continue;
                case '0':
                    filtrationNeed = false;
                    break;
                default:  System.out.println("Ошибка ввода! Попробуйте ещё раз.");
            }
        }

        iScanner.close();
        System.out.println("Выбранные критерии для фильтрации:");
        System.out.println(criteriaMap);

        System.out.println("Результат:");

        Boolean ramCriteria = true;
        Boolean inchesCriteria = true;
        Boolean priceCriteria = true;

        for (Laptop object : inputSet) {          

            if (criteriaMap.containsKey(1)) ramCriteria = (object.RAM >= criteriaMap.get(1).get(0) &&  object.RAM <= criteriaMap.get(1).get(1));
            if (criteriaMap.containsKey(2)) inchesCriteria = (object.inches >= criteriaMap.get(2).get(0) &&  object.inches <= criteriaMap.get(2).get(1));
            if (criteriaMap.containsKey(3)) priceCriteria = (object.price >= criteriaMap.get(3).get(0) &&  object.inches <= criteriaMap.get(3).get(1));

            if (ramCriteria && inchesCriteria && priceCriteria) object.printInfo();
        }

    }
}
