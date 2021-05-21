package model;

import java.util.ArrayList;

public class AdjVertex<T>  extends Vertex<T>{
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
