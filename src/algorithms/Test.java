package algorithms;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataStructure.DGraph;
<<<<<<< HEAD
import dataStructure.node;
import dataStructure.node_data;
import javafx.geometry.Point3D;
=======
import dataStructure.Node;
>>>>>>> a9032e4190c1ed11148d390bd4633529357c75a0

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


<<<<<<< HEAD
		/*DGraph g = new DGraph();
		node n1 = new node(0);
		node n2 = new node(1);
		node n3 = new node(2);
		node n4 = new node(3);
		node n5 = new node(4);
=======
		DGraph g = new DGraph();
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
>>>>>>> a9032e4190c1ed11148d390bd4633529357c75a0
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
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(0);
		Iterator<node_data> itr = ga.TSP(list).iterator();
		while(itr.hasNext())
			System.out.print(((node)(itr.next())).getKey() +",");
		
		g.removeNode(2);
		ga.init(g);
		System.out.println(ga.TSP(list));*/
	
		DGraph test = new DGraph();
		for (int i = 0; i<1000;i++){
          //Point3D tP = new Point3D(10,i);
          node n = new node(i);
          test.addNode(n);

      }
      for (int i=0;i<999;i++){
          test.connect(i,i+1,i*10+100);
      }
      test.connect(999,0,1000);

      for (int i =0;i<10000;i++){
          int r =  (int)(Math.random()*999);
          int r2 = (int)(Math.random()*999);
          if (r!= r2) {
              test.connect(r, r2, r + i);
          }
      }
      List<Integer> tar = new ArrayList<>();
      for (int i = 0;i<1000;i++){
          int r = (int)(Math.random()*3);
          if (r==2){
              tar.add(i);
          }
      }
      System.out.println(tar.size());
      Date date = new Date();
      Graph_Algo ga = new Graph_Algo();
      ga.init(test);
      double ff = date.getTime();
      System.out.println(ga.shortestPathDist(1, 300));
      date = new Date();
      double f = date.getTime();
      System.out.println(f-ff);
      //System.out.println(t.size());
		
	}

}
