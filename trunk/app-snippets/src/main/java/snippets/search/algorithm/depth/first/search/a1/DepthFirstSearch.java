package snippets.search.algorithm.depth.first.search.a1;

public class DepthFirstSearch {
    public Node search(Node node) {
        System.out.println("Go down to " + node.getID());
        
        Node[] childs = node.getChild();
        
        for (Node child : childs) {
            if (!child.isVisited()) {
                Node n = this.search(child);
                System.out.println("Go up to " + node.getID());
            }
        }

        node.setVisited(true);                        
        return node;
    }
    
    public static void main(String[] args) {
        Node root = new Node("0", 1);        
        Node n_1 = new Node("1", 1);     
        Node n_2 = new Node("2", 1);        
        Node n_1_1 = new Node("1.1", 1);        
        Node n_1_2 = new Node("1.2", 1);        
        Node n_2_1 = new Node("2.1", 1);        
        Node n_2_2 = new Node("2.2", 1);        
        Node n_2_3 = new Node("2.3", 1);
                
        n_1.addChild(n_1_1);        
        n_1.addChild(n_1_2);       
        n_2.addChild(n_2_1);        
        n_2.addChild(n_2_2);        
        n_2.addChild(n_2_3);        
        root.addChild(n_1);        
        root.addChild(n_2);        
                 
        DepthFirstSearch dfs = new DepthFirstSearch();        
        Node n = dfs.search(root);        
    }
}
