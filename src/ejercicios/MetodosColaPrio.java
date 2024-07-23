package ejercicios;

import api.ColaPrioTDA;

/*  MetodosColaPrio m = new MetodosColaPrio();
    ColaPrioTDA cPrio1 = new ColaPrioridadDinamica();
    ColaPrioTDA cPrio2 = new ColaPrioridadDinamica();

    cPrio1.inicializarCola();
    cPrio2.inicializarCola();        

    cPrio1.acolar(1, 2);
    cPrio1.acolar(2, 3);
    cPrio1.acolar(3, 4);

    cPrio2.acolar(11, 2);
    cPrio2.acolar(22, 3);
    cPrio2.acolar(33, 4);

    System.out.print("combinacion de colas: ");
    m.imprimir(m.combinarColas(cPrio1, cPrio2));

    // System.out.print("las colas son iguales: ");
    // System.out.println(m.sonIdenticas(cPrio1, cPrio2));
*/

public class MetodosColaPrio {

    public ColaPrioTDA combinarColas(ColaPrioTDA colaP1, ColaPrioTDA colaP2){

        while (!colaP2.colaVacia()){
            colaP1.acolar(colaP2.primero(), colaP2.prioridad());
            colaP2.desacolar();
        }

        return colaP1;
    }

    public boolean sonIdenticas(ColaPrioTDA colaP1, ColaPrioTDA colaP2) {

        while (
        !colaP1.colaVacia() 
        && !colaP2.colaVacia() 
        && colaP1.primero() == colaP2.primero() 
        && colaP1.prioridad() == colaP2.prioridad()
        ){
            colaP1.desacolar();
            colaP2.desacolar();
        }

        return colaP1.colaVacia() && colaP2.colaVacia();
    }

    public void imprimir(ColaPrioTDA cPrio, String nombre){


        System.out.print(nombre + ": [");
        while(!cPrio.colaVacia()){

            System.out.print('[');
            System.out.print(cPrio.primero());
            System.out.print(", ");
            System.out.print(cPrio.prioridad());
            System.out.print(']');

            System.out.print(", ");

            cPrio.desacolar();
        }
        System.out.println(']');
    }

}

//22 & 33 & 46