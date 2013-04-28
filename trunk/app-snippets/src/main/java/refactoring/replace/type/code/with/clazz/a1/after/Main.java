package refactoring.replace.type.code.with.clazz.a1.after;

public class Main {
    public static void main(String[] args) {
        /* 
         * allows compile time validation checking, to prevent 
         * any passing in any integer constant to instantiate object
         */
        Item book = new Item(ItemType.BOOK, "History", 4800);
        Item dvd = new Item(ItemType.DVD, "Alien", 3000);
        Item software = new Item(ItemType.SOFTWARE, "Emulator", 3200);
        
        System.out.println("book = " + book.toString());
        System.out.println("dvd = " + dvd.toString());
        System.out.println("software = " + software.toString());
    }
}
