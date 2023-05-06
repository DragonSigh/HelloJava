package Seminar02;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class task04 {

    public static void main(String[] args) {

        try {

            Logger logger = Logger.getLogger(task02.class.getName());

            FileHandler fh = new FileHandler("calc.log"); 
            // связываем хендлер и логгер между собой
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            // нужно, чтобы была запись только в файл, без вывода в терминал
            logger.setUseParentHandlers(false);
            // записываем в лог файл
            logger.log(Level.INFO, "Начало программы");

        double num1;
        double num2;
        double result;
        char operator;
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");        
        num1 = iScanner.nextDouble();
        System.out.println("Введите второе число: ");
        num2 = iScanner.nextDouble();
        System.out.println("Укажите знак операции (+, -, *, /): ");
        operator = iScanner.next().charAt(0);
        iScanner.close();

        switch(operator) {
           case '+': result = num1 + num2;
              break;
           case '-': result = num1 - num2;
              break;
           case '*': result = num1 * num2;
              break;
           case '/': result = num1 / num2;
              break;
           default:  System.out.println("Неверный ввод!");
              return;
        }

        System.out.println("Результат:");
        
        String operation = num1 + " " + operator + " " + num2 + " = " + result;
        System.out.printf(operation);
        logger.log(Level.INFO, operation);
        logger.log(Level.INFO, "Завершение программы");

        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
