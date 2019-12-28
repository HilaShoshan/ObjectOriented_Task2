package algorithms;

import dataStructure.node;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * this class used in shortest-path-algorithm in Graph_Algo class.
 * the Java's PriorityQueue is used here to implement our PriorityQueueNode
 * the nodes are sorted by their dis [in each poll, the node with the lowest dis will get out of the queue].
 */
public class priorityQueueNode {

    private PriorityQueue<Double> pq;
    private LinkedList<node> nOrder;

    //constructor

    public priorityQueueNode() {
        pq = new PriorityQueue<Double>();
        nOrder = new LinkedList<node>();
    }

    //getters

    public PriorityQueue<Double> getPq() {
        return this.pq;
    }
    public LinkedList<node> getnOrder() {
        return this.nOrder;
    }

    //methods

    public void addNode(node n) {
        double d = n.getDis();
        pq.add(d);
        if(nOrder.isEmpty()) nOrder.add(n);
        else {
            //while ()
        }
    }

    public void pollNode() {
        pq.poll();
    }
}
