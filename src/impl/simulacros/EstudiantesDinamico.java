package impl.simulacros;

import api.EstudiantesTDA;
import api.PilaTDA;
import impl.pilas.PilaDinamica;

/*      MetodosPila m = new MetodosPila();
        EstudiantesTDA l = new EstudiantesDinamico();

        l.agregarAlumno(2002, 8);
        l.agregarAlumno(2002, 6);
        l.agregarAlumno(2002, 10);

        l.agregarAlumno(1999, 4);
        l.agregarAlumno(1999, 2);        
        
        l.agregarAlumno(2001, 4);
        l.agregarAlumno(2001, 2);

        l.eliminarAlumno(1999);

        System.out.print("notas 2002: ");
        m.imprimirPila(l.notas(2002));

        System.out.print("promedio 2002: ");
        System.out.println(l.promedioNotasAlumno(2002));

        System.out.print("aprobo 2002: ");
        System.out.println(l.aprobo(2002));

        System.out.print("aprobo 2001: ");
        System.out.println(l.aprobo(2001));
        
        l.imprimir();
 */
public class EstudiantesDinamico implements EstudiantesTDA{

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

  public void inicializarEstudiantes(){
    origen = null;
  }

  public void agregarAlumno(int legajo, int nota){

    NodoClave nc = clave2NodoClave(legajo);

    if (nc == null){
      nc = new NodoClave();
      nc.clave = legajo;
      nc.sigClave = origen;
      origen = nc;
    }

      NodoValor nv = new NodoValor();
      nv.valor = nota;
      nv.sigValor = nc.valores;
      nc.valores = nv;
  }

  public void eliminarAlumno(int legajo) {
    if (origen != null) {
    
      NodoClave aux = origen;

      if (origen.clave == legajo) {
        origen = origen.sigClave;
      }
      else{
        while (aux.sigClave != null && aux.sigClave.clave != legajo) {
          aux = aux.sigClave;
        }

        if (aux.sigClave != null) {
          aux.sigClave = aux.sigClave.sigClave;
        }
      }
    }
  }

  public int promedioNotasAlumno(int legajo) {
    
    int promedio = 0;
    int notas = 0;
    PilaTDA p = notas(legajo);

    while(!p.pilaVacia()){
      promedio += p.tope();
      notas++;
      p.desapilar();
    }

    return (notas != 0 ? promedio/notas : 0);
  }

  public PilaTDA notas(int legajo) {

    NodoClave pos = clave2NodoClave(legajo);
    PilaTDA pila = new PilaDinamica();

    pila.inicializarPila();

    if (pos != null) {

      NodoValor aux = pos.valores;

      while (aux != null){
        pila.apilar(aux.valor);
        aux = aux.sigValor;
      }
    }

    return pila;
  }
  
  public int promedioNotasTodos() {
    throw new UnsupportedOperationException("Unimplemented method 'promedioNotasTodos'");
  }

  public boolean aprobo(int legajo) {
    return promedioNotasAlumno(legajo) > 4;
  }

  private NodoClave clave2NodoClave(int clave){

    NodoClave aux = origen;

    while (aux != null && aux.clave != clave){
      aux = aux.sigClave;
    }

    return aux;
  }

  public void imprimir(){

    while (origen != null) {

        System.out.print("legajo: ");
        System.out.println(origen.clave);
        System.out.print("notas: ");

        while (origen.valores != null) {

          System.out.print(origen.valores.valor);
          System.out.print(", ");
          origen.valores = origen.valores.sigValor;
        }
        System.out.println(' ');

        origen = origen.sigClave;

    }
  }
}
