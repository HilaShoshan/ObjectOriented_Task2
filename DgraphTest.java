package Testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dataStructure.DGraph;
import dataStructure.node_data;
import utils.Point3D;
import java.util.Collection;
import java.util.List;


class DGraphTest {
	DGraph g = new DGraph();

	node_data n4;
	node_data n5;
	node_data n6;
	node_data n7;
	node_data n8;
	node_data n9;
	@BeforeEach

	void init() {


		DGraph g2=g;
		n4=	g2.addNode(new Node(0,new Point3D(0,0),6)); 
		n5=g2.addNode(new Node(1,new Point3D(-10,-10),3)); 
		n6=g2.addNode(new Node(2,new Point3D(0,20),1)); 
		n7=g2.addNode(new Node(3,new Point3D(10,10),2)); 
		n8=g2.addNode(new Node(4,new Point3D(20,0),4)); 
		n9=g2.addNode(new Node(5,new Point3D(10,-10),8)); 

		for(int i=1;i<9;i++) {
			g2.connect(0, i, 3);
		}
	}
	public void shortestPathToString(List<node_data> l){
		String ans = "";
		//for(node_data n : l)
	}

	@Test
	void testGetNode1() {
		DGraph g2 = g;

		assertEquals(n4,g2.getNode(1));
	}
	@Test
	void testGetNode() {
		DGraph g4=g;

		for(int j=0;j<5;j++) {
			assertEquals(g4.getNode(j).getKey(),j);
		}
	}
	@Test
	void testGetEdge() {
		DGraph g3=g;

		for(int j=0;j<5;j++) {
			assertEquals(g3.getEdge(j, j+1).getDest(),j+1);
			assertEquals(g3.getEdge(j, j+1).getSrc(),j);	
		}
	}

	@Test
	void testAddNode() {

		fail("Not yet implemented");
	}
	@Test
	void testConnect() {
		DGraph g5=g;

		g5.connect(0, 3, 1);
		g5.connect(3, 4, 5);
		g5.connect(4, 5, 1);
		g5.connect(5, 2, 6);
		//graph.connect(2, 3, 3);
		g5.connect(3, 1, 4);
		g5.connect(1, 0, 2);
		g5.connect(3, 0, 10);

		fail("Not yet implemented");
	}
	@Test
	void getVgetEtest() {
		DGraph g6=g;
		Collection<node_data> nod=g6.getV();
		for(node_data a:nod) {
			Collection<edge_data> edg=g6.getE(a.getKey());
			for(edge_data e:edg) {
				assertEquals(e.getSrc(),a.getKey());
				assertEquals(e.getDest(),a.getKey()+1);
			}	
		}
		assertEquals(g6.nodeSize(),6);
		assertEquals(g6.edgeSize(),5);
	}


	@Test
	void testremoveNodeAndEdgeTest() {

		DGraph g7=g;
		assertEquals(g7.nodeSize(),9);
		assertEquals(g7.edgeSize(),8);

		g7.removeEdge(0, 8);
		assertEquals(g7.edgeSize(),7);
		g7.removeEdge(0, 8);
		assertEquals(g7.edgeSize(),7);	
		g7.removeNode(0);
		assertEquals(g7.edgeSize(),0);
		assertEquals(g7.nodeSize(),8);

		g7.removeNode(0);
		assertEquals(g7.nodeSize(),8);

		for(int x=1;x<9;x++) {
			g7.removeNode(x);
		}
		assertEquals(g7.nodeSize(),0);
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
		DGraph g8=g;
		assertEquals(g8.getMC(),17);//9 nodes + 8 edges = 17 changes
		g8.removeNode(0);
		assertEquals(g8.getMC(),18);//remove node = 1 change
		g8.removeEdge(0, 7);
		assertEquals(g8.getMC(),18);//nothing changed

		for(int y=1;y<8;y++) {
			g8.connect(y, y+1, y*2.3);
			g8.connect(y+1, y, y*2.3);
		}
		g8.connect(1, 8, 5);
		g8.connect(8, 1, 6.1);
		assertEquals(g8.getMC(),34);

		g8.removeNode(5);
		assertEquals(g8.getMC(),35);
		g8.removeEdge(5, 6);
		assertEquals(g8.getMC(),35);//nothing changed

	}

}