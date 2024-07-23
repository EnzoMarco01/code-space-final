package parcial;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.DicMultipleTDA;
import api.PilaTDA;
import parcial.GestorDeReservas.NodoPasajero;

public interface GestorDeReservasTDA {
    void Inicializar();

    void agregarReserva(int id_pasajero, int nro_vuelo, int nro_asiento, int fecha);

    void eliminarReserva(int id_pasajero);

    void actualizarAsiento(int id_pasajero, int nro_asiento);

    void actualizarVuelo(int id_pasajero, int nro_vuelo);

    void actualizarFecha(int id_pasajero, int fecha);

    NodoPasajero obtenerReserva(int id_pasajero);

    PilaTDA listaDeReservas();

    ColaTDA reservasPorVuelo(int vuelo);

    ConjuntoTDA reservasPorFecha(int fecha);

    DicMultipleTDA listarPorVuelo();

    DicMultipleTDA listarPorFecha();


}
