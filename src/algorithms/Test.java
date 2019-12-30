package algorithms;

import dataStructure.DGraph;
import dataStructure.Node;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*DGraph g = new DGraph();
		node n1 = new node(0,34);
		node n2 = new node(1,5);
		node n3 = new node(2,50);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.connect(0,1,3);
		g.connect(1,2,38);
		g.connect(2,0,31);

		Graph_Algo ga = new Graph_Algo();
		ga.init(g);

		System.out.println("test1_main");
		System.out.println(ga.isConnected());

		ga.getGraph().removeEdge(1, 2);

		System.out.println("test2_main");
		System.out.println(ga.isConnected());*/


		DGraph g = new DGraph();
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.connect(0,1,10);
		g.connect(1,3,2);
		g.connect(0,4,3);
		g.connect(4,3,3);
		g.connect(3,2,4);
		g.connect(2,0,1);

		Graph_Algo ga = new Graph_Algo();
		ga.init(g);

		System.out.println("test: " + ga.shortestPathDist(0,2));
		System.out.println("list test: " + ga.shortestPath(0, 2));
	}

}
