package impl.colas;

import api.ColaPrioTDA;
import impl.nodos.NodoPrioridad;

public class ColaPrioridadDinamica implements ColaPrioTDA {
    
    NodoPrioridad mayorPrioridad;

    public void inicializarCola(){
        mayorPrioridad = null;
    }

    public void acolar(int x, int prioridad) {

         // Creo el nuevo nodo que voy a acolar
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = prioridad;

        // Si la cola esta a vacia ıa o bien es mas prioritario que
        // el primero hay que agregarlo al principio
        if(mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
            nuevo.sig = mayorPrioridad;
            mayorPrioridad = nuevo;
        } 
        else{
            NodoPrioridad aux = mayorPrioridad;

            while(aux.sig != null && aux.sig.prioridad >= prioridad){
                aux = aux.sig;
            }

            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
    }

    public void desacolar() {
        mayorPrioridad = mayorPrioridad.sig;
    }

    public int primero() {
        return mayorPrioridad.info;
    }

    public int prioridad() {
        return mayorPrioridad.prioridad;
    }

    public boolean colaVacia() {
        return mayorPrioridad == null;
    }


}