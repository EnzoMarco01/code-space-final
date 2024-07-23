package ejercicios;

import api.ConjuntoTDA;
import api.GrafoTDA;
import java.util.ArrayList;

public class MetodosGrafo {

  public void imprimir(GrafoTDA grafo) {

    MetodosConjunto mc = new MetodosConjunto();
    ConjuntoTDA vertices = grafo.vertices();
    ArrayList<Integer> aVertices = new ArrayList<>();

    int vertice;
    System.out.print("V - ");
    while(!vertices.conjuntoVacio()){
      vertice = vertices.elegir();

      aVertices.add(vertice);//arralist

      vertices.sacar(vertice);
      System.out.print(vertice);
      if (!vertices.conjuntoVacio()) {
        System.out.print(" - ");
      }
    }
    
    vertices = grafo.vertices();
    String linea = "\n";
    while(!vertices.conjuntoVacio()){
      vertice = vertices.elegir();
      linea += vertice + " - ";
      for (int v : aVertices){
        if (grafo.existeArista(vertice, v)) {
          linea += grafo.pesoArista(vertice, v) + " - ";
        }
        else{
          linea += "0 - ";
        }
      }
      System.out.println(linea);
      vertices.sacar(vertice);
      linea = "";
    }
  }

}
