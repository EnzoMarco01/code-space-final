package impl.colas;

import api.ColaPrioTDA;

public class ColaPrioEstaticaObj implements ColaPrioTDA{

  class Elemento{
    int valor;
    int prioridad;
  }

  Elemento[] elementos;
  int indice;

  public void inicializarCola() {
    indice = 0;
    elementos = new Elemento[100];
  }

  public void acolar(int x, int prioridad) {
    int j = indice;
    //desplaza a derecha los elementos de la cola mientras
    //estos tengan mayor o igual prioridad que la de x
    for (; j > 0 && elementos[j-1].prioridad >= prioridad; j--){
    elementos[j] = elementos[j-1];
    }
    elementos[j]= new Elemento();
    elementos[j].valor = x;
    elementos[j].prioridad = prioridad;
    indice++;
  }

  public void desacolar() {
    elementos[indice - 1] = null;
    indice--;
  }

  public int primero() {
    return elementos[indice-1].valor;
  }

  public boolean colaVacia() {
    return indice == 0;
  }

  public int prioridad() {
    return elementos[indice-1].prioridad;
  }

}
