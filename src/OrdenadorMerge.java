/*
 * https://youtu.be/5Z9dn2WTg9o
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

/**
 * @param T ordenador para cualquier tipo comparable
 */
public class OrdenadorMerge<T extends Comparable<T>> {
	/**
	 * Ordenar una coleccion de forma recursiva
	 * 
	 * @param lista coleccion tipo Comparable T
	 */
	public void ordenar(ArrayList<T> lista) {
		// Caso Base: si la lista tiene cero o un elemento, ya esta ordenada
		if (lista.size() <= 1) {
			return;
		}

		// Dividir la lista en dos mitades.
		int mid = lista.size() / 2;
		ArrayList<T> izquierda = new ArrayList<>(lista.subList(0, mid));
		ArrayList<T> derecha = new ArrayList<>(lista.subList(mid, lista.size()));

		// Ordenar recursivamente cada mitad
		ordenar(derecha);
		ordenar(izquierda);

		// Combinamos las mitades ordenadas recursivamente (Merge part)
		lista.clear();
		combinar(izquierda, derecha, lista);
	}

	/**
	 * Combinar los elementos ordenados de manera recursiva (Merge Sort)
	 * 
	 * @param izquierda el lado izquierdo de la coleccion
	 * @param derecha   el lado izquierdo de la coleccion
	 * @param resultado la nueva lista combinada con izq, der
	 */
	private void combinar(ArrayList<T> izquierda, ArrayList<T> derecha, ArrayList<T> resultado) {
		// Caso Base
		if (izquierda.isEmpty()) {
			resultado.addAll(derecha);
			return;
		}
		if (derecha.isEmpty()) {
			resultado.addAll(izquierda);
			return;
		}

		// Si no estan vacias, comparar los primeros elementos de cada lista
		if (izquierda.get(0).compareTo(derecha.get(0)) <= 0) {
			resultado.add(izquierda.remove(0));
		} else {
			resultado.add(derecha.remove(0));
		}

		// Llamada recursiva con los elementos restantes
		combinar(izquierda, derecha, resultado);
	}

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(3, 2, 5, 0, 1, 8, 7, 6, 9, 4));
		OrdenadorMerge<Integer> ordenador = new OrdenadorMerge<>();
		System.out.println("Lista antes de ordenar: " + numeros);
		ordenador.ordenar(numeros);
		System.out.println("Lista ordenada: " + numeros);
	}
}