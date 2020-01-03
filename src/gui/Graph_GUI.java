package gui;

import algorithms.Graph_Algo;
import dataStructure.Node;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph_GUI extends JFrame implements ActionListener, MouseListener {

    private Graph_Algo ga;

    //getter
    public Graph_Algo getGA() {
        return this.ga;
    }

    //constructor
    public Graph_GUI() {
        this.ga = new Graph_Algo();
        init();
    }

    private void drawGraph(boolean algo, List<node_data> path) {
        StdDraw.setCanvasSize(800,600);

        //find the scale size
        double INF = Double.MAX_VALUE, MINF = Double.MIN_VALUE;
        double minX = INF, maxX = MINF, minY = INF, maxY = MINF;
        for(node_data n : ga.getGraph().getV()) {
            Point3D p = n.getLocation();
            if(p.x() > maxX) maxX = p.x();
            if(p.x() < minX) minX = p.x();
            if(p.y() > maxY) maxY = p.y();
            if(p.y() < minY) minY = p.y();
        }
        int space = 3; //a number that we'll add to the length & width to be space
        StdDraw.setXscale(minX - space, maxX + space);
        StdDraw.setYscale(minY - space, maxY + space);

        //draw all the edges that come out of each vertex:

        if(algo)  //if the method was triggered by an algorithm (shortestPath/TSP)
            paintPath(path, minX, maxX, maxY);
        for(node_data n : ga.getGraph().getV()) {
            for(int dest : ((Node)n).getNeighbors().keySet()) {
                String e = n.getKey() + "," + dest; //e = edge that begins on n and ends on dest.
                Point3D p_src = n.getLocation();
                Point3D p_dest = ga.getGraph().getNode(dest).getLocation();
                if(!algo || !path.toString().contains(e)) { //checks if e is part of the path (so there is already an orange line there).
                    StdDraw.setPenColor(Color.PINK);
                    StdDraw.setPenRadius(0.006);
                    StdDraw.line(p_src.x(), p_src.y(), p_dest.x(), p_dest.y());
                }
                //calculate the space to take from dest, to put the arrow
                double x_space = p_src.x() * 0.05 + p_dest.x() * 0.95;
                double y_space = p_src.y() * 0.05 + p_dest.y() * 0.95;
                //add a triangle that represents the head of the arrow
                StdDraw.picture(x_space, y_space,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOAV_8t4Cpta3s1rFNJSvA9OyGs9eyKfuV4Zb0sPE8-3mEZj3O&s",
                        0.2, 0.4);
                //calculate the space to take from dest, to put the edge's weight
                x_space = p_src.x() * 0.22 + p_dest.x() * 0.88;
                y_space = p_src.y() * 0.22 + p_dest.y() * 0.88;
                //draw the edge's weight
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.setPenRadius(0.04);
                String w = Double.toString(ga.getGraph().getEdge(n.getKey(), dest).getWeight());
                StdDraw.text(x_space,y_space + 0.2, w);
            }
        }

        //draw each vertex & it's key
        for(node_data n : ga.getGraph().getV()) {
            StdDraw.setPenColor(Color.black);
            StdDraw.setPenRadius(0.05);
            Point3D p = n.getLocation();
            StdDraw.point(p.x(),p.y());
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.text(p.x(), p.y(),n.getKey() + "");
        }
    }

    private void paintPath(List<node_data> path, double minX, double maxX, double maxY) {
        StdDraw.setPenColor(Color.orange);
        StdDraw.setPenRadius(0.006);
        Iterator<node_data> itr = path.iterator();
        while(itr.hasNext()) {
            node_data current = itr.next();
            Point3D p_curr = current.getLocation();
            if(itr.hasNext()) {
                node_data next = itr.next();
                Point3D p_next = next.getLocation();
                StdDraw.line(p_curr.x(), p_curr.y(), p_next.x(), p_next.y());
            }
        }
        double midX = (minX + maxX) /2;
        StdDraw.setPenColor(Color.ORANGE);
        StdDraw.setPenRadius(0.08);
        StdDraw.text(midX, maxY + 0.15, "The shortest path: " + path.toString());
    }

    private void init() {
        this.setVisible(true);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("graph");
        Menu menu2 = new Menu("algorithms");
        Menu menu3 = new Menu("add/remove");
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        this.setMenuBar(menuBar);

        MenuItem item = new MenuItem("show graph");
        item.addActionListener(this);

        MenuItem item1 = new MenuItem("save");
        item1.addActionListener(this);

        MenuItem item2 = new MenuItem("load");
        item2.addActionListener(this);

        menu1.add(item);
        menu1.add(item1);
        menu1.add(item2);

        MenuItem item3 = new MenuItem("isConnected");
        item3.addActionListener(this);

        MenuItem item4 = new MenuItem("shortestPathDist");
        item4.addActionListener(this);

        MenuItem item5 = new MenuItem("shortestPath");
        item5.addActionListener(this);

        MenuItem item6 = new MenuItem("TSP");
        item6.addActionListener(this);

        menu2.add(item3);
        menu2.add(item4);
        menu2.add(item5);
        menu2.add(item6);

        MenuItem item7 = new MenuItem("addNode");
        item7.addActionListener(this);

        MenuItem item8 = new MenuItem("connect");
        item8.addActionListener(this);

        MenuItem item9 = new MenuItem("removeNode");
        item9.addActionListener(this);

        MenuItem item10 = new MenuItem("removeEdge");
        item10.addActionListener(this);

        menu3.add(item7);
        menu3.add(item8);
        menu3.add(item9);
        menu3.add(item10);

        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //graph menu
        if(e.getActionCommand() == "show graph") {
            this.drawGraph(false, null);
        }
        if(e.getActionCommand() == "save") {
            String name = (String)JOptionPane.showInputDialog(this, "write the name of the file you want to save: ");
            ga.save(name);
        }
        if(e.getActionCommand() == "load") {
            String name = (String)JOptionPane.showInputDialog(this, "write the name of the file you want to save: ");
            ga.init(name);
        }
        //algorithms menu
        if(e.getActionCommand() == "isConnected") {
            boolean b = ga.isConnected();
            if(b) {
                JOptionPane.showMessageDialog(this, "The graph is connected :)",
                        "isConnected result", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "The graph is NOT connected !",
                        "isConnected result", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if(e.getActionCommand() == "shortestPathDist") {
            String[] s = askPath();
            if(s.length != 2) throw new RuntimeException("please choose 2 keys");
            int key1 = Integer.parseInt(s[0]);
            int key2 = Integer.parseInt(s[1]);
            double d = ga.shortestPathDist(key1,key2);
            String message = "The length of the shortest path in your graph is: " + d;
            JOptionPane.showMessageDialog(this, message,"shortestPathDist result", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getActionCommand() == "shortestPath") {
            String[] s = askPath();
            if(s.length != 2) throw new RuntimeException("please choose 2 keys");
            int key1 = Integer.parseInt(s[0]);
            int key2 = Integer.parseInt(s[1]);
            List<node_data> path = this.ga.shortestPath(0,2);
            drawGraph(true, path);
        }
        if(e.getActionCommand() == "TSP") {
            String path = (String)JOptionPane.showInputDialog(this,
                    "write a list of integers representing the keys\n" +
                            "of all the vertexes you want to reach.\n" +
                            "Format: int,int,..,int, WITHOUT SPACES");
            String[] s = path.split(",");
            List<Integer> reach = new ArrayList<Integer>();
            for(int i = 0; i < s.length; i++) {
                int k = Integer.parseInt(s[i]);
                reach.add(k);
            }
            drawGraph(true, ga.TSP(reach));
        }
        //add/remove menu
    }

    private String[] askPath() {
        String path = (String)JOptionPane.showInputDialog(this,
                "write the source and the destination keys (integers)\n" +
                        "with a ',' between them, WITHOUT SPACES.\n " +
                        "[like this: src,dest]");
        String[] s = path.split(",");
        return s;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
