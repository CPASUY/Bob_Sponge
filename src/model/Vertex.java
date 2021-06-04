package model;

import java.io.Serializable;

public class Vertex<T> implements Comparable<Vertex<T>> , Serializable{
	private static final long serialVersionUID = 1L;
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
	@Override
	public int compareTo(Vertex<T> o) {
		if(getIndex()==o.getIndex())  
			return 0;  
			else if(getIndex()>o.getIndex())  
			return 1;  
			else
			return -1; 
	}

	
}
