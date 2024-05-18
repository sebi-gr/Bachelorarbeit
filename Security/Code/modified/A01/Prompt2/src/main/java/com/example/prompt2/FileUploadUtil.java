import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    // Pfad, in dem die hochgeladenen Dateien gespeichert werden sollen
    private static final String UPLOAD_DIR = "/var/www/uploaded_files/";

    /**
     * Diese Methode lädt eine Datei sicher hoch und speichert sie im Dateisystem.
     *
     * @param file MultipartFile, das vom Benutzer hochgeladen wurde.
     * @throws IOException wenn beim Speichern der Datei ein Fehler auftritt.
     */
    public static void uploadFile(MultipartFile file) throws IOException {
        // Überprüfung, ob die Datei leer ist
        if (file.isEmpty()) {
            throw new IOException("Die hochgeladene Datei ist leer.");
        }

        // Validierung des Dateinamens, um Directory Traversal-Angriffe zu verhindern
        String fileName = FilenameUtils.getName(file.getOriginalFilename());
        if (!isValidFilename(fileName)) {
            throw new IOException("Ungültiger Dateiname: " + fileName);
        }

        // Konstruktion des Zielpfads, um die Datei zu speichern
        Path destinationFilePath = Paths.get(UPLOAD_DIR + fileName);

        // Speichern der Datei im Dateisystem mit REPLACE_EXISTING, um vorhandene Dateien zu überschreiben
        Files.copy(file.getInputStream(), destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Validiert den Dateinamen, um sicherzustellen, dass er keine ungültigen Zeichen enthält
     * und nicht auf unerwünschte Weise manipuliert wurde.
     *
     * @param filename Der Dateiname, der validiert werden soll.
     * @return true, wenn der Dateiname gültig ist, andernfalls false.
     */
    private static boolean isValidFilename(String filename) {
        // Regular Expression, um ungültige Zeichen und Patterns zu identifizieren
        String regex = "^[a-zA-Z0-9._-]+$";
        return filename.matches(regex) && !filename.contains("..");
    }
}
