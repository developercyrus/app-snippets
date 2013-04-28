package refactoring.replace.type.code.with.clazz.a1.after;

public class Item {
    private ItemType itemType;
    private String title;
    private int price;
    
    public Item(ItemType itemType, String title, int price) {
        this.itemType = itemType;
        this.title = title;
        this.price = price;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    @Override
    public String toString() {
        return 
            "[" 
            + this.itemType.getTypeCode() + ", " 
            + this.getTitle() + ", " 
            + this.getPrice() + ", "
            + "]";
    }
}
