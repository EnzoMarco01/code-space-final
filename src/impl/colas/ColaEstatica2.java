package impl.colas;

import api.ColaTDA;

public class ColaEstatica2 implements ColaTDA {
    /* esta cola usa la estrategia 2: el primero siempre en indice -1 */
    // atributos
    private int[] array;
    private int i;
    // métodos
    public void inicializarCola() {
        array = new int[100];
        i = 0;
    }
    public void acolar(int x) {
        for (int j=i; j>0; j--) {
            array[j] = array[j-1];
        }
        array[0] = x;
        i++;
    }
    public void desacolar() {
        //array[i] = 0;
        i--;
    }
    public int primero() {
        return (array[i-1]);
    }
    public boolean colaVacia() {
        return (i == 0);
    }

}