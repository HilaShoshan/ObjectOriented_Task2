package algorithms;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.DGraph;
import dataStructure.node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author
 *
 */

public class Graph_Algo implements graph_algorithms{
	private DGraph g;


	public DGraph getGraph() {
		return this.getG();
	}

	@Override
	public void init(graph g) {
		this.setG((DGraph) g);
	}

	@Override
	public void init(String file_name) {
		DGraph t = null;
		try
		{
			FileInputStream file = new FileInputStream(file_name);
			ObjectInputStream in = new ObjectInputStream(file);

			t = (DGraph)in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized");

		}
		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}
	}

	@Override
	public void save(String file_name) {

		try
		{
			FileOutputStream file = new FileOutputStream(file_name);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(getG());
			out.close();
			file.close();
			System.out.println("Object has been serialized");
		}
		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}
	}

	@Override
	public boolean isConnected() {
		if(getG().nodeSize() == 0) return true;
		paintAll(); //init all the graph's vertex in white (tag = 0)
		Iterator<node_data> itr = getG().getV().iterator();
		node first = (node)itr.next(); //itr has next for sure, because we checked that g has more than 0 nodes
		node next;
		if(!isFirstConnected(first)) return false;
		while(itr.hasNext()) {
			next = (node)itr.next();
			if(!isConnectedToDest(next, first)) return false;
		}
		return true;
	}

	private boolean isFirstConnected(node node) {
		Iterator<node_data> itr = getG().getV().iterator();
		boolean connected;
		while(itr.hasNext() && itr.next() != node) {
			connected = isConnectedToDest(node, (node)itr.next());
			if(!connected) return false;
		}
		return true;
	}

	private boolean isConnectedToDest(node node, node dest) {
		if(node.getNeighbors().keySet().contains(dest.getKey())) {
			dest.setTag(1);
			return true;
		}
		Iterator<Integer> itr = node.getNeighbors().keySet().iterator();
		if(itr.hasNext()) {
			int next = itr.next();
			if(getG().getNode(next).getTag() == 0) { //tag = 0 means that we haven't dealt with it yet
				getG().getNode(next).setTag(1);
				return isConnectedToDest((node)(getG().getNode(next)), dest);
			}
		}
		return false;
	}

	private void paintAll() {
		Iterator<node_data> itr = getG().getV().iterator();
		while(itr.hasNext()) {
			itr.next().setTag(0);
		}
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		PriorityQueue<node> pQueue = new PriorityQueue<node>(getG().nodeSize(), new nodeComparator()); //a PriorityQueue that saves all the vertex by the weights.
		weightAll(src, pQueue);
		node d = (node)this.getG().getNode(dest);
		node s = (node)this.getG().getNode(src); //convert to the node with the key src;
		s.setInfo("");
		node current;
		String newInfo;
		String lastInfo;
		Iterator<Integer> itr;
		while(!pQueue.isEmpty()) {
			current = pQueue.peek();
			newInfo = Integer.toString(current.getKey());
			String[] spl = current.getInfo().split(",");
			lastInfo = spl[spl.length - 1];
			if(!lastInfo.equals(newInfo))
				current.setInfo(current.getInfo() + newInfo + ",");
			pQueue.poll(); //the vertex with the lowest weight will get out the queue each time
			itr = current.getNeighbors().keySet().iterator();
			while(itr.hasNext())
				relaxation(current, (node)getG().getNode(itr.next()), pQueue);
		}
		return d.getWeight();
	}

	private void weightAll(int src, PriorityQueue<node> pQueue) {
		Iterator<node_data> itr = this.getG().getV().iterator();
		node next;
		while (itr.hasNext()) {
			next = (node)itr.next();
			if(next.getKey() != src)
				next.setWeight(Double.MAX_VALUE); //the initial distances of all the other vertexes are INFINITY.
			else next.setWeight(0);
			pQueue.add(next);
		}
	}

	private void relaxation(node n, node adj, PriorityQueue<node> pQueue) {
		double edgeW = getG().getEdge(n.getKey(),adj.getKey()).getWeight();
		String adj_name;
		if(adj.getWeight() > n.getWeight() + edgeW) {
			adj.setWeight(n.getWeight() + edgeW);
			adj_name = Integer.toString(adj.getKey());
			adj.setInfo(n.getInfo() + adj_name + ",");
			pQueue.add(adj);
		}
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		node d = (node)this.getG().getNode(dest); //convert to the node with the key dest;
		String[] pathArr = d.getInfo().split(",");
		List<node_data> path = new ArrayList<node_data>();
		for(int i=0; i<pathArr.length; i++) {
			path.add(getG().getNode(Integer.parseInt(pathArr[i])));
		}
		return path;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		
		return null;
	}

	@Override
	public graph copy() {
		Graph_Algo ga = new Graph_Algo();
		DGraph newG = new DGraph();
		Iterator<node_data> itr = this.getG().getV().iterator();
		while(itr.hasNext()) {
			newG.addNode(itr.next());
		}
		//maybe we should copy all the elements in the hashMap also...
		ga.init(newG);
		return newG;
	}

	public DGraph getG() {
		return g;
	}

	public void setG(DGraph g) {
		this.g = g;
	}
}

class nodeComparator implements Comparator<node>{

	@Override
	public int compare(node o1,node o2){

		node n1=(node)o1;
		node n2=(node)o2;

		if(n1.getWeight() == n2.getWeight())
			return 0;
		else if(n1.getWeight() > n2.getWeight())
			return 1;
		else
			return -1;
	}
}


