package Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dataStructure.DGraph1;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;
import java.util.Collection;
import java.util.List;


class DGraphTest {
	


	

	private DGraph1 getDGraph1() {
		DGraph1 g = new DGraph1();

		DGraph1 g2=g;
		Node n4=new Node(0,new Point3D(-50,-50));
		Node n5=new Node(1,new Point3D(0,75));
		Node n6=new Node(2,new Point3D(50,50));
		Node n7=new Node(3,new Point3D(50,-50));
		Node n8=new Node(4,new Point3D(0,-75));
		Node n9=new Node(5,new Point3D(-50,50));
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);
		g.addNode(n9);
		for(int i=0;i<5;i++) {
			g.connect(i, i+1, 2.5);
		}
		return g;
	}
	private DGraph1 getDGraph2() {
		DGraph1 g2=new DGraph1();
		g2.addNode(new Node(0,new Point3D(0,0))); 
		g2.addNode(new Node(1,new Point3D(-10,-10))); 
		g2.addNode(new Node(2,new Point3D(0,20))); 
		g2.addNode(new Node(3,new Point3D(10,10))); 
		g2.addNode(new Node(4,new Point3D(20,0))); 
		g2.addNode(new Node(5,new Point3D(10,-10))); 
		g2.addNode(new Node(6,new Point3D(0,-20))); 
		g2.addNode(new Node(7,new Point3D(-10,10))); 
		g2.addNode(new Node(8,new Point3D(-20,0))); 
		for(int i=1;i<9;i++) {
			g2.connect(0, i, 3);
		}
		return g2;
	}
	public void shortestPathToString(List<node_data> l){
		String ans = "";
		//for(node_data n : l)
	}

	@Test
	void testGetEdge() {
		DGraph1 g3= getDGraph1();

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
	void getVgetEtest() {
		DGraph1 g6=getDGraph1();
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

		DGraph1 g7=getDGraph1();
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
		DGraph1 g8=getDGraph1();
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