package Testing;

import dataStructure.DGraph;
import dataStructure.graph;
import algorithms.Graph_Algo;
import dataStructure.node_data;
import utils.Point3D;
import static org.junit.jupiter.api.Assertions.*;
import dataStructure.node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class DGraphTest {



	DGraph g = new DGraph();
	@BeforeEach
	void init() {

		node n1 = new node(0,34);
		node n2 = new node(1,5);
		node n3 = new node(2,50);
		node_data n4 = new node(0,0,new Point3D(50, 10));
		node_data n5 = new node(0,0,new Point3D(10, 10));
		node_data n6 = new node(0,0,new Point3D(50, 40));
		node_data n7 = new node(0,0,new Point3D(33, 25));
		node_data n8 = new node(0,0,new Point3D(10, 40));
		node_data n9 = new node(0,0,new Point3D(33, 50));
	}

	public void shortestPathToString(List<node_data> l){
		String ans = "";
		//for(node_data n : l)
	}

	@Test
	void testGetNode1() {
		assertEquals(n1,g.getNode(1));

		DGraph g = new DGraph();
		node n1 = new node(0,34);
		node n2 = new node(1,5);
		node n3 = new node(2,50);


	}
	@Test
	void testGetNode() {
		assertEquals(n2,g.getNode(1));
	}
	@Test
	void testGetEdge() {
		fail("Not yet implemented");
	}
	@Test
	void testAddNode() {


		graph.addNode(n4);
		graph.addNode(n5);
		graph.addNode(n6);
		graph.addNode(n7);
		graph.addNode(n8);
		graph.addNode(n9);

		fail("Not yet implemented");
	}
	@Test
	void testConnect() {

		graph.connect(0, 3, 1);
		graph.connect(3, 4, 5);
		graph.connect(4, 5, 1);
		graph.connect(5, 2, 6);
		//graph.connect(2, 3, 3);
		graph.connect(3, 1, 4);
		graph.connect(1, 0, 2);
		graph.connect(3, 0, 10);

		fail("Not yet implemented");
	}
	@Test
	void testGetV() {

		fail("Not yet implemented");
	}
	@Test
	void testGetE() {
		fail("Not yet implemented");
	}
	@Test
	void testRemoveNode() {

		graph.removeNode(n4);
		graph.removeNode(n5);
		graph.removeNode(n6);
		graph.removeNode(n7);
		graph.removeNode(n8);
		graph.removeNode(n9);

		fail("Not yet implemented");
	}
	@Test
	void testRemoveEdge() {
		fail("Not yet implemented");
	}
	@Test
	void testNodeSize() {
		fail("Not yet implemented");
	}
	@Test
	void testEdgeSize() {
		fail("Not yet implemented");
	}
	@Test
	void testGetMC() {
		fail("Not yet implemented");
	}

	}