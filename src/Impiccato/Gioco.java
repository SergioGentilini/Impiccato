package Impiccato;

import java.util.ArrayList;

public class Gioco {
    private String parolaSegreta;
    private char vettoreParolaSegreta[];
    private int tentativiErrati;
    private boolean completo = false;
    private ArrayList<Character> tentativi = new ArrayList<>();
    private ArrayList<GiocoOsservatori> osservatori = new ArrayList<>();

    public Gioco() {
        nuovaParola();
    }

    private void nuovaParola() {
        Dizionario diz = new Dizionario();
        tentativi.clear();
        tentativiErrati = 0;
        completo = false;

        parolaSegreta = diz.prendiParola();
        vettoreParolaSegreta = parolaSegreta.toLowerCase().toCharArray();
    }

    public void creaTentativo(char lett) {
        for (char lettereInTentativi : tentativi) {
            if (lett == lettereInTentativi) return;
        }

        tentativi.add(lett);
        verificaErrore(lett);
        notificaOsservatori();
        verificaFine();
    }

    public String ottieniParolaSegreta() {
        return parolaSegreta;
    }

    public void aggiungiOsservatori(GiocoOsservatori oss) {
        osservatori.add(oss);
    }

    private void notificaOsservatori() {
        for (GiocoOsservatori giocoOss : osservatori) {
            giocoOss.aggiorna(this);
        }
    }

    private void verificaErrore(char lett) {
        for (char lettera : vettoreParolaSegreta) {
            if (lett == lettera) return;
        }

        tentativiErrati += 1;
    }

    private void verificaFine() {
        if (tentativiErrati >= 6) {
            System.out.println("Hai perso!");
            nuovaParola();
            notificaOsservatori();
        }
        if (completo == true) {
            System.out.println("Hai vinto!");
            nuovaParola();
            notificaOsservatori();
        }
    }

    public ArrayList<Character> ottieniLettereConosciute() {
        return tentativi;
    }

    public void stampaImpiccato() {
        System.out.println(restituisciImpiccato());
        System.out.println(restituisciParola());
    }

    public String stampaImpiccatoStringa() {
        return restituisciImpiccato() + "\n" + restituisciParola();
    }

    private String restituisciParola() {
        String parola = "";
        boolean presente;
        completo = true;

        for (int i = 0; i < vettoreParolaSegreta.length; i++) {
            presente = false;
            if ((i == 0) || (i == (vettoreParolaSegreta.length - 1))) parola += vettoreParolaSegreta[i];
            else {
                for (char lettera : tentativi) {
                    if (lettera == vettoreParolaSegreta[i]) {
                        parola += lettera;
                        presente = true;
                    }
                }

                parola += " ";
                if (!presente) parola += "_";
                completo = false;
            }
        }

        return parola;
    }

    private String restituisciImpiccato() {
        switch (tentativiErrati) {
            case 0:
                return "+-----+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========";
            case 1:
                return "+-----+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========";
            case 2:
                return "+-----+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========";
            case 3:
                return "+-----+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========";
            case 4:
                return "+-----+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========";
            case 5:
                return "+-----+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========";
            case 6:
                return "+-----+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "=========";
            default:
                return "Errore.";
        }
    }
}
