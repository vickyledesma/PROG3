import java.util.*;

public class Ejercicio6 {
    private HashMap<Integer, Boolean> visitaVertices;
    private Queue<Integer> colaVertices;
    private HashMap<Integer, Integer> padres;

    public Ejercicio6() {
        this.visitaVertices = new HashMap<>();
        this.colaVertices = new LinkedList<>();
        this.padres = new HashMap<>();
    }

    public Ejercicio6(Grafo<Integer> grafo) {
        this();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()) {
            visitaVertices.put(vertices.next(), false);
        }

        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while(vertices2.hasNext()) {
            int vecino = vertices2.next();
            if(!visitaVertices.get(vecino)) {
                BFS_visit(grafo, vecino);
            }
        }
    }

    private void BFS_visit(Grafo<Integer> grafo, int vecino) {
        visitaVertices.put(vecino, true);
        colaVertices.add(vecino);
        while(!colaVertices.isEmpty()) {
            int x = colaVertices.poll();
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(x);
            while(adyacentes.hasNext()) {
                int y = adyacentes.next();
                if(!visitaVertices.get(y)) {
                    visitaVertices.put(y, true);
                    colaVertices.add(y);
                    padres.put(y, x); // lo unico que cambia del BFS, marco x como padre de y 
                }
            }
        }
    }
    public List<Integer> camino(Grafo<Integer> grafo, int v, int w) { // ejercicio 5
        visitaVertices.clear();
        colaVertices.clear();
        padres.clear();

        Iterator<Integer> vertices = grafo.obtenerVertices(); // los marco como falsos porque si no decteca ciclo, y no sigue
        while(vertices.hasNext()) {
            visitaVertices.put(vertices.next(), false);
        }
        List<Integer> caminoMasCorto = new ArrayList<>();
        BFS_visit(grafo, v);
        if(visitaVertices.get(w)) {
            caminoMasCorto.add(w);
            int actual = w;
            while(actual != v) {
                int padre = padres.get(actual);
                caminoMasCorto.add(padre);
                actual = padre;
            }
            Collections.reverse(caminoMasCorto);
        }

        return caminoMasCorto;
    }
}
