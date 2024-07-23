package impl.colas;

import api.ColaTDA;
import impl.nodos.Nodo;


public class ColaDinamica2 implements ColaTDA {
    /* estrategia 2 de cola dinámica, los Nodos apuntan para adelante, siendo el primero el que apunta a null */
    // atributes
    Nodo primero;
    Nodo ultimo;
    // methods
    public void inicializarCola() {
        primero = null;
        ultimo = null;
    }
    public void acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = ultimo;
        ultimo = aux;
    }
    public void desacolar() {
        Nodo aux = ultimo;
        while (aux.sig.sig !=null) {
            aux = aux.sig;
        }
        aux.sig = null;
        primero = aux;
    }
    public int primero() {
        return (primero.info);
    }
    public boolean colaVacia() {
        return (primero==null);
    }
}