package com.ddth.challenge.shtp.model;

public class FormEdgesData {
	private String from;
	private String to;
	private int distance;
	private int cost;

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setDistance(int distance) {
		this.distance = distance;
    }
    
    public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public int getDistance() {
		return distance;
    }
    
    public int getCost() {
		return cost;
	}
}
