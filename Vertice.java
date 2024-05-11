import java.util.ArrayList;

public class Vertice<T>{
    private int verticeId;
    private ArrayList<Arco<T>> adyacentes;

    public Vertice(int verticeId, ArrayList<Arco<T>> adyacentes) {
        this.verticeId = verticeId;
        this.adyacentes = adyacentes;
    }

    public ArrayList<Arco<T>> getAdyacentes() {
        return adyacentes;
    }

    public void addArco(Arco<T> arco) {
        adyacentes.add(arco);
    }

    public void borrarArco(int verticeDestino) {
        for (int i = 0; i < adyacentes.size(); i++) {
            Arco<T> arcoHijo = adyacentes.get(i);
            if (arcoHijo.getVerticeDestino() == verticeDestino) {
                adyacentes.remove(i);
            }
        }
    }

    public boolean existeArco(int verticeDestino) {
        for (int i = 0; i < adyacentes.size(); i++) {
            Arco<T> arcohijo = adyacentes.get(i);
            if (arcohijo.getVerticeDestino() == verticeDestino)
                return true;
        }
        return false;
    }

    public Arco<T> obtenerArco(int verticeDestino) {
        for (int i = 0; i < adyacentes.size(); i++) {
            Arco<T> arcoHijo = adyacentes.get(i);
            if (arcoHijo.getVerticeDestino() == verticeDestino)
                return arcoHijo;
        }
        return null;
    }

    public void borrarTodosLosArcos() {
        this.adyacentes.clear();
    }
}
