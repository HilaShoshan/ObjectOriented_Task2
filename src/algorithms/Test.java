package algorithms;

import dataStructure.DGraph;
import dataStructure.node;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DGraph g = new DGraph();
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
		System.out.println("main2");
		System.out.println(ga.isConnected());
	}

}
