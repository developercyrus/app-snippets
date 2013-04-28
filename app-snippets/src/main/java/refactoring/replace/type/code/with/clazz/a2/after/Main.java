package refactoring.replace.type.code.with.clazz.a2.after;

public class Main {
    public static void main(String[] args) {
        Item book = new Item(ItemType.BOOK, "History", 4800);
        Item dvd = new Item(ItemType.DVD, "Alien", 3000);
        Item software = new Item(ItemType.SOFTWARE, "Emulator", 3200);        
        
        System.out.println("book = " + book.toString());
        System.out.println("dvd = " + dvd.toString());
        System.out.println("software = " + software.toString());
    }
}
