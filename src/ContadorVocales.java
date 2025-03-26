/*
 * March 25, 2025.
 * Contar la Cantidad de vocales en una cadena. 
 * PR|ContarVoc(cad,n) = contarVoc(cad, n-1) + 1           Cn es vocal          | n > 0
 * PB|ContarVoc(cad,n) = contarVoc(cad, n-1)               Cn NO es vocal       | n > 0
 * CC|ContarVoc(cad,n) = 0
 */

import java.util.Scanner;

public class ContadorVocales {

    /**
     * Overloading the method
     * 
     * @param cadena La cadena de texto a ingresar para contar vocales
     */
    public int contarVoc(String cadena) {
        return contarVoc(cadena, cadena.length());
    }

    /**
     * Recursive method
     * 
     * @param cadena
     * @param n      size de la cadena
     */
    private int contarVoc(String cadena, int n) {
        if (n == 0) {
            return 0;
        } else {
            if (esVocal(cadena.charAt(n - 1))) {
                return contarVoc(cadena, n - 1) + 1;
            } else {
                return contarVoc(cadena, n - 1);
            }
        }
    }

    /*
     * Método para saber si un carácter es vocal o no.
     */
    private boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        /** usando indexOf()
         * return "aeiouAEIOU".indexOf(c) != -1; 
         */ 
    }

    // Main method to test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContadorVocales contador = new ContadorVocales();

        // Solicitar entrada al usuario
        System.out.print("Ingrese una cadena de texto para contar sus vocales: ");
        String input = scanner.nextLine(); // Leer la cadena ingresada por el usuario

        // Contar vocales e imprimir el resultado
        int cantidadVocales = contador.contarVoc(input);
        System.out.println("Cantidad de vocales: " + cantidadVocales);

        scanner.close(); // Cerrar el Scanner
    }
}
