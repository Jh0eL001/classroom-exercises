/*
 * 2025-03-27.
 * Ordenador de colecciones usando el algoritmo de Merge Sort
 * PR| ordenarMS(col, n) = dividir(col, n, col1, col2)      | n > 1
 * PR| ordenarMS(col, n) = ordenarMS(col1, |col1|)      | n > 1
 * PR| ordenarMS(col, n) = ordenarMS(col2, |col2|)     | n > 1
 * PR| ordenarMS(col, n) = merge(col1, col2, col)     | n > 1
 * PB| ordenarMS(col, n) = nada (void)    | n <= 1
 * CC| n = |col|, n pertenece a los enteros positivos. n = size
 */

import java.util.ArrayList;
import java.util.Arrays;

public class OrdenadorMerge<T extends Comparable<T>> {

	public void ordenarMS(ArrayList<T> lista) {
		ordenarMS(lista, lista.size(), 0);
	}

	private void ordenarMS(ArrayList<T> lista, int size, int k) {
		// Caso Base: Si la lista tiene 1 o menos elementos, no es necesario ordenar.
		if (size <= 1) {
			return;
		} else {
			// Dividimos la lista en dos sublistas
			int mid = size / 2;
			ArrayList<T> left = new ArrayList<>(lista.subList(0, mid));
			ArrayList<T> right = new ArrayList<>(lista.subList(mid, size));

			// Llamada recursiva para las dos sublistas
			ordenarMS(left);
			ordenarMS(right);

			// Fusionamos las dos sublistas de forma recursiva
			mergeRecursivo(left, right, lista, k);
		}
	}

	private void mergeRecursivo(ArrayList<T> left, ArrayList<T> right, ArrayList<T> lista, int k) {
		// Caso base: Si left está vacío, copiar los elementos de right en la lista
		if (left.isEmpty()) {
			// Si 'left' está vacío, copiamos 'right' a 'lista' recursivamente
			if (!right.isEmpty()) {
				lista.set(k, right.get(0));
				mergeRecursivo(left, new ArrayList<>(right.subList(1, right.size())), lista, k + 1);
			}
			return;
		}

		// Caso base: Si right está vacío, copiar los elementos de left en la lista
		if (right.isEmpty()) {
			// Si 'right' está vacío, copiamos 'left' a 'lista' recursivamente
			if (!left.isEmpty()) {
				lista.set(k, left.get(0));
				mergeRecursivo(new ArrayList<>(left.subList(1, left.size())), right, lista, k + 1);
			}
			return;
		}

		// Comparar los primeros elementos de left y right
		if (left.get(0).compareTo(right.get(0)) <= 0) {
			lista.set(k, left.get(0)); // Insertar el menor en 'lista'
			// Llamar recursivamente con el resto de los elementos
			mergeRecursivo(new ArrayList<>(left.subList(1, left.size())), right, lista, k + 1);
		} else {
			lista.set(k, right.get(0)); // Insertar el menor en 'lista'
			// Llamar recursivamente con el resto de los elementos
			mergeRecursivo(left, new ArrayList<>(right.subList(1, right.size())), lista, k + 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(3, 2, 5, 0, 1, 8, 7, 6, 9, 4));
		OrdenadorMerge<Integer> ordenador = new OrdenadorMerge<>();
		System.out.println("Lista antes de ordenar: " + numeros);
		ordenador.ordenarMS(numeros);
		System.out.println("Lista ordenada: " + numeros);
	}
}
