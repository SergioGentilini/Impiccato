import Console.GiocatoreLocale;
import Console.InterfacciaClient;
import Console.Server;
import Impiccato.ArtificialeGiocatore;
import Impiccato.Dizionario;
import Impiccato.Gioco;

public class Principale {
    public static void main(String[] args) {
        /*Dizionario diz = new Dizionario();

        Gioco ilGioco = new Gioco();
        ArtificialeGiocatore ag = new ArtificialeGiocatore();
        ilGioco.aggiungiOsservatori(ag);

        ag.scegliLettera(ilGioco);
        ag.scegliLettera(ilGioco);*/

        Gioco ilGioco = new Gioco();
        Server servitore = new Server(ilGioco);
    }
}
