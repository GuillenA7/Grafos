import java.util.*;

class Grafo {
    List<Vertice> vertices;
    List<Arista> aristas;
    int[][] matrizAdyacencia;
    
    public Grafo(int numVertices) {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
        matrizAdyacencia = new int[numVertices][numVertices];
    }
    
    public void agregarVertice(Vertice v) {
        vertices.add(v);
    }
    
    public void agregarArista(Vertice inicio, Vertice fin, int peso) {
        Arista nuevaArista = new Arista(inicio, fin, peso);
        aristas.add(nuevaArista);
        int indiceInicio = vertices.indexOf(inicio);
        int indiceFin = vertices.indexOf(fin);
        matrizAdyacencia[indiceInicio][indiceFin] = peso;
        matrizAdyacencia[indiceFin][indiceInicio] = peso;
    }
    
    public void imprimirGrafo() {
        // Imprimir conexiones de vértices
        System.out.println("\nConexiones de vértices:");
        for (Vertice v : vertices) {
            System.out.print("Vertice " + v.nombre + " está conectado a: ");
            for (Arista a : aristas) {
                if (a.inicio == v || a.fin == v) {
                    Vertice vecino = (a.inicio == v) ? a.fin : a.inicio;
                    System.out.print("(" + vecino.nombre + ", peso: " + a.peso + ") ");
                }
            }
            System.out.println();
        }

        // Imprimir matriz de adyacencia
        System.out.println("\nMatriz de adyacencia:");
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void dijkstra(Vertice inicio, Vertice fin) {
        Map<Vertice, Integer> distancia = new HashMap<>();
        Map<Vertice, Vertice> previo = new HashMap<>();
        PriorityQueue<Vertice> colaPrioridad = new PriorityQueue<>(vertices.size(), Comparator.comparing(distancia::get));
        
        // Inicialización
        for (Vertice v : vertices) {
            if (v == inicio) {
                distancia.put(v, 0);
            } else {
                distancia.put(v, Integer.MAX_VALUE);
            }
            colaPrioridad.add(v);
        }
        
        // Algoritmo
        while (!colaPrioridad.isEmpty()) {
            Vertice u = colaPrioridad.poll();
            if (u == fin) {
                break;
            }
            for (Vertice vecino : obtenerVecinos(u)) {
                int pesoArista = obtenerPeso(u, vecino);
                int nuevaDistancia = distancia.get(u) + pesoArista;
                if (nuevaDistancia < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDistancia);
                    previo.put(vecino, u);
                    colaPrioridad.remove(vecino);
                    colaPrioridad.add(vecino);
                }
            }
        }
        
        // Imprimir el camino más corto
        Stack<Vertice> camino = new Stack<>();
        Vertice actual = fin;
        while (previo.containsKey(actual)) {
            camino.push(actual);
            actual = previo.get(actual);
        }
        camino.push(inicio);
        
        System.out.println("\nCamino más corto desde " + inicio.nombre + " hasta " + fin.nombre + ":");
        while (!camino.isEmpty()) {
            System.out.print(camino.pop().nombre);
            if (!camino.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println("\nDistancia total: " + distancia.get(fin) + "\n");
    }
    
    private List<Vertice> obtenerVecinos(Vertice v) {
        List<Vertice> vecinos = new ArrayList<>();
        int indiceV = vertices.indexOf(v);
        for (int i = 0; i < vertices.size(); i++) {
            if (matrizAdyacencia[indiceV][i] > 0) {
                vecinos.add(vertices.get(i));
            }
        }
        return vecinos;
    }
    
    private int obtenerPeso(Vertice u, Vertice v) {
        int indiceU = vertices.indexOf(u);
        int indiceV = vertices.indexOf(v);
        return matrizAdyacencia[indiceU][indiceV];
    }
}