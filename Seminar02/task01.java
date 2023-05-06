package Seminar02;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task01 {
    public static void main(String[] args) {
        String sqlRequest = "select * from students where ";
        StringBuilder sb = new StringBuilder(sqlRequest);

        try {
            JSONParser parser = new JSONParser();
            //Use JSONObject for simple JSON and JSONArray for array of JSON.
            JSONObject data = (JSONObject) parser.parse(
                  new FileReader(System.getProperty("user.dir") + "/Seminar02/task01.json"));//path to the JSON file.
    
            // Подсчёт ненулевых фильтров
            int notNullCount = 0;

            for(Iterator iterator = data.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();                
                if (!data.get(key).equals("null")) notNullCount++;
            }

            int counter = 0;
            // Формирование запроса
            for(Iterator iterator = data.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                
                if (!data.get(key).equals("null"))
                {
                    sb.append(String.format("%s = '%s'", key, data.get(key)));
                }
                counter++;
                if (counter < notNullCount) sb.append(" AND ");
            }
            sb.append(";");
        
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Результат
        System.out.println(sb.toString());
    }
}