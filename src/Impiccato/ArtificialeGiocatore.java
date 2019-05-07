package Impiccato;

import java.util.Random;

public class ArtificialeGiocatore extends Giocatore {
    @Override
    public void scegliLettera(Gioco gioc) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        char lettere[] = alfabeto.toCharArray();
        int dimensioni = lettere.length;

        Random casuale = new Random();

        char lettera = lettere[casuale.nextInt(dimensioni)];

        gioc.creaTentativo(lettera);
    }

    @Override
    public void aggiorna(Gioco gioc) {
        gioc.stampaImpiccato();
    }
}
