package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AdjMatrixGraph<T> implements IGraph<T>{
	private boolean directed;
	private boolean weighted;
	private int numVertex;
	private int numEdges;
	private boolean visited[];
	private double distance[];
	private double[][] adjMatrix;
	private ArrayList <Edge<T>> edges;
	private Map<Integer, Vertex<T>> vertices;
	private Map<T, Integer> indexVertices;
	
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
			vertices.put(numVertex,vertex);
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
	            	edges.add(new Edge<T>(searchVertex(from),searchVertex(to),weight));
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
		
	public void dijkstra(Vertex<T> from) {
	
		double flag[] = new double [numVertex+1];
		double min;
		int i,k,c;
		int minpos = 0;
		
		//Pasamos la primera fila al arreglo distancia
		for(i = 0;i<numVertex;i++) {
			flag[i] = 0;
			distance[i] = adjMatrix[from.getIndex()][i];
		}
		
		//Retomamos de la segunda fila por que la primera ya la cogimos
		c = 1;
		
		while(c < numVertex) {
			min = 99;
			for(k=0;k<numVertex;k++) {
				if(distance[k]<min && flag[k] !=1) {
					min = distance[i];
					minpos = k;
				}
			}
			flag[minpos] = 1;
			c++;
			
			for(k=0;k<numVertex;k++) {
				
				if(distance[minpos] + adjMatrix[minpos][k]<distance[k] && flag[k]!=1) {
					distance[k] = distance[minpos] + adjMatrix[minpos][k];
				}
			}
			
		}
		
		// Coste minimo para llegar a tal punto esta en el vector distance
		for(int l=0;l<numVertex;l++) {
			if(vertices.get(l) != from) {
			System.out.println("Origin " + from.getValue() + " destine : " + vertices.get(l) + "minimal cost: "  + distance[i]);
			}
		}
		
	}
	
	public void kruskal() {
		int fathers[] = new int[100];
		for(int i=0;i<fathers.length;i++) {
			fathers[i] = i;
		}
		int totalWeight = 0;
		int edgesGraph = 0;
		int count = 0;
		Collections.sort(edges);
		int origin,destination,weight;
		while(edgesGraph < numVertex-1 && count<numEdges) {
			origin = edges.get(count).getInitialMatrix().getIndex();
			destination = edges.get(count).getDestinationMatrix().getIndex();
			weight = (int)edges.get(count).getWeight();
			
			if(find(origin,fathers) != find(destination,fathers)) {
				unite(origin,destination,fathers);
				totalWeight +=weight;
				System.out.println(" " + origin + " ----->  " + destination + ": " + weight);
				edgesGraph++;
			}
			count++;}
		
			if(edgesGraph != numVertex-1) {
				System.out.println("El grafo no es valido");
		}
			System.out.println("El costo total minimo de es: " + totalWeight);
	}
	
	private int find(int x,int[]fathers) {
		if(fathers[x] == x) {
			return x;
		}
		return find(fathers[x],fathers);
	}
	
	private void unite(int x,int y,int[]fathers) {
		int fx = find(x,fathers);
		int fy = find(y,fathers);
		fathers[fx] = fy;
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
