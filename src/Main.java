import api.ABBTDA;
import ejercicios.MetodosABB;
import ejercicios.MetodosConjunto;
import impl.ABB;

public class Main {
    public static void main(String[] args) throws Exception {

        MetodosConjunto mC = new MetodosConjunto();
        MetodosABB mABB = new MetodosABB();
        ABBTDA abb = new ABB();

        abb.agregarElem(20);
        abb.agregarElem(10);
        abb.agregarElem(35);
        abb.agregarElem(1);
        abb.agregarElem(18);
        abb.agregarElem(14);
        abb.agregarElem(12);
        abb.agregarElem(15);
        abb.agregarElem(35);
        abb.agregarElem(26);
        abb.agregarElem(23);
        abb.agregarElem(30);
        abb.agregarElem(40);

        // System.out.println( "\nPreOrder:\n20, 10, 1, 18, 14, 12, 15, 35, 26, 23, 30, 40");
        // mABB.preOrder(abb);
        // System.out.println( "\nInOrder:\n1, 10, 12, 14, 15, 18, 20, 23, 26, 30, 35, 40");
        // mABB.inOrder(abb);
        System.out.println( "\nPostOrder:\n1, 12, 15, 14, 18, 10, 23, 30, 26, 40, 35, 20");
        mABB.PostOrder(abb);
        
        System.out.println("\ncontar: " + mABB.contar(abb));
        System.out.println("profundidad: " + mABB.calcularProfundidad(abb, 23));
        System.out.println("existe X: " + mABB.existeElementoEnABB(abb, 23));
        mC.imprimir(mABB.nodosPares(abb), "nodos pares");
        System.out.print("padre de hojas: ");
        mABB.padreHojas(abb);
    }
}

/*
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
 */