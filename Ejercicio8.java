import java.util.HashMap;
import java.util.Iterator;

public class Ejercicio8<T> {
    private HashMap<Integer, Tarea<T>> visitados;
    private int ejecucionMaxima;
    

    public int ejecucionCritica(GrafoDirigido g, HashMap<Integer, Tarea<T>> visitados, int ejecucionMaxima){
        this.visitados = visitados;
        this.ejecucionMaxima = ejecucionMaxima;
        Iterator<Integer> itVertices2 = g.obtenerVertices(); 
        while (itVertices2.hasNext()) {
            int next = itVertices2.next();
            DFS_Visit(g, next);
        }
        return ejecucionMaxima;
    }
    private void DFS_Visit(GrafoDirigido g, int next) {
        Tarea<T> verticeActual = visitados.get(next);
        Iterator<Arco<T>> itAdyacentes = g.obtenerAdyacentes(next);
        while (itAdyacentes.hasNext()) {
            Arco<T> arco = itAdyacentes.next();
            int vecino = arco.getVerticeDestino();
            int duracionarco = (int) arco.getEtiqueta(); 
            int duracionVecino = visitados.get(vecino).getDuracion(); 
            int duracionActualizada = duracionVecino + duracionarco; 
            if (duracionActualizada > ejecucionMaxima) {
                ejecucionMaxima = duracionActualizada;
            }
            DFS_Visit(g, vecino);
        }
    }
}