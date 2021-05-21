package model;
import java.util.ArrayList;
import java.util.HashMap;

public class AdjListGraph<T> implements IGraph<T> {

	private boolean directed;
	private boolean weighted;
	private int numVertex;
	private int numEdges;
	private ArrayList<Vertex<T>> vertex;
	private HashMap<T, AdjVertex<T>> adjList;
	
	public AdjListGraph(boolean d, boolean w) {
		directed = d;
		weighted = w;
		numVertex = 0;
		vertex= new ArrayList<Vertex<T>>();
		adjList = new HashMap<>();
	}
	@Override
	public void addVertex(T element) {
		if(searchInGraph(element)==null) {
			AdjVertex<T> v = new AdjVertex<T>(element);
			adjList.put(element,v);
			v.setIndex(numVertex);
			vertex.add(v);
			numVertex++;
		}
	}
	@Override
	public void addEdge(T from, T to, int weight) {
		if (weighted) {
			if(searchInGraph(from)!=null && searchInGraph(to)!=null ) {
				AdjVertex<T> i = searchInGraph(from);
				AdjVertex<T> d = searchInGraph(to);
				addEdge(i, d,weight);
			}
		}
	}
	public void addEdge(AdjVertex<T> from, AdjVertex<T> to, int weight) {
			Edge<T> edge = new Edge<T>(from, to, weight);
			from.getAdjList().add(edge);
			if (!isDirected()) {
				edge = new Edge<T>(to, from, weight);
				to.getAdjList().add(edge);
			}
			numEdges++;
	}
	@Override
	public boolean removeVertex(T element) {
		if (searchInGraph(element)!=null) {
			removeVertex(searchInGraph(element));
			return true;
		}
		return false;
	}
	public void removeVertex(AdjVertex<T> v) {
		for (int s=0;s<vertex.size();s++) {
			removeEdge((AdjVertex<T>)vertex.get(s), v);
			if (isDirected()) {
				removeEdge(v,(AdjVertex<T>)vertex.get(s));
			}
		}
		vertex.remove(v);
		numVertex--;
	}
	@Override
	public boolean removeEdge(T from, T to) {
		if (searchInGraph(from)!=null && searchInGraph(to)!=null) {
			removeEdge(searchInGraph(from),searchInGraph(to));
			return true;
		}
		return false;
	}
	public void removeEdge(AdjVertex<T> from, AdjVertex<T> to) {
			Edge<T> edge = from.findEdgeOfVertex(to);
			if(edge!=null) {
				from.getAdjList().remove(edge);
			}
			else if(isDirected()==false) {
				edge=to.findEdgeOfVertex(from);
				if(edge!=null) {
					to.getAdjList().remove(edge);
				}
			}
			numEdges--;
	}
	@Override
	public boolean isDirected() {
		return directed;
	}

	@Override
	public boolean isWeighted() {
		return weighted;
	}

	@Override
	public void bfs(AdjVertex<T> initialNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdjVertex<T> searchInGraph(T element) {
		return adjList.get(element);
	}

}
