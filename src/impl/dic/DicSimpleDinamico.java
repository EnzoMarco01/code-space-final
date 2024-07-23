package impl.dic;

import api.ConjuntoTDA;
import api.DicSimpleTDA;
import impl.conjunto.ConjuntoDinamico;

public class DicSimpleDinamico implements DicSimpleTDA{

  class NodoClave{
    int  clave;
    int valor;
    NodoClave sigClave;
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

    nc.valor = valor;

  }

  public void eliminar(int clave){

    if (origen != null){

      if (origen.clave == clave){
        origen = origen.sigClave;
      }
      else{
        NodoClave aux = origen;

        while (aux.sigClave != null && aux.sigClave.clave != clave){
          aux = aux.sigClave;
        }

        if (aux.sigClave != null){
          aux.sigClave = aux.sigClave.sigClave;
        }

      }
    }
  }

  public int recuperar(int clave){
    // NodoClave n = clave2NodoClave(clave);
    // return n.valor;
    return clave2NodoClave(clave).valor;
  }

  public ConjuntoTDA claves(){

    ConjuntoTDA c = new ConjuntoDinamico();
    NodoClave aux = origen;

    c.inicializarConjunto();

    while (aux != null){
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

}
