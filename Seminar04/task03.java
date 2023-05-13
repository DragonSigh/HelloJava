package Seminar04;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.*;

public class task03 {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        
       try {

            Logger logger = Logger.getLogger(task03.class.getName());

            FileHandler fh = new FileHandler("calc.log"); 
            // связываем хендлер и логгер между собой
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            // нужно, чтобы была запись только в файл, без вывода в терминал
            logger.setUseParentHandlers(false);
            // записываем в лог файл
            logger.log(Level.INFO, "Начало программы");

        Double result;
        Double num1;
        Double num2;
        String userInput = "";
        String operation = "";

        Scanner iScanner = new Scanner(System.in);
        Stack<String> st = new Stack<>();

        while (operation == "") {
            switch (st.size()) {
                case 0:
                    System.out.println("Введите первое число: ");
                    userInput = iScanner.next();
                    if (isDigit(userInput)) {
                        st.push(userInput);
                    }
                    else {
                        System.out.println("Ошибка ввода! Попробуйте ещё раз.");
                        continue;
                    }
                case 1:
                    System.out.println("Введите второе число или r для отмены последней операции: ");
                    userInput = iScanner.next();
                    if (isDigit(userInput)) {
                        st.push(userInput);
                    }
                    else if (userInput.charAt(0) == 'r') {
                        st.pop();
                        System.out.println("Последняя операция отменена.");
                        continue;
                    }
                    else {
                        System.out.println("Ошибка ввода! Попробуйте ещё раз.");
                        continue;
                    }
                case 2:
                    System.out.println("Укажите знак операции (+, -, *, /) или r для отмены последней операции: ");
                    userInput = iScanner.next();
                    
                    switch (userInput.charAt(0)) {
                        case '+':
                            num2 = Double.parseDouble(st.pop());
                            num1 = Double.parseDouble(st.pop());
                            result = num1 + num2;
                            operation = num1 + " + " + num2 + " = " + result;
                            break;
                        case '-':
                            num2 = Double.parseDouble(st.pop());
                            num1 = Double.parseDouble(st.pop());
                            result = num1 - num2;
                            operation = num1 + " - " + num2 + " = " + result;
                            break;
                        case '*':
                            num2 = Double.parseDouble(st.pop());
                            num1 = Double.parseDouble(st.pop());
                            result = num1 * num2;
                            operation = num1 + " * " + num2 + " = " + result;
                            break;
                        case '/':
                            num2 = Double.parseDouble(st.pop());
                            num1 = Double.parseDouble(st.pop());
                            result = num1 + num2;
                            operation = num1 + " / " + num2 + " = " + result;
                            break;
                        case 'r':
                            st.pop();
                            System.out.println("Последняя операция отменена.");
                            continue;
                        default:  System.out.println("Ошибка ввода! Попробуйте ещё раз.");
                            continue;
                    }
                }
		}
		
        iScanner.close();

        System.out.println("Результат:");        
        System.out.printf(operation);
        
        logger.log(Level.INFO, operation);
        logger.log(Level.INFO, "Завершение программы");

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
