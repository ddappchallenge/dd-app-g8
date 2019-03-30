package com.ddth.challenge.shtp.model;

public class FormGraphData {
	private String[] nodes;
	private FormEdgesData[] edges;

	public void setNodes(String[] nodes) {
		this.nodes = nodes;
	}

	public void setEdges(FormEdgesData[] edges) {
		this.edges = edges;
	}

	public String[] getNodes() {
		return nodes;
    }
    
    public FormEdgesData[] getEdges() {
		return edges;
	}
}
