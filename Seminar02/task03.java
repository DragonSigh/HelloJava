package Seminar02;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task03 {
    public static void main(String[] args) {
      System.out.println(getResults(System.getProperty("user.dir") + "/Seminar02/task03.json"));
    }

    public static StringBuilder getResults(String filename) {
        StringBuilder sb = new StringBuilder();

        try {
            JSONParser parser = new JSONParser();
            //Use JSONObject for simple JSON and JSONArray for array of JSON.
            JSONArray data = (JSONArray) parser.parse(
                  new FileReader(filename));//path to the JSON file.

            //Iterating the contents of the array
            Iterator iterator = data.iterator();            

            while(iterator.hasNext()) {
                JSONObject student = (JSONObject) iterator.next();                
                sb.append(String.format("Студент %s получил %s по предмету %s\n",
                    student.get("фамилия"),
                    student.get("оценка"),
                    student.get("предмет")));
            }
          
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return sb;
    }
}