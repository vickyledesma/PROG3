import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DFS {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> verticesColores;
    private GrafoDirigido<Integer> grafo;

    public DFS() {
        this.verticesColores = new HashMap<>();
        this.grafo = grafo;
    }

    public void DFS(GrafoDirigido<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices(); // por cada vertice le asigno color blanco
            verticesColores.put(itVertices.next(), BLANCO);
        
        Iterator<Integer> itVertices2 = grafo.obtenerVertices(); 
        while (itVertices2.hasNext()) {
            int next = itVertices2.next();
            if (verticesColores.get(next) == BLANCO) { // por cada vertice pregunto si su color es blanco 
                DFS_Visit(grafo, next);
            }
        }
    }

    private void DFS_Visit(GrafoDirigido<Integer> grafo, Integer verticeid) {
        verticesColores.put(verticeid, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(verticeid);
        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();
            if (verticesColores.get(next) == BLANCO)  
                DFS_Visit(grafo, next);
            else if (verticesColores.get(next) == AMARILLO) { 
                verticesColores.put(verticeid, NEGRO);
            }
    
        }
    }
}   