package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sun.javafx.geom.Edge;
import java.util.ArrayList;
import java.util.List;
import algorithms.Graph_Algo;
import dataStructure.Node;
import dataStructure.edge;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import dataStructure.DGraph1;

class Graph_AlgoTest {

	static Node n1=new Node ();
	static Node n2=new Node ();
	static Node n3=new Node ();
	static Node n4=new Node ();
	static DGraph1 ga1=new DGraph1();

	public static Graph_Algo ga() {
		ga1.addNode(n1);
		ga1.addNode(n2);
		ga1.addNode(n3);
		ga1.addNode(n4);
		ga1.connect(0, 2, 2);
		ga1.connect(0, 1, 3);
		ga1.connect(2, 1, 22);
		ga1.connect(2, 0,2);
		ga1.connect(1, 2,3);
		ga1.connect(1, 0, 4);
		Graph_Algo ga2 = new Graph_Algo();
		ga2.init(ga1);
		return ga2;
	}

	@Test
	void testSaveAndfile_name() {
		Graph_Algo ga1 =  ga();
		ga1.g.addNode(new Node(4,new Point3D(15, 15)));
		ga1.g.addNode(new Node(5,new Point3D(5, 5)));
		ga1.g.connect(4, 5, 2);
		ga1.save("JunitTest");
		Graph_Algo ga2 = new Graph_Algo();
		ga2.init("JunitTest");
		Collection<edge_data> c = ga2.g.getE(0);
		for(edge_data e: c) {
			edge ed = (edge)e;
			System.out.println(ed.getDest());
			assertEquals(true, ed.getSrc() == 4 && ed.getDest() == 5);
		}
	}
	/**
	 * Init a graph from file
	 * @param file_name
	 */

	@Test
	void testIsConnected() {
		Graph_Algo ga1 = ga();
		for(int i=0;i<11;i++) {//0 1 2 3 4 5 6 7 8 9 10
			ga1.g.addNode(new Node(i,new Point3D(i, i)));
		}
		for(int j=0;j<10;j++) {
			ga1.g.connect(j,j+1 , 2);
		}
		assertEquals(false,ga1.isConnected());
		ga1.g.connect(10, 0, 50);
		assertEquals(true,ga1.isConnected());
	}
	/**
	 * returns the length of the shortest path between src to dest
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */

	@Test
	void testShortestPathDist() {
		Graph_Algo ga3 = ga();
		ga3.g.addNode(new Node(0,new Point3D(-50, -50)));
		ga3.g.addNode(new Node(0,new Point3D(50, 50)));
		ga3.g.addNode(new Node(0,new Point3D(50, -50)));
		ga3.g.addNode(new Node(0,new Point3D(-50, 50)));
		ga3.g.addNode(new Node(0,new Point3D(0, -75)));
		ga3.g.addNode(new Node(0,new Point3D(0, 75)));
		ga3.g.addNode(new Node(0,new Point3D(0, 0)));
		ga3.g.connect(0,3, 2);
		ga3.g.connect(3,5, 1);
		ga3.g.connect(5,1, 5);
		ga3.g.connect(1,2, 0);
		ga3.g.connect(2,4, 6);
		ga3.g.connect(4,0, 3);
		ga3.g.connect(6,4, 4);
		ga3.g.connect(6,5, 2.5);

		assertEquals(ga3.shortestPathDist(0, 2),8);
		assertEquals(ga3.shortestPathDist(6, 2),7.5);
		assertEquals(ga3.shortestPathDist(6, 3),9);
		assertEquals(ga3.shortestPathDist(0, 6),-1);//Error: can't get to node 6

	}

