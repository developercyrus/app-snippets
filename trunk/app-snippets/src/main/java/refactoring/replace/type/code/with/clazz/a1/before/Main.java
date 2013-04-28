package refactoring.replace.type.code.with.clazz.a1.before;

public class Main {
    public static void main(String[] args) {
        Item book = new Item(Item.TYPECODE_BOOK, "History", 4800);
        Item dvd = new Item(Item.TYPECODE_DVD, "Alien", 3000);
        Item software = new Item(Item.TYPECODE_SOFTWARE, "Emulator", 3200);
        
        System.out.println("book = " + book.toString());
        System.out.println("dvd = " + dvd.toString());
        System.out.println("software = " + software.toString());
    }
}
