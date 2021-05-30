package model;

public class Vertex<T> {
	
	private T value;
	private boolean usable;
	private int index;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Vertex(T value) {
		super();
		this.value = value;
		usable=false;
	}
	public boolean isUsable() {
		return usable;
	}
	public void setUsable(boolean usable) {
		this.usable = usable;
	}
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	
}
