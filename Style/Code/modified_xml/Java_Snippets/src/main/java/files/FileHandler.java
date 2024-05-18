package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class provides methods for handling files in Java.
 */
public class FileHandler {

    /**
     * Reads the content of a file.
     *
     * @param fileName the name of the file to be read
     * @throws FileNotFoundException if the file does not exist
     */
    public void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }

    /**
     * Writes content to a file.
     *
     * @param fileName the name of the file to be written to
     * @param content the content to be written to the file
     * @throws IOException if an I/O error occurs
     */
    public void writeFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
