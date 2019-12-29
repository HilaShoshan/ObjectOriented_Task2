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
	private List<node_data> showShortestPass = null ;
	

	public DGraph getGraph() {
		return this.g;
	}

	@Override
	public void init(graph g) {
		this.g =(DGraph) g;
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
			out.writeObject(g);
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
		if(g.nodeSize() == 0) return true;
		paintAll(); //init all the graph's vertex in white (tag = 0)
		Iterator<node_data> itr = g.getV().iterator();
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
		Iterator<node_data> itr = g.getV().iterator();
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
			if(g.getNode(next).getTag() == 0) { //tag = 0 means that we haven't dealt with it yet
				g.getNode(next).setTag(1);
				return isConnectedToDest((node)(g.getNode(next)), dest);
			}
		}
		return false;
	}

	private void paintAll() {
		Iterator<node_data> itr = g.getV().iterator();
		while(itr.hasNext()) {
			itr.next().setTag(0);
		}
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		PriorityQueue<node> pQueue = new PriorityQueue<node>(); //a PriorityQueue that saves all the vertex by the weights.
		weightAll(src, pQueue);
		node s = (node)this.g.getNode(src); //convert to the node with the key src;
		node d = (node)this.g.getNode(dest); //node with key = dest;
		this.showShortestPass.add(s);
		node current;
		String newInfo;
		Iterator<Integer> itr;
		while(!pQueue.isEmpty()) {
			current = pQueue.peek();
			newInfo = Integer.toString(current.getKey());
			current.setInfo(current.getInfo() + newInfo + ",");
			pQueue.poll(); //the vertex with the lowest dis will get out the queue each time
			this.showShortestPass.add(current);
			itr = current.getNeighbors().keySet().iterator();
			while(itr.hasNext())
				relaxation(current, (node)g.getNode(itr.next()), pQueue);
			// ? update the queue after
		}
		return d.getDis(); //s.getWeight() +
	}

	private void weightAll(int src, PriorityQueue<node> pQueue) {
		Iterator<node_data> itr = this.g.getV().iterator();
		node next;
		while (itr.hasNext()) {
			next = (node)itr.next();
			if(next.getKey() != src)
				next.setDis(Double.MAX_VALUE); //the initial distances of all the other vertexes are INFINITY.
			else next.setDis(0);
			pQueue.add(next);
		}
	}

	private void relaxation(node n, node adj, PriorityQueue<node> pQueue) {
		double edgeW = g.getEdge(n.getKey(),adj.getKey()).getWeight();
		String adj_name;
		if(adj.getDis() > n.getDis() + adj.getWeight() + edgeW) {
			adj.setDis(n.getDis() + adj.getWeight() + edgeW);
			adj_name = Integer.toString(adj.getKey());
			adj.setInfo(n.getInfo() + adj_name + ",");
			pQueue.add(adj);
		}
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		
		 return this.showShortestPass;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}


}
