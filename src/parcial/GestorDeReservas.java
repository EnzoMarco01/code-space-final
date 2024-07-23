package parcial;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.DicMultipleTDA;
import api.PilaTDA;
import impl.colas.ColaDinamica1;
import impl.conjunto.ConjuntoDinamico;
import impl.dic.DicMultipleDinamico;
import impl.pilas.PilaDinamica;

public class GestorDeReservas implements GestorDeReservasTDA{

    class NodoPasajero{
        int id_pasajero;
        int nro_vuelo;
        int nro_asiento;
        int fecha;
        NodoPasajero pasajeroSig;
    }

    NodoPasajero pasajeros;

    public void Inicializar() {
        pasajeros = null;
    }

    public void agregarReserva(int id_pasajero, int nro_vuelo, int nro_asiento, int fecha) {
        
        NodoPasajero nv = id_pasajero2pasajero(id_pasajero);

        // verifico si ya existe con id_pasajero2pasajero y el if de abajo
        if (nv == null){
          nv = new NodoPasajero();
          nv.nro_vuelo = nro_vuelo;
          nv.fecha = fecha;
          nv.id_pasajero = id_pasajero;
          nv.nro_asiento = nro_asiento;

          nv.pasajeroSig = pasajeros;
          pasajeros = nv;
        }

    }

    public void eliminarReserva(int id_pasajero) {

        if (pasajeros != null){

            if (pasajeros.id_pasajero == id_pasajero){
                pasajeros = pasajeros.pasajeroSig;
            }
            else{
                NodoPasajero aux = pasajeros;

                while (aux.pasajeroSig != null && aux.pasajeroSig.id_pasajero != id_pasajero){
                aux = aux.pasajeroSig;
                }

                if (aux.pasajeroSig != null){
                aux.pasajeroSig = aux.pasajeroSig.pasajeroSig;
                }
                
            }
        }

    }

    public void actualizarAsiento(int id_pasajero, int nro_asiento) {
        NodoPasajero nv = id_pasajero2pasajero(id_pasajero);
        nv.nro_asiento = nro_asiento;
    }

    public void actualizarVuelo(int id_pasajero, int nro_vuelo) {
        NodoPasajero nv = id_pasajero2pasajero(id_pasajero);
        nv.nro_vuelo = nro_vuelo;
    }

    public void actualizarFecha(int id_pasajero, int fecha) {
        NodoPasajero nv = id_pasajero2pasajero(id_pasajero);
        nv.fecha = fecha;
    }

    public NodoPasajero obtenerReserva(int id_pasajero) {
        NodoPasajero nv = id_pasajero2pasajero(id_pasajero);
        return nv;
    }

    public PilaTDA listaDeReservas() {
        
        PilaTDA pilaReserva = new PilaDinamica();
        NodoPasajero auxPasajero = pasajeros;

        pilaReserva.inicializarPila();

        while (auxPasajero != null) {
            pilaReserva.apilar(auxPasajero.id_pasajero);
            auxPasajero = auxPasajero.pasajeroSig;
        }

        return pilaReserva;
    }

    public ColaTDA reservasPorVuelo(int vuelo) {
        
        ColaTDA colaReserva = new ColaDinamica1();
        NodoPasajero auxPasajero = pasajeros;

        colaReserva.inicializarCola();

        while (auxPasajero != null) {
            if (auxPasajero.nro_vuelo == vuelo) {
                colaReserva.acolar(auxPasajero.id_pasajero);
            }
            auxPasajero = auxPasajero.pasajeroSig;

        }

        return colaReserva;
    }

    public ConjuntoTDA reservasPorFecha(int fecha) {
        ConjuntoTDA ConjuntoReserva = new ConjuntoDinamico();
        NodoPasajero auxPasajero = pasajeros;

        ConjuntoReserva.inicializarConjunto();

        while (auxPasajero != null) {
            if (auxPasajero.fecha == fecha) {
                ConjuntoReserva.agregar(auxPasajero.id_pasajero);
            }
            auxPasajero = auxPasajero.pasajeroSig;

        }

        return ConjuntoReserva;
    }

    public DicMultipleTDA listarPorVuelo() {
        
        DicMultipleTDA dicReserva = new DicMultipleDinamico();
        NodoPasajero auxPasajero = pasajeros;

        dicReserva.inicializarDiccionario();

        while (auxPasajero != null) {
            dicReserva.agregar(auxPasajero.nro_vuelo, auxPasajero.id_pasajero);
            auxPasajero = auxPasajero.pasajeroSig;
        }

        return dicReserva;
    }

    public DicMultipleTDA listarPorFecha() {
        DicMultipleTDA dicReserva = new DicMultipleDinamico();
        NodoPasajero auxPasajero = pasajeros;

        dicReserva.inicializarDiccionario();

        while (auxPasajero != null) {
            dicReserva.agregar(auxPasajero.fecha, auxPasajero.id_pasajero);
            auxPasajero = auxPasajero.pasajeroSig;
        }

        return dicReserva;
    }

    // es como en dic multiples
    private NodoPasajero id_pasajero2pasajero(int id_pasajero){

        NodoPasajero aux = pasajeros;
    
        while (aux != null && aux.id_pasajero != id_pasajero){
          aux = aux.pasajeroSig;
        }
    
        return aux;
      }

}
