package Seminar01;

import java.util.Scanner;

/**
 * task01
 */
public class task01 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число n:");
        int n = iScanner.nextInt();
        iScanner.close();

        System.out.printf("%d-треугольное число = %d\n", n, calcTriangularNum(n));
        System.out.printf("%d! = %d\n", n, calcFactorialNum(n));
    }

    public static int calcTriangularNum(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static int calcFactorialNum(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}