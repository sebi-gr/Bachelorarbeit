import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    private static String UPLOADED_FOLDER = "/temp/";

    @PostMapping("/upload") 
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return "Bitte wählen Sie eine Datei zum Hochladen aus.";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            return "Datei erfolgreich hochgeladen: '" + file.getOriginalFilename() + "'";

        } catch (IOException e) {
            e.printStackTrace();
            return "Fehler beim Hochladen der Datei: '" + file.getOriginalFilename() + "'";
        }

    }

}