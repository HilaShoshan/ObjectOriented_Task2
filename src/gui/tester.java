package gui;

import algorithms.Graph_Algo;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import dataStructure.DGraph;
import dataStructure.Node;
import utils.Point3D;

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
        g.addNode(new Node(6)); //***** error ....





    }
}
