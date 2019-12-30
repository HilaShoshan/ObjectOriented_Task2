package dataStructure;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dataStructure.DGraph;
import dataStructure.node_data;
import utils.Point3D;
import dataStructure.node;
import java.util.List;


class DGraphTest {
	DGraph g = new DGraph();
	node_data n4;
	node_data n5;
	node_data n6;
	node_data n7;
	node_data n8;
	node_data n9;
	node n1;
	node n2;
	node n3;
	@BeforeEach
	void init() {

		n1 = new node(0,34);
		n2 = new node(1,5);
		n3 = new node(2,50);
		n4 = new node(0,0,new Point3D(50, 10));
		n5 = new node(0,0,new Point3D(10, 10));
		n6 = new node(0,0,new Point3D(50, 40));
		n7 = new node(0,0,new Point3D(33, 25));
		n8 = new node(0,0,new Point3D(10, 40));
		n9 = new node(0,0,new Point3D(33, 50));
	}

	public void shortestPathToString(List<node_data> l){
		String ans = "";
		//for(node_data n : l)
	}

	@Test
	void testGetNode1() {
		assertEquals(n1,g.getNode(1));
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


		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);
		g.addNode(n9);

		fail("Not yet implemented");
	}
	@Test
	void testConnect() {

		g.connect(0, 3, 1);
		g.connect(3, 4, 5);
		g.connect(4, 5, 1);
		g.connect(5, 2, 6);
		//graph.connect(2, 3, 3);
		g.connect(3, 1, 4);
		g.connect(1, 0, 2);
		g.connect(3, 0, 10);

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

		g.connect(0,1,3);
		g.connect(1,2,38);
		g.connect(2,0,31);
		g.removeNode(0);
		System.out.println(g.getV());

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