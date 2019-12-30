package dataStructure;

import java.util.Collection;
import java.io.Serializable;
import java.util.HashMap;

public class DGraph implements graph, Serializable {

	HashMap<Integer, node_data> graph = new HashMap<Integer, node_data>();
	private int nodeSize = 0;
	private int edgeSize = 0;
	private int MC =0;

	@Override
	public node_data getNode(int key) {
		if(!graph.containsKey(key)) throw new RuntimeException("Error: the node is not in the graph!");
		return graph.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if(!graph.containsKey(src)) throw new RuntimeException("Error: the sorce node is not in the graph!");
		if(!((node) graph.get(src)).getNeighbors().containsKey(dest)) throw new RuntimeException("Error: the destination node is not in the graph!");
		return ((node) graph.get(src)).getNeighbors().get(dest);
	}

	@Override
	public void addNode(node_data n) {
		this.graph.put(n.getKey(), (node)n);
		this.nodeSize++;
		MC++;
	}

	public void connect(int src, int dest, double w) {
		edge e = new edge(src, dest, w);
		((node) this.graph.get(src)).setNeighbors(dest, e);
		edgeSize++;
		MC++;
	}

	@Override
	public Collection<node_data> getV() {
		return this.graph.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return ((node)(this.graph.get(node_id))).getNeighbors().values();
	}

	@Override
	public node_data removeNode(int key) {
		node copy=new node((node)getNode(key));
		this.graph.remove(key);
		nodeSize--;
		MC++;
		for (int i = 0; i < nodeSize; i++) {
			if (null!=this.graph.get(i)) {
				if(null!=((node)this.graph.get(i)).getNeighbors().get(key)){
					((node)this.graph.get(i)).getNeighbors().remove(key);
					edgeSize--;
					MC++;
				}
			}
		}
		return copy;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		edge_data copy = new edge((edge)((node)this.graph.get(src)).getNeighbors().get(dest));
		((node)this.graph.get(src)).getNeighbors().remove(dest);
		edgeSize--;
		MC++;
		return copy;
	}

	@Override
	public int nodeSize() {
		return this.nodeSize;
	}

	@Override
	public int edgeSize() {
		return this.edgeSize;
	}

	@Override
	public int getMC() {
		return MC;
	}
}
