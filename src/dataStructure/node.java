package dataStructure;

import utils.Point3D;
import java.util.Comparator;
import java.util.HashMap;

public class node implements node_data, Comparator<Object> {

    private int key;
    private double weight; //a variable that will save the distances at shortestPathDist method;
    private Point3D location;
    private String info;
    private int tag;
    private HashMap<Integer, edge_data> neighbors = new HashMap<Integer, edge_data>();
    private boolean isVisit;

    public node() {
        key = 0;
        weight = 0;
        location = null;
        info = "";
        tag = 0;
        isVisit = false;
    }

    public node(int key, double weight, Point3D location) {
        this.key = key;
        this.weight = weight;
        this.location = location;
    }

    public node(int key) {
        this.key = key;
    }

    public node(node copy) {
        this.key = copy.key;
        this.weight = copy.weight;
        this.location = copy.location;
        this.info = copy.info;
        this.tag = copy.tag;
        this.isVisit = copy.isVisit;
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

    public boolean getIsVisit() {
    	return this.isVisit;
    }
    
    public void setIsVisit(boolean b) {
    	this.isVisit = b; 
    }
    
    //implements Compare method in Comparator

    /**
     * this method compare between two objects (it will be nodes).
     * used for the priorityQueue in shortestPath method (Graph_Algo class).
     * the comparison is made by dis parameter of the nodes (bigger dis --> bigger node).
     * @param o1 = the first node to compare
     * @param o2 = the second node
     * @return: 0 - if the nodes are similar
     *          1 - if the first one is bigger
     *          -1 - else
     */
    @Override
    public int compare(Object o1,Object o2){
        if(!(o1 instanceof node) || !(o2 instanceof node))
            throw new RuntimeException("CAN NOT COMPARE: one or more of the objects are not instanceof node!");

        node n1=(node)o1;
        node n2=(node)o2;

        if(n1.getWeight() == n2.getWeight())
            return 0;
        else if(n1.getWeight() > n2.getWeight())
            return 1;
        else
            return -1;
    }
}