	@Test
	void testShortestPath() {
		Graph_Algo ga4 = ga();
		ga4.g.addNode(new Node(0,new Point3D(0, 0)));
		ga4.g.addNode(new Node(1,new Point3D(-50,-50)));
		ga4.g.addNode(new Node(2,new Point3D(0,75)));
		ga4.g.addNode(new Node(3,new Point3D(50,50)));
		ga4.g.addNode(new Node(4,new Point3D(50,-50)));
		ga4.g.addNode(new Node(5,new Point3D(0,-75)));
		ga4.g.addNode(new Node(6,new Point3D(-50,50)));
		ga4.g.connect(0,1, 1);
		ga4.g.connect(0,2, 2);
		ga4.g.connect(0,3, 3);
		ga4.g.connect(0,4, 4);
		ga4.g.connect(0,5, 5);
		ga4.g.connect(0,6, 6);
		ga4.g.connect(1,0, 6);
		ga4.g.connect(2,0, 5);
		ga4.g.connect(3,0, 4);
		ga4.g.connect(4,0, 3);
		ga4.g.connect(5,0, 2);
		ga4.g.connect(6,0, 1);
		ga4.g.connect(6,1, 0);
		ga4.g.connect(1,2, 0);
		ga4.g.connect(2,3, 0);
		ga4.g.connect(3,4, 0);
		ga4.g.connect(4,5, 0);
		ga4.g.connect(5,6, 0);

		List<node_data> ans1=new ArrayList<>();
		ans1.add(ga4.g.getNode(6));
		ans1.add(ga4.g.getNode(1));
		ans1.add(ga4.g.getNode(2));
		List<node_data> ans2=ga4.shortestPath(6, 2);
		assertEquals(ans1,ans2);

		ans1.clear();
		List<node_data> ans3=ga4.shortestPath(0, 4);	
		ans1.add(ga4.g.getNode(0));
		ans1.add(ga4.g.getNode(1));
		ans1.add(ga4.g.getNode(2));
		ans1.add(ga4.g.getNode(3));
		ans1.add(ga4.g.getNode(4));
		assertEquals(ans1,ans3);
	}

	@Test
	void testTSP() {
		System.out.println(ga());
		Graph_Algo ga6 = ga();
		//		ga6.g.addNode(new Node(0,new Point3D(0, 0)));
		//		ga6.g.addNode(new Node(1,new Point3D(-10,-10)));
		//		ga6.g.addNode(new Node(2,new Point3D(10,10)));
		//		ga6.g.addNode(new Node(3,new Point3D(-10,10)));
		//		ga6.g.addNode(new Node(4,new Point3D(0,-20)));
		//		ga6.g.addNode(new Node(5,new Point3D(10, -10)));
		//
		//		ga6.g.connect(0,1, 1);
		//		ga6.g.connect(1,0, 1.5);
		//		ga6.g.connect(0,2, 0);
		//		ga6.g.connect(2,0, 2);
		//		ga6.g.connect(0,3, 5);
		//		ga6.g.connect(3,0, 4);
		//		ga6.g.connect(0,4, 2);
		//		ga6.g.connect(4,0, 3);
		ga6.g.connect(0,5, 1.2);
		ga6.g.connect(5,0, 2.5);

		List<Integer> targets=new ArrayList<>();
		targets.add(1);
		targets.add(2);
		targets.add(3);
		targets.add(4);
		targets.add(5);

		List<node_data> ans=ga6.TSP(targets);
		List<node_data> myAns=new ArrayList<>();
		myAns.add(ga6.g.getNode(1));
		myAns.add(ga6.g.getNode(0));
		myAns.add(ga6.g.getNode(2));
		myAns.add(ga6.g.getNode(0));
		myAns.add(ga6.g.getNode(3));
		myAns.add(ga6.g.getNode(0));
		myAns.add(ga6.g.getNode(4));
		myAns.add(ga6.g.getNode(0));
		myAns.add(ga6.g.getNode(5));

		assertEquals(myAns,ans);

		ga6.g.removeNode(0);
		ans=ga6.TSP(targets);
		assertEquals(ans,null);//Error: deleted all edges, there is no path between the nodes
	}


	@Test
	void testCopy() {
		Graph_Algo g6 = ga();
		g6.getG().addNode(new Node());
		g6.getG().addNode(new Node(1,new Point3D(8, 8)));
		g6.getG().connect(0, 1, 2);
		graph graph2 =new DGraph1();
		graph2 =g6.copy();
		Collection<edge_data> cl = graph2.getE(0);
		for(edge_data e: cl) {
			edge edg = (edge)e;
			assertEquals(true, edg.getSrc() == 0 && edg.getDest() == 1);
		}
	}
}