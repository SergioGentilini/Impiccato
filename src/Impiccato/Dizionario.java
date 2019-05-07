package Impiccato;

import java.util.ArrayList;
import java.util.Random;

public class Dizionario {
    private ArrayList<String> parole = new ArrayList<>();

    public Dizionario() {
        aggiungiParole();
    }

    private void aggiungiParole() {
        parole.add("Sternocleidomastoideo");
        parole.add("Jojoba");
        parole.add("Entomofago");
        parole.add("ABS");
        parole.add("Catecolamina");
        parole.add("Subecumenico");
        parole.add("Usufruttuario");
    }

    public String prendiParola() {
        int dimensioni = parole.size();
        Random casuale = new Random();
        int indiceCasuale = casuale.nextInt(dimensioni);

        String parola = parole.get(indiceCasuale);

        return parola;
    }
}
