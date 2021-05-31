package model;

import java.io.Serializable;

public class User <T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickname;
	private double score;
	private User <T>  left;
	private User <T>  right;
	private AdjVertex<T> initialMap;
	private AdjVertex<T> destinyMap;
	private AdjVertex<T> initialClue;
	private AdjVertex<T> destinyClue;
	private User <T>  father;
	
	public User(String n,double s) {
		nickname = n;
		score = s;

	}
	public User<T> getFather() {
		return father;
	}

	public void setFather(User<T> father) {
		this.father = father;
	}

	public User<T> getLeft() {
		return left;
	}

	public void setLeft(User<T> left) {
		this.left = left;
	}

	public User<T> getRight() {
		return right;
	}

	public AdjVertex<T> getInitialMap() {
		return initialMap;
	}
	public void setInitialMap(AdjVertex<T> initialMap) {
		this.initialMap = initialMap;
	}
	public AdjVertex<T> getDestinyMap() {
		return destinyMap;
	}
	public void setDestinyMap(AdjVertex<T> destinyMap) {
		this.destinyMap = destinyMap;
	}
	public AdjVertex<T> getInitialClue() {
		return initialClue;
	}
	public void setInitialClue(AdjVertex<T> initialClue) {
		this.initialClue = initialClue;
	}
	public AdjVertex<T> getDestinyClue() {
		return destinyClue;
	}
	public void setDestinyClue(AdjVertex<T> destinyClue) {
		this.destinyClue = destinyClue;
	}
	public void setRight(User<T> right) {
		this.right = right;
	}	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
