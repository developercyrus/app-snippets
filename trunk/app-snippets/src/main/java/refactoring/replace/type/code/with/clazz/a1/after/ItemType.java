package refactoring.replace.type.code.with.clazz.a1.after;

public class ItemType {
    private int typeCode;
    private ItemType(int typeCode) {
        this.typeCode = typeCode;
    }
    
    public static final ItemType BOOK = new ItemType(0);
    public static final ItemType DVD = new ItemType(1);
    public static final ItemType SOFTWARE = new ItemType(2);
    
    public int getTypeCode() {
        return typeCode;
    }
}
