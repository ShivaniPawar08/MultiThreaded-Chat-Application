import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Thread to read messages from server
        new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Server: " + line);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
            }
        }).start();

        // Main thread reads input from console and sends to server
        String input;
        while ((input = console.readLine()) != null) {
            out.println(input);
        }
    }
}
