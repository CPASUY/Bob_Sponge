package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AdjMatrixGraph<T> implements IGraph<T>{
	private boolean directed;
	private boolean weighted;
	private int numVertex;
	private int numEdges;
	private boolean visited[];
	private double distance[];
	private double[][] adjMatrix;
	private int fathers[] = new int[100];
	private Map<T, Vertex<T>> vertices;
	private ArrayList<Vertex<T>> verticesArray;
	private Map<T, Integer> indexVertices;
	private PriorityQueue<Vertex<T>> pq;
	
	public AdjMatrixGraph(boolean d, boolean w,int n) {
		directed = d;
		weighted = w;
		numVertex= 0;
		numEdges=0;
		visited=new boolean[n];
		distance=new double[n];
		adjMatrix=new double[n][n];
		vertices=new HashMap<>();
	    indexVertices=new HashMap<>();
	    verticesArray = new ArrayList<Vertex<T>>();
	}
	public double[] getDistance() {
		return distance;
	}
	public void setDistance(double[] distance) {
		this.distance = distance;
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
			Vertex<T> vertex = new Vertex<T>(element);
			vertices.put(element,vertex);
			verticesArray.add(vertex);
			vertex.setIndex(numVertex);
			indexVertices.put(element,numVertex);
			numVertex++;
		}
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
		if(searchIndex(element)!=null) {
			Integer x=indexVertices.get(element);
			indexVertices.remove(x);
			vertices.remove(element);
			for (int i=0;i<adjMatrix.length; i++) {
				adjMatrix[i][x] = 0;
				adjMatrix[x][i] = 0;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdge(T from, T to) {
		if (searchInGraph(from) && searchInGraph(to)) {
			Vertex<T> f=searchVertex(from);
			Vertex<T> t=searchVertex(to);
			removeEdge(f, t);
			return true;
		}
		return false;
	}
	public void removeEdge(Vertex<T> from, Vertex<T> to) {
		Integer x=indexVertices.get(from.getValue());
        Integer y=indexVertices.get(to.getValue());
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
	public void bfs(T initialNode) {
		Queue<Vertex<T>> q= new LinkedList<>();
		Vertex<T> v=searchVertex(initialNode);
		q.add(v);
		distance[v.getIndex()]=0;
		while(!q.isEmpty()) {
			Vertex<T> current = q.poll();
			for (int i = 0; i <adjMatrix[current.getIndex()].length;i++) {
				if(adjMatrix[current.getIndex()][i]!=0	) {
					Vertex<T> neighbour= vertices.get(i);
					if(distance[neighbour.getIndex()]==-1) {
						distance[neighbour.getIndex()]=distance[current.getIndex()]+1;
						q.add(neighbour);
					}
				}

			}
		}
	}

	@Override
	public void dfs(T initialNode) {
		Vertex<T> vertex=searchVertex(initialNode);
		Vertex<T> neighbour;
		visited[vertex.getIndex()]=true;
		for (int i = 0; i <adjMatrix[vertex.getIndex()].length;i++) {
			if(adjMatrix[vertex.getIndex()][i]!=0) {
				 neighbour= vertices.get(i);
				if(!visited[neighbour.getIndex()]) {
					dfs(neighbour.getValue());
				}
			}
		}
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
	
	public int dijkstra(T initialNode,T destinyNode) {
		Vertex<T> from=searchVertex(initialNode);
		Vertex<T> destiny=searchVertex(destinyNode);
		int distance[] = new int[numVertex]; 
	    Set<Integer> visited = new HashSet<Integer>();;
		pq = new PriorityQueue<Vertex<T>>();
		 
			for (int i = 0; i < numVertex; i++) {
	            distance[i] = Integer.MAX_VALUE;
		 }
			pq.add(from);
			distance[from.getIndex()] = 0;
			while (visited.size() != numVertex) { 
				            int u = pq.remove().getIndex();
				            
				            visited.add(u); 
				            graph_adjacentNodes(u,distance,visited); 
				        }
		return distance[destiny.getIndex()];
	}
	
	private void graph_adjacentNodes(int u,int[]distance,Set<Integer> visited)   { 
        
		int edgeDistance = -1;
        int newDistance = -1; 
        for (int i = 0; i < numVertex; i++) { 
        	if(adjMatrix[u][i] != 0) {
        		Vertex<T> v = verticesArray.get(i); 	
            if (!visited.contains(v.getIndex())) {
            	edgeDistance = (int) adjMatrix[u][i];
                newDistance = distance[u] + edgeDistance; 
                if (newDistance < distance[v.getIndex()]) 
                    distance[v.getIndex()] = newDistance;
                pq.add(v); 
            }
        	}
        }
    } 
	
	@Override
	public int kruskal() {
		ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
		for(int i=0;i<fathers.length;i++) {
			fathers[i] = i;
		}
		for(int i = 0;i<adjMatrix.length;i++) {
			for(int j=0;j<adjMatrix.length;j++) {
				if(adjMatrix[i][j] != 0) {
					Edge<T> edge = new Edge<T>(verticesArray.get(i),verticesArray.get(j),adjMatrix[i][j]);
					edges.add(edge);
				}
			}
		}
		int totalWeight = 0;
		int edgesGraph = 0;
		int count = 0;
		Collections.sort(edges);
		int origin,destination,weight;
		while(edgesGraph < numVertex-1 && count<edges.size()) {
			origin = edges.get(count).getInitialMatrix().getIndex();
			destination = edges.get(count).getDestinationMatrix().getIndex();
			weight = (int)edges.get(count).getWeight();
			if(find(origin) != find(destination)) {
				unite(origin,destination);
				totalWeight +=weight;
				edgesGraph++;
			}
		count++;}
		
			return totalWeight;
	}
	
	private int find(int x) {
		if(fathers[x] == x) {
			return x;
		}
		return find(fathers[x]);
	}
	
	private void unite(int x,int y) {
		int fx = find(x);
		int fy = find(y);
		fathers[fx] = fy;
	}
	
	public double prim(Vertex<T> from, int v) {
		int visited[] = new int[numVertex];
		visited[v] = 1;
		int h1 = -1;
		int h2 = -1;
		double totalWeight=-1;
		double minWeight = 10000;
		for(int i=0;i<numVertex;i++) {
			for(int j=0;j<numVertex;j++) { 
				for(int k=0;k<numVertex;k++) {
					if(visited[i]==1 && visited[j]==0 && adjMatrix[i][j]<minWeight) {
						minWeight = adjMatrix[i][j] ;
						h1 = i;
                        h2 = j;
					}
				}
			}
			totalWeight += minWeight;
            visited[h2] = 1;
            minWeight = 10000;
		}
		return totalWeight;
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
	
	public Vertex<T> searchVertex(int element) {
		return vertices.get(element);
	}
	
	public Integer searchIndex(T element) {
		return indexVertices.get(element);
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
	public Map<T, Vertex<T>> getVertices() {
		return vertices;
	}
	public void setVertices(Map<T, Vertex<T>> vertices) {
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
