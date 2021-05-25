package model;

public class Edge<T> implements Comparable<Edge<T>> {

	private double weight;
	private Vertex<T> initialMatrix;
	private Vertex<T> destinationMatrix;
	private AdjVertex<T> initial;
	private AdjVertex<T> destination;
	
	public Edge(AdjVertex<T> i, AdjVertex<T> d, double w) {
		initial = i;
		destination = d;
		weight = w;
	}
	
	public Edge(Vertex<T> i, Vertex<T> d, double w) {
		setInitialMatrix(i);
		setDestinationMatrix(d);
		weight = w;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public AdjVertex<T> getInitial() {
		return initial;
	}

	public void setInitial(AdjVertex<T> initial) {
		this.initial = initial;
	}

	public AdjVertex<T> getDestination() {
		return destination;
	}

	public void setDestination(AdjVertex<T> destination) {
		this.destination = destination;
	}

	@Override
	public int compareTo(Edge<T> edge) {
		if(weight==edge.weight)  
			return 0;  
			else if(weight>edge.weight)  
			return 1;  
			else
			return -1; 
	}

	public Vertex<T> getInitialMatrix() {
		return initialMatrix;
	}

	public void setInitialMatrix(Vertex<T> i) {
		this.initialMatrix = i;
	}

	public Vertex<T> getDestinationMatrix() {
		return destinationMatrix;
	}

	public void setDestinationMatrix(Vertex<T> d) {
		this.destinationMatrix = d;
	}
}
