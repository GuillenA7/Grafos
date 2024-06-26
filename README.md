# Practica 5 - Grafos - Estructuras de Datos Y Algoritmia
Este repositorio contiene una implementación en Java de una estructura de datos grafo, junto con clases para vértices (`Vertice`) y aristas (`Arista`). Incluye métodos para agregar vértices y aristas, imprimir la estructura del grafo y encontrar el camino más corto entre vértices utilizando el algoritmo de Dijkstra.

## Resumen de Clases

### Clase Vertice
Representa un vértice en el grafo.

#### Atributos:
- `nombre`: Nombre del vértice.

#### Métodos:
- `Vertice(String nombre)`: Constructor para inicializar el vértice con un nombre.

### Clase Arista
Representa una arista entre dos vértices en el grafo.

#### Atributos:
- `inicio`: Vértice de inicio de la arista.
- `fin`: Vértice de fin de la arista.
- `peso`: Peso o costo asociado con la arista.

#### Métodos:
- `Arista(Vertice inicio, Vertice fin, int peso)`: Constructor para inicializar la arista con su vértice de inicio, vértice de fin y peso.

### Clase Grafo
Administra la estructura del grafo.

#### Atributos:
- `vertices`: Lista de vértices en el grafo.
- `aristas`: Lista de aristas en el grafo.
- `matrizAdyacencia`: Representación del grafo mediante matriz de adyacencia.

#### Métodos:
- `agregarVertice(Vertice v)`: Agrega un vértice al grafo.
- `agregarArista(Vertice inicio, Vertice fin, int peso)`: Agrega una arista entre dos vértices con un peso especificado.
- `imprimirGrafo()`: Imprime las conexiones entre vértices y la matriz de adyacencia.
- `dijkstra(Vertice inicio, Vertice fin)`: Encuentra el camino más corto entre dos vértices utilizando el algoritmo de Dijkstra.

#### Métodos auxiliares privados:
- `obtenerVecinos(Vertice v)`: Obtiene los vértices vecinos de un vértice dado.
- `obtenerPeso(Vertice u, Vertice v)`: Obtiene el peso de la arista entre dos vértices.

### Clase Main
Contiene el método principal para demostrar la funcionalidad de la clase Grafo.

- Crea un grafo, agrega vértices y aristas, y realiza operaciones como imprimir la estructura del grafo y encontrar el camino más corto entre vértices especificados usando el algoritmo de Dijkstra.

## Ejemplo de Uso

Para utilizar esta implementación:

### Crear Vértices:
```java
Vertice A = new Vertice("A");
Vertice B = new Vertice("B");
// Agregar más vértices según sea necesario
```
### Crear Grafo:
```java
Grafo grafo = new Grafo();  // Crear grafo
grafo.agregarVertice(A);
grafo.agregarVertice(B);
// Agregar más vértices
grafo.agregarArista(A, B, 2);  // Agregar aristas con pesos
// Agregar más aristas
```
### Operaciones:
- Imprimir la estructura del grafo:
```java
grafo.imprimirGrafo();
```
### Encontrar el camino más corto entre dos vértices usando el algoritmo de Dijkstra:
```java
grafo.dijkstra(A, G);  // Ejemplo: encontrar camino más corto desde vértice A a vértice G
```
## Notas
- Esta implementación asume que el grafo es no dirigido (las aristas son bidireccionales).
- La clase Grafo utiliza matriz de adyacencia por simplicidad en este ejemplo. Para grafos grandes o dispersos, una lista de adyacencia podría ser más eficiente.
- Asegúrate de manejar casos como caminos o vértices inexistentes al utilizar el algoritmo de Dijkstra.

Esta implementación en Java proporciona funcionalidades básicas para administrar y manipular grafos, siendo adecuada para diversas aplicaciones y algoritmos relacionados con grafos.
