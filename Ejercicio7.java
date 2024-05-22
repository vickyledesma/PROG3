import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio7{
    private List<List<Integer>> CaminosAlternativos;
    private List<Integer> CaminoActual;

    public List<List<Integer>> Caminos (GrafoNoDirigido g, int origen, int destino){
        CaminosAlternativos = new ArrayList<>();
        CaminoActual = new ArrayList<>();
        buscarCaminos(g, origen, destino);
        return CaminosAlternativos;
    }


    private void buscarCaminos(GrafoNoDirigido g, int origen, int destino) {
        CaminoActual.add(origen);
        if (origen == destino) {
            CaminosAlternativos.add(new ArrayList<>(CaminoActual));
        } else {
            Iterator<Integer> adyacentes = g.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()) {
                int vecino = adyacentes.next();
                // Verifica si el tramo actual está cortado
                if (!(origen == 4 && vecino == 5 || origen == 5 && vecino == 4) && !CaminoActual.contains(vecino)) {
                    buscarCaminos(g, vecino, destino);
                }
            } 
        }
        CaminoActual.remove(CaminoActual.size() - 1);
    }
///falta probarlo
}