import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio4 { // lo hicieron los profes
    private GrafoDirigido<Integer> grafo;
    private ArrayList<Integer> visitados;

    public Ejercicio4(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new ArrayList<>();
    }

    public ArrayList<Integer> caminoMayor(int origen, int destino) {
        ArrayList<Integer> caminoMayor = new ArrayList<>();
        visitados.add(origen);
        if (origen == destino) {
            caminoMayor.add(origen);
        } else {
            Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
            while (it_ady.hasNext()) {
                Integer ady = it_ady.next();
                if (!this.visitados.contains(ady)) {
                    ArrayList<Integer> camino = caminoMayor(ady, destino);
                    if (!camino.isEmpty() && (camino.size() > caminoMayor.size())) {
                        caminoMayor.clear();
                        caminoMayor.add(origen);
                        caminoMayor.addAll(camino);
                    }
                }
            }
        }
        this.visitados.remove((Integer)origen);
        return caminoMayor;
    }
}