package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;


/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author
 *
 */

public class Graph_Algo implements graph_algorithms{
	private DGraph g;

	//getter
	public DGraph getGraph() {
		return this.g;
	}
	/*
	 * Default constructor
	 */
	public Graph_Algo() {
		this.g = new DGraph();
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
		Node first = (Node)itr.next(); //itr has next for sure, because we checked that g has more than 0 nodes
		Node next;
		if(!isFirstConnected(first)) return false;
		while(itr.hasNext()) {
			next = (Node)itr.next();
			if(!isConnectedToDest(next, first)) return false;
		}
		return true;
	}

	private boolean isFirstConnected(Node node) {
		Iterator<node_data> itr = getG().getV().iterator();
		boolean connected;
		while(itr.hasNext() && itr.next() != node) {
			connected = isConnectedToDest(node, (Node)itr.next());
			if(!connected) return false;
		}
		return true;
	}

	private boolean isConnectedToDest(Node node, Node dest) {
		if(node.getNeighbors().keySet().contains(dest.getKey())) {
			dest.setTag(1);
			return true;
		}
		Iterator<Integer> itr = node.getNeighbors().keySet().iterator();
		if(itr.hasNext()) {
			int next = itr.next();
			if(getG().getNode(next).getTag() == 0) { //tag = 0 means that we haven't dealt with it yet
				getG().getNode(next).setTag(1);
				return isConnectedToDest((Node)(getG().getNode(next)), dest);
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
		//a PriorityQueue that saves all the vertex by the weights.
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		weightAll(src, pQueue);
		Node d = (Node)this.getG().getNode(dest); //convert to the node with the key dest;
		Node s = (Node)this.getG().getNode(src); //convert to the node with the key src;
		s.setInfo("");
		pQueue.add(s); //for start: the PQueue contains only the source (starting) Node.
		Node current;
		String newInfo;
		String lastInfo;
		Iterator<Integer> itr;
		while(!pQueue.isEmpty()) {
			current = pQueue.poll(); //the vertex with the lowest weight will get out the queue each time
			newInfo = Integer.toString(current.getKey());
			if(current.getInfo() != null) {
				String[] spl = current.getInfo().split(",");
				lastInfo = spl[spl.length - 1];
				if(!lastInfo.equals(newInfo))
					current.setInfo(current.getInfo() + newInfo + ",");
				itr = current.getNeighbors().keySet().iterator();
				while(itr.hasNext())
					relaxation(current, (Node)getG().getNode(itr.next()), pQueue);
			}
		}
		return d.getWeight();
	}

	private void weightAll(int src, PriorityQueue<Node> pQueue) {
		Iterator<node_data> itr = this.getG().getV().iterator();
		Node next;
		while (itr.hasNext()) {
			next = (Node)itr.next();
			if(next.getKey() != src) {
				next.setWeight(Double.MAX_VALUE); //the initial distances of all the other vertexes are INFINITY.
				next.setInfo(null); //init the info of all the other vertex to be null (if there is another value there from previous runs).
			}
			else next.setWeight(0);
		}
	}

	private void relaxation(Node n, Node adj, PriorityQueue<Node> pQueue) {
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
		shortestPathDist(src, dest);
		Node d = (Node)this.getG().getNode(dest); //convert to the node with the key dest;
		if(d.getInfo() == null) return null;
		String[] pathArr = d.getInfo().split(",");
		List<node_data> path = new ArrayList<node_data>();
		for(int i=0; i<pathArr.length; i++) {
			path.add(getG().getNode(Integer.parseInt(pathArr[i])));
		}
		return path;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		List<node_data> pathRes = new ArrayList<node_data>(); //the returned list of all the vertexes we visited
		setAllVisit(); //initialization
		Iterator<Integer> itr = targets.iterator();
		int current, prev = -1;
		if(itr.hasNext()) prev = itr.next();
		while(itr.hasNext()) {
			current = itr.next();
			Node curr = (Node)g.getNode(current);
			if(!curr.getIsVisit()) {
				if (findPath(pathRes, prev, current, curr)) return null;
			} else {
				while(curr.getIsVisit()) {
					if(itr.hasNext()) {
						current = itr.next();
						curr = (Node)g.getNode(current);
					}
					else break;
				}
				if (findPath(pathRes, prev, current, curr)) return null;
			}
			prev = current;
		}
		return pathRes;
	}

	/**
	 * An assistance method that helps us to set all the isVisit attribute of all the nodes in the graph.
	 * at the beginning of the algorithm, all the vertexes haven't visited yet.
	 */
	private void setAllVisit() {
		Iterator<node_data> itr = g.getV().iterator();
		while(itr.hasNext()) {
			((Node)itr.next()).setIsVisit(false);
		}
	}

	private boolean findPath(List<node_data> pathRes, int current, int next, Node n) {
		String[] arr;
		if(shortestPath(current, next) == null) return true;
		arr = n.getInfo().split(",");
		for(int i=0; i<arr.length; i++) {
			Node tmp = (Node)g.getNode(Integer.parseInt(arr[i]));
			if(pathRes.isEmpty() || (pathRes.get(pathRes.size() - 1).getKey() != tmp.getKey())) {
				tmp.setIsVisit(true);
				pathRes.add(tmp);
			}
		}
		return false;
	}

	@Override
	public graph copy() {
		Graph_Algo ga = new Graph_Algo();
		DGraph newG = new DGraph();
		Iterator<node_data> itr = this.g.getV().iterator();
		Node copy;
		while(itr.hasNext()) {
			copy = new Node((Node)itr.next());
			newG.addNode(copy);
		}
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
