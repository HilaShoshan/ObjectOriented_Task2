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

    private void drawGraph() {
        StdDraw.setCanvasSize(800,700);
        StdDraw.setXscale(-10,10);
        StdDraw.setYscale(-10,10);
        for(node_data n : ga.getGraph().getV()) {
            StdDraw.setPenColor(Color.black);
            StdDraw.setPenRadius(0.06);
            Point3D p =n.getLocation();
            StdDraw.point(p.x(),p.y());
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.setPenRadius(0.06);
            StdDraw.text(p.x(),p.y(),n.getKey()+"");
        }
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
            this.drawGraph();
        }
        if(e.getActionCommand() == "save") {
            String name = (String)JOptionPane.showInputDialog(this, "write the name of the file you want to save: ");
            ga.save(name);
        }
        if(e.getActionCommand() == "load") {
            String name = (String)JOptionPane.showInputDialog(this, "write the name of the file you want to save: ");
            ga.init(name);
        }
        //add/remove menu
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
            String path = (String)JOptionPane.showInputDialog(this,
                    "write the source and the destination keys with a ',' between them, like this: src,dest ");
            String[] s = path.split(",");
            if(s.length != 2) throw new RuntimeException("please choose 2 keys");
            int key1 = Integer.parseInt(s[0]);
            int key2 = Integer.parseInt(s[1]);
            double d = ga.shortestPathDist(key1,key2);
            JOptionPane.showMessageDialog(this, "The length of the shortest path in your graph is: ",
                    "shortestPathDist result", JOptionPane.PLAIN_MESSAGE);
        }

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
