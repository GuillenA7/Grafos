import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo ABC = new Grafo();
    
        Vertice A = ABC.agregarVertice("0");
        Vertice B = ABC.agregarVertice("1");
        Vertice C = ABC.agregarVertice("2");
        Vertice D = ABC.agregarVertice("3");
        Vertice E = ABC.agregarVertice("4");
        Vertice F = ABC.agregarVertice("5");
    
        ABC.agregarArista(A, E, 4);
        ABC.agregarArista(B, E, 3);
        ABC.agregarArista(C, D, 1);
        ABC.agregarArista(C, E, 2);
        ABC.agregarArista(C, F, 3);
    
        imprimirMatrizDeAdyacenciaBinaria(ABC);
    }

    public static void imprimirMatrizDeAdyacenciaBinaria(Grafo grafo) {
        ArrayList<Vertice> vertices = grafo.getVertices();
        int numVertices = vertices.size();
    
        boolean[][] matrizAdyacencia = new boolean[numVertices][numVertices];
    
        for (int i = 0; i < numVertices; i++) {
            Vertice verticeActual = vertices.get(i);
            ArrayList<Arista> aristas = verticeActual.getAristas();
    
            System.out.print(verticeActual.getNombre() + " está conectado a: ");
            if(aristas.isEmpty()) {
                System.out.println("ningún vértice");
            } else {
                for (Arista arista : aristas) {
                    System.out.print(arista.getFin().getNombre() + " ");
                    int indiceFin = vertices.indexOf(arista.getFin());
                    matrizAdyacencia[i][indiceFin] = true;
                }
                System.out.println();
            }
        }
    
        System.out.println("Matriz de adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}