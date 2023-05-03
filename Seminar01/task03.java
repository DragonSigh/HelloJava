package Seminar01;

import java.util.Scanner;

public class task03 {

    public static void main(String[] args) {
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
        System.out.printf(num1 + " " + operator + " " + num2 + " = " + result);

    }
    
}
