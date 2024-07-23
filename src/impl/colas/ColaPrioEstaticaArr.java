package impl.colas;

import api.ColaPrioTDA;

// en esta estrategia se emplean ARREGLOS EN PARALELO
// en esta estrategia se emplean ARREGLOS EN PARALELO

public class ColaPrioEstaticaArr implements ColaPrioTDA {
    /* esta cola usa la estrategia 1: el primero siempre en el índice 0 */
    // atributes
    int[] elementos;
    int[] prioridades;
    int indice;

    // methods
    public void inicializarCola() {
        indice = 0;
        elementos = new int[100];
        prioridades = new int[100];
    }

    public void acolar(int x, int prioridad) {
        int j = indice;

        for (; j < 0 && prioridades[j-1] >= prioridad; j--){
            elementos[j] = elementos[j-1];
            prioridades[j] = prioridades[j-1];
        }

        elementos[j] = x;
        prioridades[j] = prioridad;
        indice++;
    }

    public void desacolar() {
        indice--;
    }

    public int primero() {
        return (elementos[indice-1]);
    }

    public boolean colaVacia() {
        return (indice == 0);
    }

    public int prioridad() {
        return (prioridades[indice-1]);
    }


}