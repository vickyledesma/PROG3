import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class BFS {
    private HashMap<Integer, Boolean> visitaVertices;
    private Queue<Integer> colaVertices;
    private boolean visitado = false; 

    public BFS() {
        this.visitaVertices = new HashMap<>();
        this.colaVertices = new LinkedList<>();
    }

    public BFS(Grafo<Integer> grafo) { 
        colaVertices.clear();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            visitaVertices.put(vertices.next(), false);
        }

        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while(vertices2.hasNext()){
            int vecino = vertices2.next();
            if(visitaVertices.get(vecino) == false){
                BFS_visit(grafo, vecino);
            }
        }
    }

    private void BFS_visit(Grafo<Integer> grafo, int vecino) {
        visitaVertices.put(vecino, true);
        colaVertices.add(vecino);
        while(!colaVertices.isEmpty()){
            int x = colaVertices.poll(); // X Tomar un vértice de la cola
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(x); // por cada X traigo sus adyacentes
            while(adyacentes.hasNext()){
                int y = adyacentes.next();
                if(visitaVertices.get(y) == false){
                    visitaVertices.put(y,true);
                    colaVertices.add(y);

                }
            } 
        }
    } 

}