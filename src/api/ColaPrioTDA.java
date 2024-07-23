package api;

public interface ColaPrioTDA {
    public void inicializarCola(); // none
    public void acolar(int x, int prioridad); // la cola debe estar inicializada
    public void desacolar(); // la cola debe no estar vacía
    public int primero(); // la cola debe no estar vacía
    public int prioridad(); // la cola debe no estar vacía
    public boolean colaVacia(); // la cola debe estar inicializada
}