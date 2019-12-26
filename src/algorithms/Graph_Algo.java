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

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
	private DGraph g;

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
		Iterator itr = g.getV().iterator();
		node first = (node)itr.next();
		node next;
		if(!isFirstConnected(first)) return false;
		while(itr.hasNext()) {
			next = (node)itr.next();
			if(!isConnectedToDest(next, first)) return false;
		}
		return true;
	}

	private boolean isFirstConnected(node node) {
		Iterator itr = g.getV().iterator();
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
		Iterator itr = node.getNeighbors().keySet().iterator();
		if(itr.hasNext() && g.getNode((Integer)itr.next()).getTag() == 0) {
			g.getNode((Integer)itr.next()).setTag(1);
			return isConnectedToDest((node)itr.next(), dest);
		}
		return false;
	}

	private void paintAll() {
		Iterator a = g.getV().iterator();
		int i;
		while(a.hasNext()) {
			i = (Integer)a.next();
			this.g.getNode(i).setTag(0);
		}
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
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
