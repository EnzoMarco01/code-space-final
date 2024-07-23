package impl;

import api.ColaTDA;
import api.PilaColaParesTDA;
import impl.nodos.Nodo;

/* PilaColaParesTDA simu = new PilaColaParesDinamica();

simu.inicializar();

for (int i = 0; i < 10; i++){
    System.out.println(i);
    simu.guardar(i);
}

simu.guardar(99);

for (int i = 0; i < 20;i = i+2){
    simu.guardar(i);
}

System.out.print("guardar: ");
simu.imprimir();

for (int i = 0; i < 7; i++){
    simu.sacar();
}
System.out.print("sacar: ");
simu.imprimir();

System.out.print("mostrar: ");
System.out.println(simu.mostrar());

System.out.print("esta vacia: ");
System.out.println(simu.vacia());
*/

public class PilaColaParesDinamica implements PilaColaParesTDA{

    Nodo nodoPrimero;
    Nodo nodoUltimo;
    int cantPares;

    public void inicializar(){
        nodoPrimero = null;
        nodoUltimo = null;
        cantPares = 0;
    }

    public void guardar(int x){
        cantPares += esPar(x) ? 1 : 0;

        Nodo aux = new Nodo();
        aux.info = x;

        if (cantPares <= 10){
            aux.sig = null;

            if (nodoPrimero == null) {
                nodoPrimero = aux;
                nodoUltimo = aux;

            } else {
                nodoUltimo.sig = aux;
                nodoUltimo = aux;
            }
        }
        else{
            aux.sig = nodoPrimero;
            nodoPrimero = aux;
        }
    }

    public void sacar(){

        nodoPrimero = nodoPrimero.sig;

        if (nodoPrimero.sig == null && cantPares <= 10) {
            nodoUltimo = null;
        }

    }

    public int mostrar() {
        return (nodoPrimero.info);
    }

    public boolean vacia() {
        return (nodoPrimero==null);
    }

    public void imprimir() {

        Nodo aux = nodoPrimero;

        System.out.print('[');
        while(aux != null){
            System.out.print(aux.info);
            System.out.print(", ");

            aux = aux.sig;
        }
        System.out.println(']');
    }

    private boolean esPar(int x){
        return x%2 == 0;
    }
}
