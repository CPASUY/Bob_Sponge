package model;

import java.io.Serializable;
import java.util.ArrayList;
public class User <T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nickname;
	private int score;
	private User <T>  left;
	private User <T>  right;
	private AdjVertex<T> initialMap;
	private AdjVertex<T> destinyMap;
	private AdjVertex<T> initialClue;
	private AdjVertex<T> destinyClue;
	private AdjVertex<T> initialClue2;
	private AdjVertex<T> destinyClue2;
	private long startTime;
	private long endTime;
	private boolean validateC2;
	private boolean validateC3;
	private int weightMap;
	private int weightClue;
	private int weightClue2;
	
	public User(String n,int s) {
		nickname = n;
		score = s;
		startClue2= false;
		validateC2=false;
		validateC3=false;
		weightMap= 0;
		weightClue =0;
		weightClue2=0;
	}
	public long getStartTime() {
		return startTime;
	}
	public boolean isValidateC2() {
		return validateC2;
	}
	public void setValidateC2(boolean validateC2) {
		this.validateC2 = validateC2;
	}
	public boolean isValidateC3() {
		return validateC3;
	}
	public void setValidateC3(boolean validateC3) {
		this.validateC3 = validateC3;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	private User <T>  father;
	private boolean startClue2;
	
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public ArrayList<AdjVertex<T>> adjMap() {
		ArrayList<AdjVertex<T>> d = new ArrayList<AdjVertex<T>>();
		for (int i=0; i<initialMap.getAdjList().size(); i++) {
				d.add(initialMap.getAdjList().get(i).getDestination());
		}
		return d;
	}
	
	public ArrayList<AdjVertex<T>> adjChallenge() {
		ArrayList<AdjVertex<T>> d = new ArrayList<AdjVertex<T>>();
		for (int i=0; i<initialClue.getAdjList().size(); i++) {
				d.add(initialClue.getAdjList().get(i).getDestination());
		}
		return d;
	}
	
	public ArrayList<AdjVertex<T>> adjChallenge2() {
		ArrayList<AdjVertex<T>> d = new ArrayList<AdjVertex<T>>();
		for (int i=0; i<initialClue2.getAdjList().size(); i++) {
				d.add(initialClue2.getAdjList().get(i).getDestination());
		}
		return d;
	}
	
	public void sumWeightMap() {
		for(int i =0;i<initialMap.getAdjList().size();i++) {
		if(initialMap.getAdjList().get(i).getInitial() == initialMap && initialMap.getAdjList().get(i).getDestination() == destinyMap ) {
				weightMap+=initialMap.getAdjList().get(i).getWeight();
			}
		}
	}
	
	public void sumWeightClue() {
		for(int i =0;i<initialClue.getAdjList().size();i++) {
		if(initialClue.getAdjList().get(i).getInitial() == initialClue && initialClue.getAdjList().get(i).getDestination() == destinyClue) {
				weightClue+=initialClue.getAdjList().get(i).getWeight();
			}
		}
	}
	
	public void sumWeightClue2() {
		for(int i =0;i<initialClue2.getAdjList().size();i++) {
		if(initialClue2.getAdjList().get(i).getInitial() == initialClue2 && initialClue2.getAdjList().get(i).getDestination() == destinyClue2) {
				weightClue2+=initialClue2.getAdjList().get(i).getWeight();
			}
		}
	}
	
	public AdjVertex<T> getInitialClue2() {
		return initialClue2;
	}
	public void setInitialClue2(AdjVertex<T> initialClue2) {
		this.initialClue2 = initialClue2;
	}
	public AdjVertex<T> getDestinyClue2() {
		return destinyClue2;
	}
	public void setDestinyClue2(AdjVertex<T> destinyClue2) {
		this.destinyClue2 = destinyClue2;
	}
	public boolean isStartClue2() {
		return startClue2;
	}
	public void setStartClue2(boolean startClue2) {
		this.startClue2 = startClue2;
	}
	public int getWeightMap() {
		return weightMap;
	}
	public void setWeightMap(int weightMap) {
		this.weightMap = weightMap;
	}
	public int getWeightClue() {
		return weightClue;
	}
	public void setWeightClue(int weightClue) {
		this.weightClue = weightClue;
	}
	public int getWeightClue2() {
		return weightClue2;
	}
	public void setWeightClue2(int weightClue2) {
		this.weightClue2 = weightClue2;
	}
}
