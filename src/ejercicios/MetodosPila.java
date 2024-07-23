package ejercicios;

import api.PilaTDA;
import impl.nodos.Nodo;
import impl.pilas.PilaDinamica;
import impl.pilas.PilaEstatica;



public class MetodosPila {
    public static PilaTDA pasarPilaInverso(PilaTDA pilaOriginal){

        PilaTDA pilaNueva = new PilaEstatica();
        pilaNueva.inicializarPila();

        while (!pilaOriginal.pilaVacia()){

            pilaNueva.apilar(pilaOriginal.tope());
            System.out.print(pilaOriginal.tope());

            pilaOriginal.desapilar();
        }
        System.out.println(' ');

        return pilaNueva;
    }

    public PilaTDA copiarPila (PilaTDA pilaOriginal){

        PilaTDA pilaNueva = new PilaEstatica();
        pilaNueva.inicializarPila();
        PilaTDA pilaAux = pasarPilaInverso(pilaOriginal);
        System.out.println(' ');

        while (!pilaAux.pilaVacia()){
            pilaNueva.apilar(pilaAux.tope());
            pilaOriginal.apilar(pilaAux.tope());

            System.out.print(pilaAux.tope());

            pilaAux.desapilar();
        }
        System.out.println();

        return pilaNueva;
    }

    public int contarPila (PilaTDA pilaOriginal){
        int contador = 0;

        while (!pilaOriginal.pilaVacia()){
            contador++;
            pilaOriginal.desapilar();
        }

        return contador;
    }

    public int sumarPila (PilaTDA pilaOriginal){
        int suma = 0;

        while (!pilaOriginal.pilaVacia()){
            suma += pilaOriginal.tope();
            pilaOriginal.desapilar();
        }

        return suma;
    }

    public int promedioPila (PilaTDA pilaOriginal){

        PilaTDA pilaNueva = copiarPila(pilaOriginal);

        return sumarPila(pilaOriginal) / contarPila(pilaNueva);
    }

    public void imprimirPila(PilaTDA pila){

        System.out.print('[');
        while(!pila.pilaVacia()){
            System.out.print(pila.tope());
            System.out.print(", ");

            pila.desapilar();
        }
        System.out.println(']');
    }

}

//        MetodosPila ej2 = new MetodosPila();
//        PilaTDA pila = new PilaEstatica();

//        pila.InicializarPila();
//        pila.Apilar(1);
//        pila.Apilar(2);
//        pila.Apilar(3);

//        ej2.copiarPila(ej2.pasarPilaInverso(pila));
//        System.out.println(ej2.sumarPila(pila));
//        System.out.println(ej2.contarPila(pila));
//        System.out.println(ej2.promedioPila(pila));