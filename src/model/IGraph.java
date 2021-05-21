package model;

public interface IGraph<T>  {
	public void addVertex(T element);
	public void addEdge(T from, T to,int weight);
	public boolean removeVertex(T element);
	public boolean removeEdge(T from,T to);
	public boolean isDirected();
	public boolean isWeighted();
	public AdjVertex<T> searchInGraph(T element);
	public void bfs(AdjVertex<T> initialNode);
	public void  dfs();
}
