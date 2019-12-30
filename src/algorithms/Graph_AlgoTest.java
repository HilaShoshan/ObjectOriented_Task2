package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.javafx.geom.Edge;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edge;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;

class Graph_AlgoTest {

	DGraph g = new DGraph();
	node_data n4;
	node_data n5;
	node_data n6;
	node_data n7;
	node_data n8;
	node_data n9;

	@BeforeEach
	void init() {
		Graph_Algo ga = new Graph_Algo();
		DGraph dg = new DGraph();
		ga.init(dg);
		boolean ans = ga.getG() == dg;
		assertEquals(true, ans);

		n4 = new node(0,0,new Point3D(50, 10));
		n5 = new node(0,0,new Point3D(10, 10));
		n6 = new node(0,0,new Point3D(50, 40));
		n7 = new node(0,0,new Point3D(33, 25));
		n8 = new node(0,0,new Point3D(10, 40));
		n9 = new node(0,0,new Point3D(33, 50));
	}



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
	Graph_Algo ga = new Graph_Algo();
	for(int i=0;i<11;i++) {//0 1 2 3 4 5 6 7 8 9 10
		ga.getG().addNode(new node(i,0,new Point3D(i, i)));;
	}
	for(int j=0;j<10;j++) {
		ga.getG().connect(j,j+1 , 2);
	}
	assertEquals(false,ga.isConnected());
	ga.getG().connect(10, 0, 50);
	assertEquals(true,ga.isConnected());
}
/**
 * returns the length of the shortest path between src to dest
 * @param src - start node
 * @param dest - end (target) node
 * @return
 */


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
	Graph_Algo ga = new Graph_Algo();
	ga.getG().addNode(new node());
	ga.getG().addNode(new node(1,2,new Point3D(5, 5)));
	ga.getG().connect(0, 1, 2);
	graph ga2 =new DGraph();
	ga2 =ga.copy();
	Collection<edge_data> cl = ga2.getE(0);
	for(edge_data e: cl) {
		edge ed = (edge)e;
		assertEquals(true, ed.getSrc() == 0 && ed.getDest() == 1);
	}
}
}


