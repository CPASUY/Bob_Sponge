package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AdjListGraph<T> implements IGraph<T> {

	private boolean directed;
	private boolean weighted;
	private int numVertex;
	private int numEdges;
	private ArrayList<Vertex<T>> vertex;
	private HashMap<T, AdjVertex<T>> adjList;
	private boolean visited[];
	private double distance[];
	
	public AdjListGraph(boolean d, boolean w,int n) {
		directed = d;
		weighted = w;
		numVertex = 0;
		numEdges=0;
		visited=new boolean[n];
		distance=new double[n];
		vertex= new ArrayList<Vertex<T>>();
		adjList = new HashMap<>();
	}
	public boolean[] getVisited() {
		return visited;
	}
	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}
	@Override
	public void addVertex(T element) {
		if(!searchInGraph(element)) {
			AdjVertex<T> v = new AdjVertex<T>(element);
			adjList.put(element,v);
			v.setIndex(numVertex);
			vertex.add(v);
			numVertex++;
		}
	}
	@Override
	public void addEdge(T from, T to) {
		if (!weighted) {
			if(searchInGraph(from) && searchInGraph(to) ) {
				AdjVertex<T> i = searchAdjVertex(from);
				AdjVertex<T> d = searchAdjVertex(to);
				addEdge(i, d,0);
			}
		}
	}
	@Override
	public void addEdge(T from, T to, int weight) {
		if (weighted) {
			if(searchInGraph(from) && searchInGraph(to) ) {
				AdjVertex<T> i = searchAdjVertex(from);
				AdjVertex<T> d = searchAdjVertex(to);
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
		if (searchInGraph(element)) {
			removeVertex(searchAdjVertex(element));
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
		if (searchInGraph(from) && searchInGraph(to)) {
			removeEdge(searchAdjVertex(from),searchAdjVertex(to));
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
	public void bfs(T initialNode) {
		AdjVertex<T> vertex=searchAdjVertex(initialNode);
		AdjVertex<T> current;
		AdjVertex<T> neighbour;
		Queue<AdjVertex<T>> q=new LinkedList<>();
		q.add(vertex);
		distance[vertex.getIndex()]=0;
		while(!q.isEmpty()) {
			current=q.poll();
			for(int s=0;s<current.getAdjList().size();s++) {
				neighbour=current.getAdjList().get(s).getDestination();
				if(distance[neighbour.getIndex()]==-1) {
					distance[neighbour.getIndex()]=distance[current.getIndex()]+1;
					q.add(neighbour);				}
			}
		}
		
	}

	@Override
	public void dfs(T initialNode) {
		AdjVertex<T> vertex=searchAdjVertex(initialNode);
		AdjVertex<T> neighbour;
		visited[vertex.getIndex()]=true;
		for(int s=0;s<vertex.getAdjList().size();s++) {
			neighbour=vertex.getAdjList().get(s).getDestination();
			if(!visited[neighbour.getIndex()]) {
				dfs(neighbour.getValue());
			}
		}
		
	}
	@Override
	public double[][] floyd_Warshall() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean searchInGraph(T element) {
		AdjVertex<T> find=searchAdjVertex(element);
		if(find!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public AdjVertex<T> searchAdjVertex(T element) {
		return adjList.get(element);
	}

}
