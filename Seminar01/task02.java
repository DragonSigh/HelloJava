package Seminar01;

public class task02 {
    public static void main(String[] args) {
        getPrimeNums(1000);
    }

    public static void getPrimeNums(int count) {
        if (count > 0) {
            System.out.print("2, ");
        }

        for (int i = 3; i < count; i += 2) {
            if (isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
    }
    public static boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i = 2; i < number / 2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
