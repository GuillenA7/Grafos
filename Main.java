import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo ABC = new Grafo();
    
        Vertice A = ABC.agregarVertice("A");
        Vertice B = ABC.agregarVertice("B");
        Vertice C = ABC.agregarVertice("C");
        Vertice D = ABC.agregarVertice("D");
        Vertice E = ABC.agregarVertice("E");
        Vertice F = ABC.agregarVertice("F");
        Vertice G = ABC.agregarVertice("G");
        Vertice H = ABC.agregarVertice("H");
    
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
    
        imprimirMatrizDeAdyacenciaBinaria(ABC);
    }

    public static void imprimirMatrizDeAdyacenciaBinaria(Grafo grafo) {
        ArrayList<Vertice> vertices = grafo.getVertices();
        int numVertices = vertices.size();
    
        boolean[][] matrizAdyacencia = new boolean[numVertices][numVertices];
        int[][] pesos = new int[numVertices][numVertices];
    
        for (int i = 0; i < numVertices; i++) {
            Vertice verticeActual = vertices.get(i);
            ArrayList<Arista> aristas = verticeActual.getAristas();
    
            System.out.print(verticeActual.getNombre() + " está conectado a: ");
            if(aristas.isEmpty()) {
                System.out.println("ningún vértice");
            } else {
                for (Arista arista : aristas) {
                    System.out.print(arista.getFin().getNombre() + " (Peso: " + arista.getPeso() + ") ");
                    int indiceFin = vertices.indexOf(arista.getFin());
                    matrizAdyacencia[i][indiceFin] = true;
                    pesos[i][indiceFin] = arista.getPeso();
                }
                System.out.println();
            }
        }
    
        System.out.println("\nMatriz de adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j]) {
                    System.out.print(pesos[i][j] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}