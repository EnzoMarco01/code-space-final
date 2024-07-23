package ejercicios;
import api.ConjuntoTDA;
import api.DicMultipleTDA;
import impl.dic.DicMultipleDinamico;

//69

public class MetodosDiccionario {

  public DicMultipleTDA union(DicMultipleTDA d1, DicMultipleTDA d2){
  // las claves presentes en D1 y D2, con todos los elementos asociados a cada clave.
    ConjuntoTDA c = d2.claves();

    while (!c.conjuntoVacio()) {

      int clave = c.elegir();
      ConjuntoTDA valores = d2.recuperar(c.elegir());

      while (!valores.conjuntoVacio()) {

        d1.agregar(clave, valores.elegir());
        valores.sacar(valores.elegir());
      }

      c.sacar(c.elegir());
    }

    return d1;
  }

  public DicMultipleTDA interseccionElementosPorClave(DicMultipleTDA d1, DicMultipleTDA d2){
  // las claves presentes en D1 y D2, con todos los elementos comunes a las claves coincidentes en ambos. 
    return d1;
  }

  public DicMultipleTDA interseccionClaves(DicMultipleTDA d1, DicMultipleTDA d2){
  // las claves comunes de D1 y D2, con todos los elementos asociados a cada clave.
    
  MetodosConjunto m = new MetodosConjunto();
  ConjuntoTDA c1 = d1.claves();
  ConjuntoTDA c2 = d2.claves();
  ConjuntoTDA c = m.interseccion(c1, c2);
  
  DicMultipleTDA dicNuevo = new DicMultipleDinamico();

  while (!c.conjuntoVacio()) {

    int clave = c.elegir();
    ConjuntoTDA valores1 = d1.recuperar(c.elegir());
    ConjuntoTDA valores2 = d2.recuperar(c.elegir());

    while (!valores1.conjuntoVacio() || !valores2.conjuntoVacio()) {

      if (!valores1.conjuntoVacio()) {
        dicNuevo.agregar(clave, valores1.elegir());
        valores1.sacar(valores1.elegir());
      }

      if (!valores2.conjuntoVacio()) {
        dicNuevo.agregar(clave, valores2.elegir());
        valores2.sacar(valores2.elegir());
      }
    }

    c.sacar(c.elegir());
  }

  return dicNuevo;
  }

  public DicMultipleTDA interseccion(DicMultipleTDA d1, DicMultipleTDA d2){
  // las claves comunes de D1 y D2, con todos los elementos comunes a las claves coincidentes en ambos. 
    
    return d1;
  }

  public void imprimir(DicMultipleTDA d, String nombre){
    ConjuntoTDA c = d.claves();
    System.out.println(nombre);
    while (!c.conjuntoVacio()) {

      int clave = c.elegir();
      ConjuntoTDA valores = d.recuperar(c.elegir());

      System.out.print("clave: ");
      System.out.println(clave);
      System.out.print("valores: ");

      while (!valores.conjuntoVacio()) {

        System.out.print(valores.elegir());
        System.out.print(", ");
        valores.sacar(valores.elegir());
      }
      System.out.println(' ');

      c.sacar(c.elegir());
    }
  }

}
