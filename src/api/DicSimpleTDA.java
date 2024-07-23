package api;

public interface DicSimpleTDA {

    void inicializarDiccionario();

    void agregar(int clave, int valor);

    void eliminar(int clave);

    int recuperar(int clave);

    ConjuntoTDA claves();

}
