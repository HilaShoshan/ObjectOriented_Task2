package gui;

import algorithms.Graph_Algo;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import dataStructure.DGraph;
import dataStructure.Node;
import utils.Point3D;

import java.util.concurrent.TimeUnit;

public class tester
{
    public static void main(String[] args) {
       /* Graph_GUI gg = new Graph_GUI();
        Node n1 = new Node(0, new Point3D(3,5));
        Node n2 = new Node(1, new Point3D(-2,5));
        Node n3 = new Node(2, new Point3D(3,-5));
        Node n4 = new Node(3, new Point3D(2,7));
        gg.getGA().getGraph().addNode(n1);
        gg.getGA().getGraph().addNode(n2);
        gg.getGA().getGraph().addNode(n3);
        gg.getGA().getGraph().addNode(n4);
        gg.getGA().getGraph().connect(0,1, 8);
        gg.getGA().getGraph().connect(1,0, 15);
        gg.getGA().getGraph().connect(2,3, 4);
        gg.getGA().getGraph().connect(1,2, 7);
        gg.getGA().getGraph().connect(1,3, 30);*/

        DGraph g = new DGraph();
        Node n1 = new Node(0, new Point3D(3,5));
        Node n2 = new Node(1, new Point3D(-2,5));
        Node n3 = new Node(2, new Point3D(3,-5));
        Node n4 = new Node(3, new Point3D(2,7));
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.connect(0,1, 8);
        g.connect(1,0, 15);
        g.connect(2,3, 4);
        g.connect(1,2, 7);
        g.connect(1,3, 30);
        Graph_Algo ga = new Graph_Algo();
        ga.init(g);
        Graph_GUI gg = new Graph_GUI(ga);
        //g.addNode(new Node(6));

        /*Graph_Algo GA = new Graph_Algo();

        Node N1 = new Node(1, new Point3D(0,-5));
        Node N2 = new Node(2, new Point3D(3,4));
        Node N3 = new Node(3, new Point3D(4,-10));
        Node N4 = new Node(4, new Point3D(2,11));
        Node N5 = new Node(5, new Point3D(-15,4));

        GA.getGraph().addNode(N1);
        GA.getGraph().addNode(N2);
        GA.getGraph().addNode(N3);
        GA.getGraph().addNode(N4);
        GA.getGraph().addNode(N5);

        GA.getGraph().connect(1,5,3);
        GA.getGraph().connect(5,2,2);
        GA.getGraph().connect(2,3,5);
        GA.getGraph().connect(3,4,6);
        GA.getGraph().connect(4,3,7);
        GA.getGraph().connect(3,1,4);
        GA.getGraph().connect(3,5,1);

        Graph_GUI gg = new Graph_GUI(GA);

        for(int i = 0; i < 10;i++){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GA.getGraph().addNode(new Node(6+i, new Point3D(-7+i, 15)));
        }*/
    }
}
