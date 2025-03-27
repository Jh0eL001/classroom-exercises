/*
 * 2025-03-26.
 * Busqueda Secuencial Con Recursividad.
 * PR| buscar(coleccion, n, elemento) = buscar(coleccion, n-1, elemento)    Cn != elemento | n > 0
 * PB| buscar(coleccion, n, elemento) = True                                Cn = elemento  | n > 0
 * PB_2| buscar(coleccion, n, elemenuo) = False                                            | n = 0
 * CC| n Pertenece a los Numeros enteros positivos incluidos el 0; n <= |coleccion| (size of the colection)
 */

import java.util.ArrayList;
import java.util.Random;

public class BuscadorSecuencial<T> {
	/**
	 * Método público para buscar un elemento en una lista.
	 * 
	 * @param lista    Lista de elementos de tipo T.
	 * @param elemento Elemento a buscar en la lista.
	 * @return true si el elemento está en la lista, false si no.
	 */
	public boolean buscar(ArrayList<T> lista, T elemento) {
		return buscar(lista, lista.size(), elemento);
	}

	/**
	 * Método privado recursivo que realiza la búsqueda secuencial.
	 * 
	 * @param lista    Lista de elementos.
	 * @param n        Tamaño actual de la lista que estamos evaluando.
	 * @param elemento Elemento a buscar.
	 * @return true si se encuentra el elemento, false en caso contrario.
	 */
	private boolean buscar(ArrayList<T> lista, int n, T elemento) {
		boolean existe;
		if (n == 0) {
			existe = false;
		} else {
			if (lista.get(n - 1).equals(elemento)) {
				existe = true;
			} else {
				existe = buscar(lista, n - 1, elemento);
			}
		}
		return existe;
	}

	public static void main(String[] args) {
		System.out.println("\nBúsqueda Secuencial Recursiva en Java\n");
		// Generar un número aleatorio
		Random random = new Random();
		int numeroBuscado = random.nextInt(10) + 1;
		int elementosDeseados = 20;
		//  Crear una lista de números
		ArrayList<Integer> numeros = new ArrayList<>();
		for (int i = 0; i < elementosDeseados; i++) {
			numeros.add(random.nextInt(11));
		}
		// Crear un objeto de BuscadorSecuencial para enteros
		BuscadorSecuencial<Integer> buscador = new BuscadorSecuencial<>();

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