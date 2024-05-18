import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        String server = "ftp.example.com";
        int port = 21;
        String user = "username";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String remoteFile = "/path/to/update.jar";
            String localFile = "/path/to/save/update.jar";

            try (OutputStream outputStream = new FileOutputStream(localFile)) {
                boolean success = ftpClient.retrieveFile(remoteFile, outputStream);
                if (success) {
                    System.out.println("File has been downloaded successfully.");
                }
            }

            ftpClient.logout();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}