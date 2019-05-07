package Console;

import Impiccato.Gioco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Gioco gioco;

    public Server(Gioco gioc) {
        gioco = gioc;
        avviaServer();
    }

    private void avviaServer() {
        try {
            int port = 8888;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            System.out.println("Connessione ricevuta!");

            while (true) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                char lettera = in.readLine().toLowerCase().toCharArray()[0];

                gioco.creaTentativo(lettera);
                out.write(gioco.stampaImpiccatoStringa());
                out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
