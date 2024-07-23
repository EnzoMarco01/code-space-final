package impl.pilas;
import api.PilaTDA;

public class PilaEstatica implements PilaTDA {
    // atributos
    int[] array;
    int i;
    // métodos
    public void inicializarPila() {
        array = new int[100];
        i = 0;
    }
    public void apilar(int x) {
        array[i] = x;
        i++;
    }
    public void desapilar() {
        i--;
    }
    public int tope() {
        return (array[i-1]);
    }
    public boolean pilaVacia() {
        return (i==0);
    }
}