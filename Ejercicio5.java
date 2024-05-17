import java.util.*;

public class Camino {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private HashMap<Integer, String> verticesColores;

    public Camino() {
        this.verticesColores = new HashMap<>();
    }

    public List<Integer> obtenerVerticesConCaminoHacia(GrafoDirigido<Integer> grafo, Integer vertice) {
       verticesColores.clear();
       Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            verticesColores.put(itVertices.next(), BLANCO);
        }
        List<Integer> verticesConCamino = new ArrayList<>();
        DFS_Visit(grafo, vertice, verticesConCamino);

        return verticesConCamino;
    }

    private void DFS_Visit(GrafoDirigido<Integer> grafo, Integer verticeid, List<Integer> verticesConCamino) {
        verticesColores.put(verticeid, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(verticeid);
        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();
            if (verticesColores.get(next).equals(BLANCO)) {
                DFS_Visit(grafo, next, verticesConCamino);
                verticesConCamino.add(next); // Añadir el vértice al camino
            }
        }
    }
}