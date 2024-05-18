package base.files;

import java.io.IOException;

public class MainFiles {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("test.txt");
        try {
            fileHandler.createFile();
            fileHandler.writeToFile("Hello, World!");
            fileHandler.readFromFile();
            fileHandler.deleteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
