public class Main {
    public static void main(String[] args) {
        //start main graph
            Grafo ABC = new Grafo();
    
            Vertice A = ABC.agregarVertice("A");
            Vertice B = ABC.agregarVertice("B");
            Vertice C = ABC.agregarVertice("C");
    
            ABC.agregarArista(A, B, 1);
            ABC.agregarArista(A, C, 5);
            ABC.agregarArista(C, B, 3);
            ABC.print();
        }
}