package model;
import java.util.HashMap;
import java.util.Map;

public class AdjMatrixGraph<T> implements IGraph<T>{
	private boolean directed;
	private boolean weighted;
	private int numVertex;
	private int numEdges;
	private double[][] adjMatrix;
	private Map<Integer, Vertex<T>> vertices;
	private Map<T, Integer> indexVertices;
	
	public AdjMatrixGraph(boolean d, boolean w,int n) {
		directed = d;
		weighted = w;
		numVertex= 0;
		adjMatrix=new double[n][n];
		vertices=new HashMap<>();
	    indexVertices=new HashMap<>();
	}
	@Override
	public void addVertex(T element) {
	}
	@Override
	public void addEdge(T from, T to) {
		Vertex<T> i=searchVertex(from);
		Vertex<T> d=searchVertex(to);
		if (i != null && d!= null) {
			Integer x=indexVertices.get(from);
	        Integer y=indexVertices.get(to);
	        if (x != null && y != null) {
	            if (!isDirected()) {
	            	adjMatrix[x][y] = 1;
	            	adjMatrix[y][x] = 1;
	            } else {
	            	adjMatrix[x][y] = 1;
	            }
	        }
		}
	}
	@Override
	public void addEdge(T from, T to, int weight) {
		Vertex<T> i=searchVertex(from);
		Vertex<T> d=searchVertex(to);
		if (i != null && d!= null) {
			Integer x=indexVertices.get(from);
	        Integer y=indexVertices.get(to);
	        if (x != null && y != null) {
	            if (!isDirected()) {
	            	adjMatrix[x][y] = weight;
	            	adjMatrix[y][x] = weight;
	            } else {
	            	adjMatrix[x][y] = weight;
	            }
	        }
		}
	}
	@Override
	public boolean removeVertex(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(T from, T to) {
		if (searchInGraph(from) && searchInGraph(to)) {
			removeEdge(searchVertex(from), searchVertex(to));
			return true;
		}
		return false;
	}
	public void removeEdge(Vertex<T> from, Vertex<T> to) {
		Integer x=indexVertices.get(from);
        Integer y=indexVertices.get(to);
		 if (!isDirected()) {
			 adjMatrix[x][y] = 0;
			 adjMatrix[y][x] = 0;
	        } else {
	        	adjMatrix[x][y] = 0;
	        }
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
	public double[][] floyd_Warshall() {
		double[][] matrix = getAdjMatrix();
		for (int s=0;s<vertices.size();s++) {
			for (int m=0;m< vertices.size();m++) {
				for (int w=0;w< vertices.size();w++) {
					matrix[m][w]=Math.min(matrix[m][w],matrix[m][s]+matrix[s][w]);
				}
			}
		}
		return matrix;
	}
	@Override
	public boolean searchInGraph(T element) {
		Vertex<T> vertex=searchVertex(element);
		if(vertex==null) {
			return false;
		}
		else {
			return true;
		}
	}

	public Vertex<T> searchVertex(T element) {
		return vertices.get(element);
	}
	public int getNumVertex() {
		return numVertex;
	}
	public void setNumVertex(int numVertex) {
		this.numVertex = numVertex;
	}
	public int getNumEdges() {
		return numEdges;
	}
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
	public double[][] getAdjMatrix() {
		return adjMatrix;
	}
	public void setAdjMatrix(double[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}
	public Map<Integer, Vertex<T>> getVertices() {
		return vertices;
	}
	public void setVertices(Map<Integer, Vertex<T>> vertices) {
		this.vertices = vertices;
	}
	public Map<T, Integer> getIndexVertices() {
		return indexVertices;
	}
	public void setIndexVertices(Map<T, Integer> indexVertices) {
		this.indexVertices = indexVertices;
	}
	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	public void setWeighted(boolean weighted) {
		this.weighted = weighted;
	}

}
