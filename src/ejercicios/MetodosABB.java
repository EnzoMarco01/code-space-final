package ejercicios;

import api.ABBTDA;
import api.ConjuntoTDA;
import impl.colas.ColaPrioridadDinamica;
import impl.conjunto.ConjuntoDinamico;

public class MetodosABB {

    public void preOrder(ABBTDA a) {
        if(!a.arbolVacio()){
            System.out.print(a.raiz() + ", ");
            preOrder(a.hijoIzq());
            preOrder(a.hijoDer());
        }
    }

    public void inOrder(ABBTDA a) {
        if(!a.arbolVacio()){
            inOrder(a.hijoIzq());
            System.out.print(a.raiz() + ", ");
            inOrder(a.hijoDer());
        }

    }

    public void PostOrder(ABBTDA a) {
        if(!a.arbolVacio()){
            PostOrder(a.hijoIzq());
            PostOrder(a.hijoDer());
            System.out.print(a.raiz() + ", ");
        }
    }

    public int contar(ABBTDA a) {

        return a.arbolVacio() ? 0 : (1 + contar(a.hijoIzq()) + contar(a.hijoDer()));

    }

    public int calcularProfundidad(ABBTDA a, int x) {

        if (a.arbolVacio()) {
            return 0;
        }
        else if (a.raiz() == x) {
            return 0;
        }
        else if (x < a.raiz()) {
            return  1 + calcularProfundidad(a.hijoIzq(), x);
        }
        else {
            return 1 + calcularProfundidad(a.hijoDer(), x);
        }

    }

    public boolean existeElementoEnABB(ABBTDA a, int x) {

        if (a.arbolVacio()) {
            return false;
        }
        else if (a.raiz() == x) {
            return true;
        }
        else if (a.raiz() > x) {
            return existeElementoEnABB(a.hijoIzq(), x);
        }
        else {
            return existeElementoEnABB(a.hijoDer(), x);
        }

    }

    public ConjuntoTDA nodosPares(ABBTDA a) {

        ConjuntoTDA p = new ConjuntoDinamico();
        p.inicializarConjunto();

        if (!a.arbolVacio()) {
            if (a.raiz() % 2 == 0) {
                p.agregar(a.raiz());
            }

            ConjuntoTDA pI = nodosPares(a.hijoIzq());
            ConjuntoTDA pD = nodosPares(a.hijoDer());

            while (!pI.conjuntoVacio()) { 
                int x = pI.elegir();
                p.agregar(x);
                pI.sacar(x);
            }
            while (!pD.conjuntoVacio()) { 
                int x = pD.elegir();
                p.agregar(x);
                pD.sacar(x);
            }
        }

        return p;
    }

    //----------------------------------------------------------------------
    public void padreHojas(ABBTDA a) {

        if (!a.arbolVacio()) {
            if (soyHoja(a.hijoIzq()) || soyHoja(a.hijoDer())) {
                System.out.print(a.raiz() + ", ");
            }
            padreHojas(a.hijoIzq());
            padreHojas(a.hijoDer());
        }
    }

    private boolean soyHoja(ABBTDA h) {
        if (!h.arbolVacio()) {
            return h.hijoDer().arbolVacio() && h.hijoIzq().arbolVacio();
        }
        return false;
    }
    
    //----------------------------------------------------------------------
        public static void MayorAmenor(ABBTDA A){

        ColaPrioridadDinamica colaMayor = new ColaPrioridadDinamica();
        colaMayor.inicializarCola();
        inOrderMayorMenor(A, colaMayor);

        while(!colaMayor.colaVacia()){
            System.out.println(colaMayor.primero());
            colaMayor.desacolar();
        }
    }

