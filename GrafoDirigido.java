
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	private int cantVertices = 0;
    private int cantArcos = 0;
    private HashMap<Integer, Vertice<T>> vertices;
	
	public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

	@Override
	public void agregarVertice(int verticeId) {
		vertices.put(verticeId, new Vertice<T>(verticeId, new ArrayList<Arco<T>>())); // clave del vertice y sus arcos 
        cantVertices++;
	}

	@Override
	public void borrarVertice(int verticeId) {
		Vertice<T> verticeOrigen = vertices.get(verticeId);
		verticeOrigen.borrarTodosLosArcos();
		vertices.remove(verticeId);
		cantVertices--;
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Vertice<T> verticeOrigen = vertices.get(verticeId1);
        verticeOrigen.addArco(new Arco<>(verticeId1, verticeId2, etiqueta));
        cantArcos++;

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Vertice<T> verticeOrigen = vertices.get(verticeId1);
		verticeOrigen.borrarArco(verticeId2);
		cantArcos--;
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		Vertice<T> verticeOrigen = vertices.get(verticeId);
		return verticeOrigen != null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Vertice<T> verticeOrigen = vertices.get(verticeId1);
		return verticeOrigen.existeArco(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Vertice<T> verticeOrigen = vertices.get(verticeId1);
        return verticeOrigen.obtenerArco(verticeId2);
    }
	
	@Override
	public int cantidadVertices() {
		return cantVertices;
	}

	@Override
	public int cantidadArcos() {
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() { 
		return vertices.keySet().iterator();
	}

	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Vertice<T> verticeOrigen = vertices.get(verticeId);
		ArrayList<Integer> adyacentes = new ArrayList<>();
		if (verticeOrigen != null) {
			ArrayList<Arco<T>> arcoss = verticeOrigen.getAdyacentes();
			for (Arco<T> arco : arcoss) {
				adyacentes.add(arco.getVerticeDestino());
			}
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> todosLosArcos = new ArrayList<>();
		for (Vertice<T> vertice : vertices.values()) {
			todosLosArcos.addAll(vertice.getAdyacentes());
		}
		return todosLosArcos.iterator();
		
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		Vertice<T> verticeOrigen = vertices.get(verticeId);
		if(verticeOrigen!= null){
			return verticeOrigen.getAdyacentes().iterator();
		} else {
			return null;}
		
	}
}
