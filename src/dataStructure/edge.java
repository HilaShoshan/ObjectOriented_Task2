package dataStructure;

import java.io.Serializable;

public class edge implements edge_data, Serializable {

    private int src;
    private int dest;
    private double weight;
    private String info;
    private int tag;

    public edge() {
        src = 0;
        dest = 0;
        weight = 0;
        info = "";
        tag = 0;
    }

    public edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public edge(edge copy) {
        this.src = copy.src;
        this.dest = copy.dest;
        this.weight = copy.weight;
        this.info = copy.info;
        this.tag = copy.tag;
    }

    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
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

}
