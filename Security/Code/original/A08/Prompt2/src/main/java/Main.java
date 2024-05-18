import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        try {
            // Connect to the WebSocket server
            Socket socket = new Socket("localhost", 8080);

            // Read data from the WebSocket
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            // Convert the bytes into a ByteBuffer
            ByteBuffer byteBuffer = ByteBuffer.wrap(buffer, 0, bytesRead);

            // Deserialize the ByteBuffer into a Person object
            ByteArrayInputStream bais = new ByteArrayInputStream(byteBuffer.array());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Person person = (Person) ois.readObject();

            System.out.println("Received person: " + person.getName() + ", " + person.getAge());

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}