/*
 * 2025-03-28.
 * ExerciseName
 * PR|      | n > 0
 * PB|      | n > 0
 * CC| 
 */
public class Fibonacci {
  public void fibonacciRecursivo(int n) {
    fibonacciRecursivo(n, 0, 1);
  }

  private void fibonacciRecursivo(int n, int a, int b) {
    if (n == 0)
      return;

    System.out.print(a + " ");
    fibonacciRecursivo(n - 1, b, a + b);
  }

  /**
   * Fibo Recursivo version 2
   * public int fibonacci(int n) {
   *  int sec = 0;
   *  if(n == 1) {
   *    sec = 1;
   *  } else if(n == 2) {
   *    sec = 2;
   *  } else {
   *    sec = fibonacci(n - 1) + fibonacci(n -2 );
   *  }
   *  return sec;
   *  }
   */
  public static void main(String[] args) {
    Fibonacci num = new Fibonacci();
    System.out.print("La secuencia de Fibonacci es: ");
    num.fibonacciRecursivo(10, 0, 1);
    System.out.println(); // Para salto de línea
  }
}
