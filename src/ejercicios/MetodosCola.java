package ejercicios;

import api.ColaTDA;
import api.PilaTDA;
import impl.colas.ColaEstatica1;
import impl.pilas.PilaEstatica;

public class MetodosCola {

    public static ColaTDA pasarCola(ColaTDA colaOriginal){

        ColaTDA colaNueva = new ColaEstatica1();
        ColaTDA colaCopia = new ColaEstatica1();

        colaNueva.inicializarCola();
        colaCopia.inicializarCola();

        while (!colaOriginal.colaVacia()) {
            int elemento = colaOriginal.primero();
            colaNueva.acolar(elemento);
            colaCopia.acolar(elemento);

            colaOriginal.desacolar();
        }

        while (!colaCopia.colaVacia()) {
            int elemento = colaCopia.primero();
            colaOriginal.acolar(elemento);

            colaCopia.desacolar();
        }

        // Return the copied queue
        return colaNueva;
    }

    public static ColaTDA invertirColaConPila(ColaTDA colaOriginal){
        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        while (!colaOriginal.colaVacia()){
            pila.apilar(colaOriginal.primero());

            colaOriginal.desacolar();
        }

        while (!pila.pilaVacia()){
            colaOriginal.acolar(pila.tope());

            pila.desapilar();
        }

        return colaOriginal;
    }

    public static ColaTDA invertirCola(ColaTDA colaOriginal){

        if (!colaOriginal.colaVacia()){
            int aux = colaOriginal.primero();
            colaOriginal.desacolar();

            invertirCola(colaOriginal);

            colaOriginal.acolar(aux);
        }

        return colaOriginal;
    }

    public static Boolean coincideFinal(ColaTDA cola1, ColaTDA cola2){

        boolean respuesta;

        invertirCola(cola1);
        invertirCola(cola2);

        respuesta = cola1.primero() == cola2.primero();

        invertirCola(cola1);
        invertirCola(cola2);

        return respuesta;

    }

    //MODIFICA la cola original
    public static Boolean esCapicua(ColaTDA colaorginal){
        ColaTDA colaAux = invertirCola(pasarCola(colaorginal));

        while (colaorginal.primero() == colaAux.primero() && !colaorginal.colaVacia()){
            colaorginal.desacolar();
            colaAux.desacolar();
            }

        return colaorginal.primero() == colaAux.primero();
    }

    public static Boolean esLaInversa(ColaTDA cola1, ColaTDA cola2){
        ColaTDA colaNormal = pasarCola(cola1);
        ColaTDA colaInvertida = invertirCola(pasarCola(cola2));

        while (!colaNormal.colaVacia() && !colaInvertida.colaVacia()){
            if(colaNormal.primero() != colaInvertida.primero()){
                return false;
            }

            colaNormal.desacolar();
            colaInvertida.desacolar();
        }

        return colaNormal.colaVacia() == colaInvertida.colaVacia();
    }

    public void imprimir(ColaTDA cola, String nombre){

        System.out.print(nombre + ": [");
        while(!cola.colaVacia()){

            System.out.print(cola.primero());
            System.out.print(", ");
            cola.desacolar();
            
        }
        System.out.println(']');
    }


}

//        System.out.println(mCola.esCapicua(cola));
//        System.out.println(mCola.esLaInversa(cola, cola2));
//        System.out.println(mCola.coincideFinal(cola, cola2));
//        mCola.invertirCola(cola);