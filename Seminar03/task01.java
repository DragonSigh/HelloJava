package Seminar03;

import java.util.Arrays;

public class task01 {
 
    public static void main(String[] args) {

        int[] input = { -3, 57, 3170, 33, 4, 5, 3, 1000, 10, 100, -999 };
    
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(input));
    
        mergeSort(input);
    
        System.out.println("Отсортированный массив");
        System.out.println(Arrays.toString(input));
    
      }
    
      public static void mergeSort(int[] input) {
        mergeSort(input, 0, input.length - 1);
      }
    
      private static void mergeSort(int[] input, int start, int end) {
    
        // Разбивка массива
        int mid = (start + end) / 2;
        if (start < end) {
          mergeSort(input, start, mid);
          mergeSort(input, mid + 1, end);
        }
    
        // Соединение массива
        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];
    
        while (first <= mid && last <= end) {
          tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
        while (first <= mid) {
          tmp[i++] = input[first++];
        }
        while (last <= end) {
          tmp[i++] = input[last++];
        }
        i = 0;
        while (start <= end) {
          input[start++] = tmp[i++];
        }
      }
      
}
