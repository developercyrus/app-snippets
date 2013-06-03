package snippets.jdk.io.randomaccessfile.a1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo {
    final static int nameSize = 15;
    final static int bookSize = 10;

    public static void main(String[] args) throws IOException {
        Student[] students = { 
            new Student("Peter", "Java", 96),
            new Student("John", "Networking", 95),
            new Student("Mary", "OS", 88), 
        };

        String path = Demo.class.getResource("").getFile() + "output";
        File file = new File(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        for (int i = 0; i < students.length; i++) {
            randomAccessFile.writeChars(students[i].getName());
            randomAccessFile.writeInt(students[i].getScore());
            randomAccessFile.writeChars(students[i].getBook());
        }

        for (int i = 0; i < students.length; i++) {
            randomAccessFile.seek(i * Student.size());
            System.out.println("name:\t[" + readChar(randomAccessFile, nameSize) + "]");
            System.out.println("score:\t[" + randomAccessFile.readInt() + "]");
            System.out.println("book:\t[" + readChar(randomAccessFile, bookSize) + "]");
        }
        randomAccessFile.close();

    }

    private static String readChar(RandomAccessFile randomAccessfile, int length) throws IOException {
        char[] name = new char[length];
        for (int i = 0; i < length; i++) {
            name[i] = randomAccessfile.readChar();
        }
        return new String(name).replace('\0', ' ');
    }
}
