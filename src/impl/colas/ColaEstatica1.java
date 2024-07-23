package impl.colas;

import api.ColaTDA;

public class ColaEstatica1 implements ColaTDA {
    /* esta cola usa la estrategia 1: el primero siempre en el indice 0 */
    // atributos
    int[] array;
    int i;
    // métodos
    public void inicializarCola() {
        array = new int[10];
        i = 0;
    }
    public void acolar(int x) {
        array[i] = x;
        i++;
    }
    public void desacolar() {
        int largo = i-1;
        for (int n=0; n<largo; n++) {
            array[n] = array[n+1];
        }
        i--;
    }
    public int primero() {
        return (array[0]);
    }
    public boolean colaVacia() {
        return (i == 0);
    }

}