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
    
    // Método para agregar una arista al grafo, con su respectivo peso
    public void agregarArista(Vertice inicio, Vertice fin, int peso) {
        Arista nuevaArista = new Arista(inicio, fin, peso);  // Crea una nueva arista con el inicio, fin y peso dados
        aristas.add(nuevaArista);  // Agrega la nueva arista a la lista de aristas
        int indiceInicio = vertices.indexOf(inicio);  // Obtiene el índice del vértice inicio en la lista de vértices
        int indiceFin = vertices.indexOf(fin);        // Obtiene el índice del vértice fin en la lista de vértices
        matrizAdyacencia[indiceInicio][indiceFin] = peso;  // Establece el peso de la arista en la matriz de adyacencia
        matrizAdyacencia[indiceFin][indiceInicio] = peso;  // Debido a que es un grafo no dirigido, se establece el peso en ambas direcciones
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
    
    // Método para encontrar el camino más corto entre dos vértices utilizando el algoritmo de Dijkstra
    public void dijkstra(Vertice inicio, Vertice fin) {
        Map<Vertice, Integer> distancia = new HashMap<>();     // Mapa para almacenar las distancias más cortas desde el vértice inicial
        Map<Vertice, Vertice> previo = new HashMap<>();        // Mapa para almacenar el vértice previo en el camino más corto
        PriorityQueue<Vertice> colaPrioridad = new PriorityQueue<>(vertices.size(), Comparator.comparing(distancia::get));  // Cola de prioridad para los vértices basada en sus distancias
        
        // Inicialización
        for (Vertice v : vertices) {
            if (v == inicio) {
                distancia.put(v, 0);  // Establece la distancia del vértice inicial como 0
            } else {
                distancia.put(v, Integer.MAX_VALUE);  // Establece la distancia de los demás vértices como infinito
            }
            colaPrioridad.add(v);  // Agrega cada vértice a la cola de prioridad
        }
        
        // Algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            Vertice u = colaPrioridad.poll();  // Obtiene el vértice con la menor distancia actual
            if (u == fin) {  // Si el vértice actual es el destino, se detiene el algoritmo
                break;
            }
            for (Vertice vecino : obtenerVecinos(u)) {  // Itera sobre los vecinos del vértice actual
                int pesoArista = obtenerPeso(u, vecino);  // Obtiene el peso de la arista entre el vértice actual y su vecino
                int nuevaDistancia = distancia.get(u) + pesoArista;  // Calcula la nueva distancia desde el inicio hasta el vecino
                if (nuevaDistancia < distancia.get(vecino)) {  // Si la nueva distancia es menor que la actual
                    distancia.put(vecino, nuevaDistancia);  // Actualiza la distancia del vecino
                    previo.put(vecino, u);  // Establece el vértice previo en el camino más corto
                    colaPrioridad.remove(vecino);  // Remueve y vuelve a insertar el vecino en la cola de prioridad para actualizar su posición
                    colaPrioridad.add(vecino);
                }
            }
        }
        
        // Imprimir el camino más corto
        Stack<Vertice> camino = new Stack<>();
        Vertice actual = fin;
        while (previo.containsKey(actual)) { // Reconstruye el camino desde el destino hasta el inicio
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