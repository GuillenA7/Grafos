import java.util.ArrayList;

public class Vertice {
    private String nombre;
    private ArrayList<Arista>aristas;
    
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<Arista>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void agregarArista(Vertice fin, int peso) {
        this.aristas.add(new Arista(this, fin, peso));
    }

    public void print() {
        String mensaje = "";

        if(this.aristas.size() == 0) {
            System.out.println(this.nombre + " conectado a ");
            return;
        }

        for(int i = 0; i < this.aristas.size(); i++) {
            if(i == 0)
                mensaje += this.aristas.get(i).getInicio().nombre + " conectado a ";

            mensaje += this.aristas.get(i).getFin().nombre;

                mensaje += " (peso=" + this.aristas.get(i).getPeso() + ")";

            if(i != this.aristas.size() - 1)
                mensaje += " y a ";
        }
        System.out.println(mensaje);
    }
}
