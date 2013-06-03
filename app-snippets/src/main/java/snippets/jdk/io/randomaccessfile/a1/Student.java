package snippets.jdk.io.randomaccessfile.a1;

public class Student {
    private String name;
    private String book;
    private int score;

    final static int nameSize = 15;
    final static int bookSize = 10;

    final static int charLength = 2;
    final static int intLength = 4;

    public Student() {
        setName("noname");
    }

    public Student(String name, String book, int score) {
        setName(name);
        setBook(book);
        this.score = score;
    }

    public void setName(String name) {
        StringBuilder builder = null;
        if (name != null)
            builder = new StringBuilder(name);
        else
            builder = new StringBuilder(nameSize);

        builder.setLength(nameSize);
        this.name = builder.toString();
    }

    public void setBook(String book) {
        StringBuilder builder = null;
        if (book != null)
            builder = new StringBuilder(book);
        else
            builder = new StringBuilder(bookSize);

        builder.setLength(bookSize);
        this.book = builder.toString();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getBook() {
        return book;
    }

    public int getScore() {
        return score;
    }

    public static int size() {
        // 54 byte
        // name: 2 bytes * 15
        // book: 2 bytes * 10
        // score: 4 bytes

        return (charLength * nameSize) + (charLength * bookSize) + intLength;
    }
}
