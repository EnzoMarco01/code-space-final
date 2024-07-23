package impl.dic;

import api.ConjuntoTDA;
import api.DicMultipleTDA;
import impl.conjunto.ConjuntoDinamico;

/*      MetodosDiccionario m = new MetodosDiccionario();
        DicMultipleTDA d1 = new DicMultipleDinamico();
        DicMultipleTDA d2 = new DicMultipleDinamico();

        d1.inicializarDiccionario();
        d2.inicializarDiccionario();

        d1.agregar(4, 3);
        d1.agregar(4, 1);
        d1.agregar(9, 99);

        d2.agregar(8, 7);
        d2.agregar(8, 1);
        d2.agregar(9, 5);

        // m.imprimir(m.union(d1, d2)); 
        // m.imprimir(m.interseccionClaves(d1, d2)); 
        m.imprimir(d1); 
*/

public class DicMultipleDinamico implements DicMultipleTDA{

  class NodoClave{
    int clave;
    NodoValor valores;
    NodoClave sigClave;
  }

  class NodoValor{
    int valor;
    NodoValor sigValor;
  }

  NodoClave origen;

  public void inicializarDiccionario(){
    origen = null;
  }

  public void agregar(int clave, int valor){

    NodoClave nc = clave2NodoClave(clave);

    if (nc == null){
      nc = new NodoClave();
      nc.clave = clave;
      nc.sigClave = origen;
      origen = nc;
    }

    NodoValor aux = nc.valores;

    while (aux != null && aux.valor != valor){
      aux = aux.sigValor;
    }

    if (aux == null){
      NodoValor nv = new NodoValor();
      nv.valor = valor;
      nv.sigValor = nc.valores;
      nc.valores = nv;
    }
  }

  public void eliminarValor(int clave, int valor){

    if (origen != null){

      if (origen.clave == clave){

        eliminarValorEnNodo(origen, valor);

        if (origen.valores == null) {
          origen = origen.sigClave;
        }
      }
      else{

        NodoClave aux = origen;

        while (aux.sigClave != null && aux.sigClave.clave != clave) {
          aux = aux.sigClave;
        }

        if (aux.sigClave != null) {
          
          eliminarValorEnNodo(aux.sigClave, valor);

          if (aux.sigClave.valores == null) {
            aux.sigClave = aux.sigClave.sigClave;
          }
        }
      }
    }
  }

  public void eliminar(int clave){

    if (origen != null) {
      
      if (origen.clave == clave) {
        origen = origen.sigClave;
      }
      else{

        NodoClave aux = origen;

        while (aux.sigClave != null && aux.sigClave.clave != clave) {
          aux = aux.sigClave;
        }

        if (aux.sigClave != null) {
          aux.sigClave = aux.sigClave.sigClave;
        }
      }
    }
  }

  public ConjuntoTDA recuperar(int clave){

    NodoClave n = clave2NodoClave(clave);
    ConjuntoTDA c = new ConjuntoDinamico();

    c.inicializarConjunto();

    if (n != null) {
      
      NodoValor aux = n.valores;

      while (aux != null) {
        c.agregar(aux.valor);
        aux = aux.sigValor;
      }
    }
    return c;
  }

  public ConjuntoTDA claves(){

    NodoClave aux = origen;
    ConjuntoTDA c = new ConjuntoDinamico();

    c.inicializarConjunto();

    while (aux != null) {
      c.agregar(aux.clave);
      aux = aux.sigClave;
    }

    return c;
  }

  private NodoClave clave2NodoClave(int clave){

    NodoClave aux = origen;

    while (aux != null && aux.clave != clave){
      aux = aux.sigClave;
    }

    return aux;
  }

  private void eliminarValorEnNodo(NodoClave nodo, int valor){

    if (nodo.valores.valor == valor){
      nodo.valores = nodo.valores.sigValor;
    }
    else{
      NodoValor aux = nodo.valores;

      while (aux.sigValor != null && aux.sigValor.valor != valor) {
        aux = aux.sigValor;
      }

      if (aux.sigValor != null) {
        aux.sigValor = aux.sigValor.sigValor;
      }
    }
  }

}
