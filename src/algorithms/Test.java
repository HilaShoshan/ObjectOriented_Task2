package algorithms;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.node_data;
import utils.Point3D;

public class Test {

    public static void amichaiTest() {
        DGraph test = new DGraph();
        for (int i = 0; i<1000;i++){
            //Point3D tP = new Point3D(10,i);
            Node n = new Node(i);
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
        System.out.println(ga.TSP(tar).size());
        date = new Date();
        double f = date.getTime();
        System.out.println(f-ff);
    }

    public static void test1() {
        DGraph g = new DGraph();
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
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
        System.out.println(ga.isConnected());
    }

    public static void test2() {
        DGraph g = new DGraph();
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);

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

        System.out.println("shortestPathDist: " + ga.shortestPathDist(0,2));
        System.out.println("shortestPath: " + ga.shortestPath(0, 2));
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(0);
        List<node_data> l = ga.TSP(list);
        System.out.println("TSP:" + l);
        Iterator<node_data> itr = l.iterator();
        while(itr.hasNext())
            System.out.print(((Node)(itr.next())).getKey() + ",");

        /*g.removeNode(2);
        ga.init(g);
        System.out.println(ga.TSP(list));*/
    }

    public static void test3() {
        Node n1 = new Node(0, new utils.Point3D(3,5));
        Node n2 = new Node(1, new utils.Point3D(-2,5));
        Node n3 = new Node(2, new utils.Point3D(3,-5));
        Node n4 = new Node(3, new Point3D(2,7));
        DGraph g = new DGraph();
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.connect(0,1, 8);
        g.connect(1,0, 15);
        g.connect(2,3, 4);
        g.connect(1,2, 7);

        Graph_Algo ga = new Graph_Algo();
        ga.init(g);

        System.out.println(ga.shortestPathDist(0,2));
    }

    public static void main(String[] args) {
        test3();
        //test2();
    }
}
