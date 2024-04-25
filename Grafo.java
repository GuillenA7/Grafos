import java.util.ArrayList;

public class Grafo {
    private ArrayList<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
    }
    
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice agregarVertice(String nombre) {
        Vertice nuevoVertice = new Vertice(nombre);

        this.vertices.add(nuevoVertice);
            return nuevoVertice;
    }

    public void agregarArista(Vertice inicio, Vertice fin, int peso) {
        inicio.agregarArista(fin, peso);

        fin.agregarArista(inicio, peso);
    }

    public void removeVertice(Vertice Vertice) {
        this.vertices.remove(Vertice);
    }

    public Vertice getVerticeByNombre(String nombre) {
        for(Vertice Vertice: this.vertices) {
            if (Vertice.getNombre().equals(nombre)) {
                return Vertice;
            }
        }

        return null;
    }

    public void print() {
        for(Vertice Vertice: this.vertices) {
            Vertice.print();
        }
    }

}