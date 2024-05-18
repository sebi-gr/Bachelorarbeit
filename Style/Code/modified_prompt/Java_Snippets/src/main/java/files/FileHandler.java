package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * This class demonstrates typical features of Java file handling.
 */
public class FileHandler {

    private static final Logger LOGGER = Logger.getLogger(FileHandler.class.getName());

    /**
     * Reads the content of a file.
     *
     * @param filePath the path of the file to be read
     * @throws IOException if an I/O error occurs
     */
    public void readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.severe("Error reading file: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Writes content to a file. If the file already exists, it will be overwritten.
     *
     * @param filePath the path of the file to be written
     * @param content the content to be written to the file
     * @throws IOException if an I/O error occurs
     */
    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            LOGGER.severe("Error writing to file: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Appends content to a file. If the file does not exist, it will be created.
     *
     * @param filePath the path of the file to be appended
     * @param content the content to be appended to the file
     * @throws IOException if an I/O error occurs
     */
    public void appendToFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        } catch (IOException e) {
            LOGGER.severe("Error appending to file: " + e.getMessage());
            throw e;
        }
    }
}