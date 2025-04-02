/*
 * 2025-04-02.
 * Determinar la clausura de un conjunto
 * PR| clausura(set, n) = clausura(set', n-1) U sufijar(clausura(set', n-1, Cn))  | n > 0
 * PB| clausura(set, n) = {{ }} set vacio   | n = 0 (si el tamanio del set es 0)
 * CC| n = col.length; n E enteros pos incluido el cero, col' = col - Cn
 */

import java.util.Arrays;

public class ConjuntoClausura {
  /**
   * Calcular la clausura (potencia) de un conjunto
   * @param set el conjunto a potenciar.
   */
  public void clausura(int[] set) {
    System.out.println("Iniciando cálculo de la clausura del conjunto: " + Arrays.toString(set));
    generar(set, 1);
  }

  private void generar(int[] set, int size) {
    if (size <= set.length) {
      System.out.println("\nGenerando subconjuntos de tamaño " + size + "...");
      combinar(set, new int[size], 0, 0, size);
      generar(set, size + 1);
    }
  }

  private void combinar(int[] set, int[] temp, int start, int level, int size) {
    // Debug para ver en qué punto de la recursión estamos
    System.out.println("--combinando -> temp: " + Arrays.toString(temp) + ", start: " + start + ", level: " + level);

    if (level == size) {
      System.out.println("-> Subconjunto encontrado: \n" + Arrays.toString(temp));
      return;
    }

    for (int i = start; i < set.length; i++) {
      temp[level] = set[i]; // Agregar elemento actual al subconjunto
      System.out.println("\nAgregando " + set[i] + " en posición " + level);
      combinar(set, temp, i + 1, level + 1, size); // Llamado recursivo avanzando
    }

  }

  public static void main(String[] args) {
    // Creamos una instancia de la clase
    ConjuntoClausura generador = new ConjuntoClausura();

    // Definimos el conjunto de números a partir del cual generaremos los
    // subconjuntos
    int[] numeros = { 1, 2, 3};

    // Llamamos al método principal para generar la clausura del conjunto
    generador.clausura(numeros);
  }
}
