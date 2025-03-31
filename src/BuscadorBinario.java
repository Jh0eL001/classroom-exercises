
/*
 * 2025-03-26.
 * Buscador Binario (Binary Search). 
 * PB|buscarBin(col, start, end, elemento) = True                                    Cm = elemento| start <= fin
 * PR|buscarBin(col, start, end, elemento) = buscarBin(col, start, m - 1, elemento)  elemento < Cm| start <= fin
 * PR|buscarBin(col, start, end, elemento) = buscarBin(col, m+1, end, elemento)      elemento > Cm| start <= fin
 * PB|buscarBin(col, start, end, elemento) = false                                                | start > fin
 * CC| 0 <= start, fin <= |col| + 1 ;    start, end pertenecen a los Z+ incluido el 0.
 */
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase genérica que implementa el algoritmo de búsqueda binaria recursiva.
 * Funciona para cualquier tipo de colección que implemente Comparable.
 * la coleccion debe de estar ordenada.
 * 
 * @param <T> Tipo de dato genérico que debe ser comparable.
 */
public class BuscadorBinario<T extends Comparable<T>> {
  /**
   * Método público para buscar un elemento en una lista ordenada.
   * 
   * @param coleccion Lista ordenada de elementos.
   * @param elemento  Elemento a buscar.
   * @return true si el elemento está en la lista, false en caso contrario.
   */
  public boolean buscar(ArrayList<T> coleccion, T elemento) {
    return buscar(coleccion, 0, coleccion.size() - 1, elemento);
  }

  /**
   * Método privado recursivo para realizar la búsqueda binaria.
   * 
   * @param coleccion Lista ordenada de elementos.
   * @param start     Índice de inicio.
   * @param end       Índice final.
   * @param elemento  Elemento a buscar.
   * @return true si se encuentra el elemento, false en caso contrario.
   */
  private boolean buscar(ArrayList<T> coleccion, int start, int end, T elemento) {
    boolean existe;
    int mid;
    // si recorremos toda la coleccion y no encontramos el elemento.
    if (start > end) {
      existe = false;
    } else {
      // dividimos la coleccion a la mitad y comparamos el elemento del medio con el
      // que estamos buscando
      mid = (start + end) / 2;
      if (elemento.compareTo(coleccion.get(mid)) == 0) {
        existe = true;
      } else {
        // el metodo compareTo retorna un n negativo si el elemento que estamos buscando
        // es menor al elemento actual de la coleccion en posicion [mid], entonces
        // debemos de buscar el elemento en la mitad izquierda de la lista.
        if (elemento.compareTo(coleccion.get(mid)) < 0) {
          existe = buscar(coleccion, start, mid - 1, elemento);
        } else {
          // si el elemento no esta en el lado izquierdo de la lista, buscamos en el lado
          // derecho desde una posicion mas adelante de el elemento de corte [m + 1]
          existe = buscar(coleccion, mid + 1, end, elemento);
        }
      }
    }
    return existe;
    /**
     * forma mas avanzada para ahorrar lineas de codigo
     * if (start > end) return false;
     * 
     * int mid = (start + end) / 2;
     * int comparacion = elemento.compareTo(coleccion.get(mid));
     * 
     * if (comparacion == 0) return true;
     * if (comparacion < 0) return buscar(coleccion, start, mid - 1, elemento);
     * return buscar(coleccion, mid + 1, end, elemento);
     */
  }

  public static void main(String[] args) {
    System.out.println("\nBúsqueda Binaria Recursiva en Java\n");
    // Generar un número aleatorio
    Random random = new Random();
    int numeroBuscado = random.nextInt(10) + 1;
    int elementosDeseados = 10;
    // Crear una lista de números
    ArrayList<Integer> numeros = new ArrayList<>();
    for (int i = 0; i < elementosDeseados; i++) {
      numeros.add(random.nextInt(10) + 1);
    }
    // Ordenar la lista antes de realizar la búsqueda
    numeros.sort(Integer::compareTo);

    // Crear un objeto de BuscadorBinario para enteros
    BuscadorBinario<Integer> buscador = new BuscadorBinario<>();

    // Realizar la búsqueda
    boolean encontrado = buscador.buscar(numeros, numeroBuscado);

    // Mostrar resultado
    if (encontrado) {
      System.out.println("La lista generada es: " + numeros);
      System.out.println("El número " + numeroBuscado + " fue encontrado en la lista.");
    } else {
      System.out.println("La lista generada es: " + numeros);
      System.out.println("El número " + numeroBuscado + " no está en la lista.");
    }
  }
}