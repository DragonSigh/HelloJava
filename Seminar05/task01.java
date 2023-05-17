package Seminar05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class task01 {

    public static void main(String[] args) {
        HashMap<ArrayList<String>, ArrayList<String>> workersHashMap = new HashMap<>();
        HashMap<String, Integer> countingHashMap = new HashMap<>();

        ArrayList<String> workerName = new ArrayList<>(); // фамилия, имя
        ArrayList<String> workerPhone = new ArrayList<>(); // номер телефона

        addData(workersHashMap, "Иванов", "Иван", "9261111111");
        addData(workersHashMap, "Иванов", "Иван", "495 555 96 доб. 135");

        addData(workersHashMap, "Петрова", "Светлана", "111");

        addData(workersHashMap, "Юрин", "Иван", "999 8888 333");
        addData(workersHashMap, "Юрин", "Иван", "495 555 96 доб. 118");

        addData(workersHashMap, "Чернышов", "Петр", "928777555");

        //findWorkerByName(workersHashMap, "Иван");
        countWorkers(workersHashMap);

        //System.out.println(workersHashMap);

        //addWorker(workersHashMap, );
    }

    private static void addData(HashMap<ArrayList<String>, ArrayList<String>> inputHashMap, String inputSurname, String inputName, String phoneNumber) {

        ArrayList<String> workerName = new ArrayList<>(); // фамилия, имя
        ArrayList<String> workerPhone = new ArrayList<>(); // номер телефона

        workerName.add(inputSurname);
        workerName.add(inputName);      
        
        if (inputHashMap.get(workerName) != null) {
            workerPhone = inputHashMap.get(workerName);
            workerPhone.add(phoneNumber);
        }
        else {
            workerPhone.add(phoneNumber);
        }

        inputHashMap.put(workerName, workerPhone);
    }

    private static void findWorkerByName(HashMap<ArrayList<String>, ArrayList<String>> inputHashMap, String inputName) {
        for (Map.Entry<ArrayList<String>, ArrayList<String>> el : inputHashMap.entrySet()) {
            if (el.getKey().contains(inputName)) System.out.println(el.getKey() + " = " + el.getValue());
        }
    }

    private static void countWorkers(HashMap<ArrayList<String>, ArrayList<String>> inputHashMap) {
        HashMap<String, Integer> resultHashMap = new HashMap<>();
        String tmpName = "";
        Integer tmpCounter = 1;

        for (Map.Entry<ArrayList<String>, ArrayList<String>> el : inputHashMap.entrySet()) {
            tmpName = el.getKey().get(1);
           
            if (resultHashMap.containsKey(tmpName)) {
                tmpCounter = resultHashMap.get(tmpName);
                resultHashMap.put(tmpName, tmpCounter + 1);
            }
            else {
                resultHashMap.put(tmpName, 1);
            }
        }

        // Этот способ вывода нашёл в интернете
        resultHashMap.entrySet().stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .forEach(System.out::println);

    }
}