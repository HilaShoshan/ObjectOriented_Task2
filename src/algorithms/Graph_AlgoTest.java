package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edge;
import dataStructure.node;

class Graph_AlgoTest {
       

	@Test
	void testInitString() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testIsConnected() {
		DGraph g = new DGraph();
		node n1 = new node(0,34);
		node n2 = new node(1,5);
		node n3 = new node(2,50);
		//edge e1 = new edge(0,1,3);
		//edge e2 = new edge(1,2,38);
		//edge e3 = new edge(2,0,31);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.connect(0,1,3);
		g.connect(1,2,38);
		g.connect(2,0,31);

		Graph_Algo ga = new Graph_Algo();
		ga.init(g);
		boolean expected =true;
		boolean actual =ga.isConnected();
		assertEquals(expected, actual, "Test is connected");
		
	}

	@Test
	void testShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	void testTSP() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

}
