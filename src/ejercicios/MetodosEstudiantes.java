package ejercicios;

import api.ConjuntoTDA;
import api.DicMultipleTDA;

public class MetodosEstudiantes {

  public void imprimir(DicMultipleTDA d){
    ConjuntoTDA c = d.claves();

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
