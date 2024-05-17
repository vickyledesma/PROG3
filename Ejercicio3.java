import java.util.HashMap;
import java.util.Iterator;

public class Ciclo {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> verticesColores;

    public Ciclo() {
        this.verticesColores = new HashMap<>();
    }

    public void DFS(GrafoDirigido<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            verticesColores.put(itVertices.next(), BLANCO);
        }
        Iterator<Integer> itVertices2 = grafo.obtenerVertices(); 
        while (itVertices2.hasNext()) {
            int next = itVertices2.next();
            if (verticesColores.get(next) == BLANCO) { // por cada vertice pregunto si su color es blanco 
                DFS_Visit(grafo, next);
            }
        }
    }

    private void DFS_Visit(GrafoDirigido<Integer> grafo, Integer vertice) {
        verticesColores.put(vertice, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();
            if (verticesColores.get(next) == BLANCO)  
                DFS_Visit(grafo, next);
            else if (verticesColores.get(next) == AMARILLO) { 
                System.out.println("Hay un ciclo"); // ejercicio ciclos 
            }
        }
        verticesColores.put(vertice, NEGRO);
    }
}