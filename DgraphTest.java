package Testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dataStructure.DGraph;
import dataStructure.node_data;
import utils.Point3D;
import dataStructure.node;
import java.util.List;


class DGraphTest {

	private DGraph getDGraph1() {
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
		n1 = new node(0,34);
		n2 = new node(1,5);
		n3 = new node(2,50);
		n4 = new node(0,1,new Point3D(50, 10));
		n5 = new node(0,0,new Point3D(10, 10));
		n6 = new node(0,3,new Point3D(50, 40));
		n7 = new node(0,9,new Point3D(33, 25));
		n8 = new node(4,0,new Point3D(10, 40));
		n9 = new node(7,0,new Point3D(33, 50));
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
}
private DGraph getDGraph2() {
	DGraph tmp=new DGraph();
	tmp.addNode(new Node(0,new Point3D(0,0),6,"",0)); 
	tmp.addNode(new Node(1,new Point3D(-10,-10),3,"",0)); 
	tmp.addNode(new Node(2,new Point3D(0,20),1,"",0)); 
	tmp.addNode(new Node(3,new Point3D(10,10),2,"",0)); 
	tmp.addNode(new Node(4,new Point3D(20,0),4,"",0)); 
	tmp.addNode(new Node(5,new Point3D(10,-10),8,"",0)); 
	tmp.addNode(new Node(6,new Point3D(0,-20),10,"",0)); 
	tmp.addNode(new Node(7,new Point3D(-10,10),2.5,"",0)); 
	tmp.addNode(new Node(8,new Point3D(-20,0),7,"",0)); 
	for(int i=1;i<9;i++) {
		tmp.connect(0, i, 3);
	}
	return tmp;
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

	DGraph dg2=getDGraph2();
	assertEquals(dg2.nodeSize(),9);
	assertEquals(dg2.edgeSize(),8);

	dg2.removeEdge(0, 8);
	assertEquals(dg2.edgeSize(),7);
	dg2.removeEdge(0, 8);
	assertEquals(dg2.edgeSize(),7);	
	dg2.removeNode(0);
	assertEquals(dg2.edgeSize(),0);
	assertEquals(dg2.nodeSize(),8);

	dg2.removeNode(0);
	assertEquals(dg2.nodeSize(),8);

	for(int x=1;x<9;x++) {
		dg2.removeNode(x);
	}
	assertEquals(dg2.nodeSize(),0);
}

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
	DGraph dg3=getDGraph2();
	assertEquals(dg3.getMC(),17);//9 nodes + 8 edges = 17 changes
	dg3.removeNode(0);
	assertEquals(dg3.getMC(),18);//remove node = 1 change
	dg3.removeEdge(0, 7);
	assertEquals(dg3.getMC(),18);//nothing changed

	for(int y=1;y<8;y++) {
		dg3.connect(y, y+1, y*2.3);
		dg3.connect(y+1, y, y*2.3);
	}
	dg3.connect(1, 8, 5);
	dg3.connect(8, 1, 6.1);
	assertEquals(dg3.getMC(),34);

	dg3.removeNode(5);
	assertEquals(dg3.getMC(),35);
	dg3.removeEdge(5, 6);
	assertEquals(dg3.getMC(),35);//nothing changed

}

}