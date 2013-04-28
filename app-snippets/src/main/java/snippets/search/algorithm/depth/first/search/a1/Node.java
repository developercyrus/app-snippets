package snippets.search.algorithm.depth.first.search.a1;

import java.util.List;
import java.util.ArrayList;

public class Node {
    private List<Node> childList;     
    private boolean visited;    
    private double value;    
    private String id;

    public Node() {
        childList = new ArrayList<Node>();
    }
    
    public Node(String id) {
        this(id, 0);
    }
    
    public Node(String id, double value) {
        childList = new ArrayList<Node>();        
        this.id = id;
        this.value = value;
    }
    
    public void addChild(Node n) {
        childList.add(n);    
    }
    
    public Node[] getChild() {
        Node[] childs = new Node[childList.size()];        
        return (Node[])childList.toArray(childs); 
    }

    public boolean isLeaf() {
        if ( childList.size() == 0 ) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void setVisited(boolean visited) {
        System.out.println(id + " is traversed");
        this.visited = visited;
    }   
    
    public boolean isVisited() {
        return visited;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
    
    public String getID() {
        return id;
    }
}
