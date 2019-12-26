package dataStructure;

import utils.Point3D;
import java.util.HashMap;

public class node implements node_data {

    private int key;
    private double weight;
    private Point3D location;
    private String info;
    private int tag;
    private HashMap<Integer, edge_data> neighbors = new HashMap<Integer, edge_data>();

    public node() {
        key = 0;
        weight = 0;
        location = null;
        info = "";
        tag = 0;
    }

    public node(int key, double weight, Point3D location) {
        this.key = key;
        this.weight = weight;
        this.location = location;
    }

    public node(int key, double weight) {
        this.key = key;
        this.weight = weight;
    }

    public node(node copy) {
        this.key = copy.key;
        this.weight = copy.weight;
        this.location = copy.location;
        this.info = copy.info;
        this.tag = copy.tag;
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public Point3D getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(Point3D p) {
        this.location = p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;

    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {

        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }


    public HashMap<Integer, edge_data> getNeighbors(){
        return this.neighbors;
    }


    public void setNeighbors(int dest, edge e) {
        this.neighbors.put(dest, e);
    }
}
