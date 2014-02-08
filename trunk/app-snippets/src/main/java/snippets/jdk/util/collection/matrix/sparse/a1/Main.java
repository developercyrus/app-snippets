package snippets.jdk.util.collection.matrix.sparse.a1;

public class Main {
    public static void main(String[] args) {
        SparseMatrix a = new SparseMatrix<Integer>(0);
        SparseMatrix b = new SparseMatrix<Double>(0.0);
        a.put(1, 2);
        b.put(1, 2.1);
        
        System.out.println(a.get(1));
        System.out.println(b.get(1));
    }
}
