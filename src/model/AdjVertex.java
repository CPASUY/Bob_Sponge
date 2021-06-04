package model;
import java.io.Serializable;
import java.util.ArrayList;

public class AdjVertex<T>  extends Vertex<T> implements  Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Edge<T>> edgesList;

	public AdjVertex(T value) {
		super(value);
		edgesList = new ArrayList<Edge<T>>();
	}

	public ArrayList<Edge<T>> getAdjList() {
		return edgesList;
	}
	public Edge<T> findEdgeOfVertex(AdjVertex<T> vertex){
		for (int i=0; i<edgesList.size(); i++) {
			if (edgesList.get(i).getInitial()==vertex)
				return edgesList.get(i);
		}
		return null;
	}
	public Edge<T> findEdgeOfVertexFinal(AdjVertex<T> vertex){
		for (int i=0; i<edgesList.size(); i++) {
			if (edgesList.get(i).getDestination()==vertex)
				return edgesList.get(i);
		}
		return null;
	}
	public boolean isAdjacent(AdjVertex<T> vertex) {
		for (int i = 0; i < edgesList.size(); i++) {
			if (edgesList.get(i).getDestination()==vertex)
				return true;
		}
		return false;
	}
}
