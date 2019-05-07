package ProvaServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainProvaServer {
    public static void main(String[] args) {
        try {
            int port = 8888;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();

            out.write("Aefada");

            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
