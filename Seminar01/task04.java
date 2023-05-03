package Seminar01;

// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

public class task04 {
    public static void main(String[] args) {
        String equation = "2? + ?5 = 69";
        solveEquation(equation);
    }

    public static void solveEquation(String equation) {
        int count = 0;
        String result = "";
        for (int q = 1; q <= 9; q++) {    
          for (int w = 1; w <= 9; w++) {    
            for (int e = 1; e <= 9; e++) {    
              String exp = equation.replaceFirst("\\?",""+q).replaceFirst("\\?",""+w).replaceFirst("\\?",""+e);   

              if (checkExpression(exp)) {   
                if (result.contains(exp) == false) {
                    result += exp + ";\n";
                } 
                count++;  
              }    
            }    
          }    
        }
    
        if (count == 0) {    
          System.out.println("Решения нет");
        }
        else {
          System.out.println(result);
        }
    
      }
    
      public static boolean checkExpression(String expression) {    
        String[] parts = expression.split("=");
        int left1 = Integer.parseInt(parts[0].trim().split("\\+")[0].trim());
        int left2 = Integer.parseInt(parts[0].trim().split("\\+")[1].trim());
        int right = Integer.parseInt(parts[1].trim());
        return left1 + left2 == right; //equate to the value of e
      }
}
