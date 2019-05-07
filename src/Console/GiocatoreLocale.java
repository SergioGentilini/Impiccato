package Console;

import Impiccato.Giocatore;
import Impiccato.Gioco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class GiocatoreLocale extends Giocatore {
    private Socket clientSocket;

    public GiocatoreLocale() {
        try {
            clientSocket = new Socket(InetAddress.getLocalHost(), 8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scegliLettera(String lettera) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aggiorna(Gioco gioc) {

    }
}
