import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Chat server started on port 5000...");

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New client connected: " + clientSocket);
            new ClientHandler(clientSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
            synchronized (clientWriters) {
                clientWriters.add(out);
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected: " + socket);
            } finally {
                try { socket.close(); } catch (IOException e) {}
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}
