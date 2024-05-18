package base.files;

import java.io.*;
import java.nio.file.*;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void createFile() throws IOException {
        Path path = Paths.get(filePath);
        Files.createFile(path);
        System.out.println("File created at: " + filePath);
    }

    public void writeToFile(String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
        System.out.println("Content written to file");
    }

    public void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public void deleteFile() throws IOException {
        Path path = Paths.get(filePath);
        Files.delete(path);
        System.out.println("File deleted");
    }
}
