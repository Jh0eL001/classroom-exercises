/*
 * 2025-03-26.
 * Ordenamiento Burbuja (Bubble Sort)
 * PR| ordenar(coleccion, i) = ubicarMin(coleccion, i)---ordenar(coleccion, i+1)     | i < |coleccion|
 * PB| ordenar(coleccion, i) = nada (void)     | i = |coleccion|
 * CC| 1 <= i <= |coleccion|, para todo Ci pertenece Coleccion => Ci  Comparable  
 * coleccion = {C1, C2, C3,......., Ci,......, Cn}    i, n
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para implementar el algoritmo de ordenamiento Bubble Sort recursivo.
 *
 * @param <T> Tipo genérico que extiende Comparable para asegurar la comparación
 *            entre elementos.
 */
public class OrdenadorBurbuja<T extends Comparable<T>> {

  /**
   * Método público que inicia el proceso de ordenamiento burbuja.
   *
   * @param lista Lista de elementos a ordenar.
   */
  public void bubbleSort(ArrayList<T> lista) {
    ordenarLista(lista, 0);
  }

  /**
   * Método recursivo que ordena la lista usando el algoritmo Bubble Sort.
   *
   * @param lista        Lista de elementos a ordenar.
   * @param indiceActual Índice que indica la posición actual en la iteración del
   *                     algoritmo.
   */
  private void ordenarLista(ArrayList<T> lista, int indiceActual) {
    if (indiceActual == lista.size() - 1) {
      return; // Caso base: si hemos recorrido toda la lista, terminamos.
    }
    // Mover el elemento más pequeño hacia adelante en esta iteración
    moverMinimo(lista, indiceActual, lista.size() - 1);

    // Llamada recursiva para ordenar el siguiente elemento
    ordenarLista(lista, indiceActual + 1);
  }

  /**
   * Método recursivo que mueve el menor valor hacia la izquierda en la lista.
   *
   * @param lista        Lista de elementos a ordenar.
   * @param indiceInicio Índice inicial de la iteración actual.
   * @param indiceFin    Último índice de la iteración actual.
   */
  private void moverMinimo(ArrayList<T> lista, int indiceInicio, int indiceFin) {
    if (indiceInicio < indiceFin) {
      if (lista.get(indiceFin).compareTo(lista.get(indiceFin - 1)) < 0) {
        intercambiar(lista, indiceFin, indiceFin - 1);
      }
      moverMinimo(lista, indiceInicio, indiceFin - 1);
    }
  }

  /**
   * Método que intercambia dos elementos en la lista.
   *
   * @param lista Lista de elementos.
   * @param i     Índice del primer elemento.
   * @param j     Índice del segundo elemento.
   */
  private void intercambiar(ArrayList<T> lista, int i, int j) {
    T temporal = lista.get(j);
    lista.set(j, lista.get(i));
    lista.set(i, temporal);
  }

  public static void main(String[] args) {
    ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2, 7, 9, 4, 6, 0));
    // ArrayList<Character> letras = new ArrayList<>(Arrays.asList('B', 'C', 'F', 'A', 'a'));
    // ArrayList<String> cadena = new ArrayList<>(Arrays.asList("zorro", "manzana", "perro", "gato", "elefante"));
    System.out.println("Lista antes de ordenar:   " + numeros);

    OrdenadorBurbuja<Integer> ordenador = new OrdenadorBurbuja<>();
    ordenador.bubbleSort(numeros);
    System.out.println("Lista despues de ordenar: " + numeros);

    // OrdenadorBurbuja<Character> ordenadorLetras = new OrdenadorBurbuja<>();
    // ordenadorLetras.bubbleSort(letras);
    // System.out.println("Lista ordenada: " + letras);

    // System.out.println("Lista antes de ordenar: " + cadena);

    // OrdenadorBurbuja<String> ordenadorCadenas = new OrdenadorBurbuja<>();
    // ordenadorCadenas.bubbleSort(cadena);
    // System.out.println("Lista ordenada: " + cadena);
  }
}