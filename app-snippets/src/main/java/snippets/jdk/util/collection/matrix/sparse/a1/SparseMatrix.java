package snippets.jdk.util.collection.matrix.sparse.a1;

import java.util.HashMap;

class SparseMatrix<T> extends HashMap<Integer, T> {
    private static final long serialVersionUID = 1L;
    T defaultValue;
    
    public SparseMatrix(T v) {
        defaultValue = v;
    }
    
    public T get(Integer key) {
        T v = super.get(key);
        return v == null ? defaultValue : v;
    }
    
    @Override
    public T put(Integer key, T value) {
        if(value.equals(defaultValue)) return defaultValue;
        return super.put(key, value);
    }
}