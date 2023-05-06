package Seminar02;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class task02 {
    public static void main(String[] args) {
        try {

            Logger logger = Logger.getLogger(task02.class.getName());

            FileHandler fh = new FileHandler("logger.log"); 
            // связываем хендлер и логгер между собой
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            // нужно, чтобы была запись только в файл, без вывода в терминал
            logger.setUseParentHandlers(false);
            // записываем в лог файл
            logger.log(Level.INFO, "Начало сортировки");

            int [] mas = {5, 10, 14, 11, 8};
 
            boolean isSorted = false;
            int buf;
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < mas.length-1; i++) {
                    if(mas[i] > mas[i+1]){
                        isSorted = false;
     
                        buf = mas[i];
                        mas[i] = mas[i+1];
                        mas[i+1] = buf;
                    }
                    logger.log(Level.INFO, Arrays.toString(mas));
                }
            }

            logger.log(Level.INFO, "Завершение сортировки");

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
