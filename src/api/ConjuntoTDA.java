package api;

public interface ConjuntoTDA {

    void inicializarConjunto();

    boolean conjuntoVacio();

    void agregar(int x);

    int elegir();

    void sacar(int x);

    boolean pertenece(int x);

}

/*
 Una implementacion particular de conjuntos es la que denominamos conjunto de
 universo acotado, en donde tenemos un arreglo cuyas posiciones representan la
 presencia o ausencia de un valor en el conjunto. Es decir, si consideramos un
 conjunto de 15 elementos (del 0 al 14), tendremos un arreglo de 15 posiciones,
 en donde tendremos por ejemplo un 1 en la posicion 5 si es que el elemento 5
 pertenece al conjunto, y 0 en caso contrario. Esta implementacion tiene limita
ciones en cuanto a los valores que puede tomar el conjunto, pero puede ser util
 para aquellos casos en donde esta limitaci´on no sea un problema ya que tenemos
 una manera mas eficiente de agregar o eliminar un valor del arreglo, ası como de
 conocer si un cierto valor pertenece al mismo. Todas las operaciones sobre este
 tipo de implementacion para el conjunto son de costos constantes.
*/ 