    private static void inOrderMayorMenor(ABBTDA a, ColaPrioridadDinamica c){
        if(!a.arbolVacio()){
            inOrderMayorMenor(a.hijoIzq(),c);
            c.acolar(a.raiz(), a.raiz());
            inOrderMayorMenor(a.hijoDer(),c);
        }
    }
    //----------------------------------------------------------------------
    /*public static ConjuntoTDA ConjuntoAbb(ABBTDA t){
        ConjuntoTDA c = new ConjuntoDinamico();
        c.InicializarConjunt();
        Conjunto(t, c);
        return c;
    }
    
    private static void Conjunto(ABBTDA t, ConjuntoTDA c){
        if(!t.ArbolVacio()){
            Conjunto(t.HijoIzq(),c);
            Conjunto(t.HijoDer(),c);
            c.Agregar(t.Raiz());
        }
    }
    public static void EsHojaElemento(ABBTDA t,int elemento){
        
        if(!t.ArbolVacio()){
            EsHojaElemento(t.HijoIzq(),elemento);
            EsHojaElemento(t.HijoDer(),elemento);
            if (t.Raiz() == elemento){
                if(esHoja(t)){
                    System.out.println("El elemento: " + elemento + " Es una hoja");
                }else{
                    System.out.println("No es una hoja");
                }
                
            }
        }
        
    }
    //---------------------------------------------------------
    public static int calcularProfundidad ( ABBTDA t, int x) {
        if (t.ArbolVacio() ){
            return 0;
        }
        else if (t.Raiz () == x) {
            return 0;
        }
        else if (t.Raiz () > x){
            return (1+calcularProfundidad (t.HijoIzq() , x));
        }
        else {
            return (1+calcularProfundidad (t.HijoDer() , x));
        }

    }
    //-------------------------------------------------------------
    public static int altura2(ABBTDA t) {
        ConjuntoTDA c2 = new ConjuntoDinamico();
        c2.InicializarConjunt();
        AgregarHojas(t, c2,t);
        
        int mayor = c2.Elegir();
        c2.Sacar(mayor);
        while(!c2.ConjuntoVacio()){
            int elemento = c2.Elegir();

            if( elemento> mayor){
                mayor=elemento;
            }

            c2.Sacar(elemento);
        }

        return mayor;
        
    }
    
    private static void AgregarHojas(ABBTDA t, ConjuntoTDA conjunto,ABBTDA t2) {
        
        if (!t.ArbolVacio()) {
            AgregarHojas(t.HijoIzq(), conjunto,t2);
            AgregarHojas(t.HijoDer(), conjunto,t2);
            if(esHoja(t)){
                conjunto.Agregar(calcularProfundidad(t2,t.Raiz()));
            }
            
        }
    }
    //-------------------------------------------------------------
    public static int Contar( ABBTDA a){
        if(a.ArbolVacio() ){
            return 0;
        }
        else {
            return (1 + Contar(a.HijoIzq()) + Contar(a.HijoDer() ));
        }
    }

    public static int Suma( ABBTDA a){
        if(a.ArbolVacio() ){
            return 0;
        }
        else {
            return (a.Raiz() + Suma(a.HijoIzq()) + Suma(a.HijoDer() ));
        }
    }

    //-------------------------------------------------------------------
    public static boolean existeElementoEnABB ( ABBTDA t, int x) {
        if (t.ArbolVacio ()){
            return false;
        }
        else if (t.Raiz () == x){
            return true;
        }
        else if (t.Raiz () > x){
            return existeElementoEnABB(t.HijoIzq() , x);
        }
        else {
            return existeElementoEnABB (t. HijoDer() , x);
        }
    }
    //-----------------------------------------------------------------
    public static int menorElemento(ABBTDA t){
        ConjuntoTDA c1 = new ConjuntoDinamico();
        c1.InicializarConjunt();
        Conjunto(t, c1);
        
        int menor = c1.Elegir();
        c1.Sacar(menor);
        while(!c1.ConjuntoVacio()){
            int elemento = c1.Elegir();

            if( elemento<menor){
                menor=elemento;
            }

            c1.Sacar(elemento);
        }

        return menor;
    }
    //------------------------------------------------
    */
}
