package ejercicios;
import api.ConjuntoTDA;


/*      MetodosConjunto m = new MetodosConjunto();
        ConjuntoTDA uwu;
        ConjuntoTDA c1 = new ConjuntoDinamico();
        ConjuntoTDA c2 = new ConjuntoDinamico();

        c1.inicializarConjunto();
        c2.inicializarConjunto();        

        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);
        c1.agregar(5);
        c1.agregar(6);


        c2.agregar(1);
        c2.agregar(2);
        c2.agregar(3);
        c2.agregar(7);
        c2.agregar(99);

        System.out.print("interseccion: ");
        uwu = m.interseccion(c1, c2);

        // System.out.print("union: ");
        // uwu = m.union(c1, c2);

        // System.out.print("diferencia: ");
        // uwu = m.diferencia(c1, c2);

        m.imprimir(uwu);
 */
public class MetodosConjunto {

  public ConjuntoTDA interseccion(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){

    int valor1;

    if (!conjunto1.conjuntoVacio()){

      valor1 = conjunto1.elegir();
      conjunto1.sacar(valor1);

      interseccion(conjunto1, conjunto2);

      if (conjunto2.pertenece(valor1)){
        conjunto1.agregar(valor1);
      }
    }
  

    return conjunto1;
  }

  public ConjuntoTDA union(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){

    while (!conjunto2.conjuntoVacio()){
      conjunto1.agregar(conjunto2.elegir());
      conjunto2.sacar(conjunto2.elegir());
    }

    return conjunto1;
  }

  public ConjuntoTDA diferencia(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){

    while (!conjunto2.conjuntoVacio()){
      conjunto1.sacar(conjunto2.elegir());
      conjunto2.sacar(conjunto2.elegir());
    }

    return conjunto1;
  }

  public void imprimir(ConjuntoTDA conjunto, String nombre){

    System.out.print(nombre + ": [");
    while(!conjunto.conjuntoVacio()){
        System.out.print(conjunto.elegir());
        System.out.print(", ");

        conjunto.sacar(conjunto.elegir());
    }
    System.out.println(']');
  }
}
