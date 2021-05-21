package model;

public class Edge<T> {

	private double weight;
	private AdjVertex<T> initial;
	private AdjVertex<T> destination;
	
	public Edge(AdjVertex<T> i, AdjVertex<T> d, double w) {
		initial = i;
		destination = d;
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
}
