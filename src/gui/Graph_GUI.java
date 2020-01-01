package gui;

import algorithms.Graph_Algo;
import utils.StdDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Graph_GUI extends JFrame implements ActionListener, MouseListener {

    Graph_Algo ga;

    //constructor
    public Graph_GUI() {
        this.ga = new Graph_Algo();
        init();
    }

    private void drawGraph() {
        StdDraw.setCanvasSize(800,700);
        StdDraw.setScale(-10,10);
        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.005);
    }

    private void init() {
        this.setVisible(true);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("graph");
        Menu menu2 = new Menu("algorithms");
        menuBar.add(menu1);
        menuBar.add(menu2);
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

        MenuItem item7 = new MenuItem("copy");
        item7.addActionListener(this);

        menu2.add(item3);
        menu2.add(item4);
        menu2.add(item5);
        menu2.add(item6);
        menu2.add(item7);

        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //graph menu
        if(e.getActionCommand() == "show graph") { //*********
            this.drawGraph();
        }
        if(e.getActionCommand() == "save") {
            String name = (String)JOptionPane.showInputDialog(this, "write the name of the file you want to save: ");
            ga.save(name);
        }
        if(e.getActionCommand() == "load") {

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
