public class Main {
    public static void main(String[] args) {
        Grafo ABC = new Grafo(8); // Crear el grafo con n vértices
        
        // Agregar vértices
        Vertice A = new Vertice("A");
        Vertice B = new Vertice("B");
        Vertice C = new Vertice("C");
        Vertice D = new Vertice("D");
        Vertice E = new Vertice("E");
        Vertice F = new Vertice("F");
        Vertice G = new Vertice("G");
        Vertice H = new Vertice("H");
        
        ABC.agregarVertice(A);
        ABC.agregarVertice(B);
        ABC.agregarVertice(C);
        ABC.agregarVertice(D);
        ABC.agregarVertice(E);
        ABC.agregarVertice(F);
        ABC.agregarVertice(G);
        ABC.agregarVertice(H);
        
        // Agregar aristas
        ABC.agregarArista(A, B, 2);
        ABC.agregarArista(A, F, 1);
        ABC.agregarArista(B, C, 2);
        ABC.agregarArista(B, D, 2);
        ABC.agregarArista(B, E, 4);
        ABC.agregarArista(C, E, 3);
        ABC.agregarArista(C, H, 1);
        ABC.agregarArista(D, E, 4);
        ABC.agregarArista(D, F, 3);
        ABC.agregarArista(E, G, 7);
        ABC.agregarArista(F, G, 5);
        ABC.agregarArista(G, H, 3);
        
        // Imprimir grafo
        ABC.imprimirGrafo();
        
        // Ejecutar algoritmo de Dijkstra
        ABC.dijkstra(A, H);
    }
}