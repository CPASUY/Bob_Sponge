package model;

public class AdjMatrixGraph<T> implements IGraph<T>{
	private boolean directed;
	private boolean weighted;
	private int numVertex;
	private int numEdges;
	private double[][] adjMatrix;
	
	public AdjMatrixGraph(boolean d, boolean w,int n) {
		directed = d;
		weighted = w;
		numVertex= 0;
		adjMatrix= new double[n][n];
	}
	@Override
	public void addVertex(T element) {
	}
	@Override
	public void addEdge(T from, T to, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeVertex(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(T from, T to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

}
