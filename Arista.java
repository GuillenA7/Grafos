public class Arista {
    private Vertice inicio;
    private Vertice fin;

    private int peso;

    public Arista(Vertice inicio, Vertice fin, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        this.peso = peso;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public Vertice getFin() {
        return fin;
    }

    public int getPeso() {
        return peso;
    }
    
}
