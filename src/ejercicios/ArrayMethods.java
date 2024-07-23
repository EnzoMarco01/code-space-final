package ejercicios;

public class ArrayMethods { // esta clase de Java se desarrolló en la clase 05 de Programación II en la fecha 09/04/2024
    public static void insertar(int[] array, int i, int valor, int posicion) {
        /* Inserta un valor (recibido por parámetro), en una posición (recibida por parámetro), en un array (recibido por parámetro), con la ayuda de la variable índice de ese array (recibida por parámetros), corriendo todos los demás hacia atrás o hacia la derecha */
        for (int y=i ; y>posicion; y--) {
            array[y] = array[y-1];
        }
        array[posicion] = valor;
    }
}