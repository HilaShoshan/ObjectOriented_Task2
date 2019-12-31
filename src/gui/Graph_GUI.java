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

    public Graph_GUI() {
        this.ga = new Graph_Algo();
        init();
    }
    private void draw(){
        StdDraw.setCanvasSize(600,700);
        StdDraw.setScale(-10,10);

        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.04);
        StdDraw.line(2,3,4,-2);
    }

    private void init() {
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        menuBar.add(menu);
        this.setMenuBar(menuBar);

        MenuItem item1 = new MenuItem("save");
        item1.addActionListener(this);

        MenuItem item2 = new MenuItem("load");
        item2.addActionListener(this);

        menu.add(item1);
        menu.add(item2);

        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println( e.getActionCommand());
        System.out.println( e.getSource());
        if(e.getActionCommand() == "save") {
            String s = (String) JOptionPane.showInputDialog(this, "hello");
            this.draw();
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
