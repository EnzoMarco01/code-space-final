package impl.dic;

import api.ConjuntoTDA;
import api.DicSimpleTDA;
import impl.conjunto.ConjuntoDinamico;

public class DicSimpleEstatico implements DicSimpleTDA{

    class Elemento{
        int clave;
        int valor;
    }

    Elemento[] elementos;
    int cant;

    public void inicializarDiccionario(){
        cant = 0;
        elementos = new Elemento[100];
    }

    public void agregar(int clave, int valor){

        int pos = clave2Indice(clave);

        if (pos == -1){

            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant ++;
        }

        elementos[pos].valor = valor;
    }

    public void eliminar(int clave){

        int pos = clave2Indice(clave);

        if (pos != -1){
            elementos[pos] = elementos[cant -1];
            cant --;
        }
    }

    public int recuperar(int clave) {
        // int pos = clave2Indice(clave);
        // return elementos[pos].valor;
        return elementos[clave2Indice(clave)].valor;
    }

    public ConjuntoTDA claves(){

        ConjuntoTDA c = new ConjuntoDinamico();

        c.inicializarConjunto();

        for (int i = 0; i < cant; i++){
            c.agregar(elementos[i].clave);
        }

        return c;
    }


    private int clave2Indice(int clave){
        
        int i = cant - 1;

        while (i >= 0 && elementos[i].clave != clave){
            i--;
        }

        return i;
    }

}
