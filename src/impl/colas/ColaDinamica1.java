package impl.colas;

import api.ColaTDA;
import impl.nodos.Nodo;

public class ColaDinamica1 implements ColaTDA {
    /* estrategia 1 de cola dinámica DEFAULT, los Nodos apuntan para atrás, siendo el último el que apunta a null */
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
        aux.sig = null;
        if (primero==null) {
            primero = aux;
            ultimo = aux;
        } else {
            ultimo.sig = aux;
            ultimo = aux;
        }
    }
    public void desacolar() {
        primero = primero.sig;
        if (primero==null) {
            ultimo = null;
        }
    }
    public int primero() {
        return (primero.info);
    }
    public boolean colaVacia() {
        return (primero==null);
    }
}