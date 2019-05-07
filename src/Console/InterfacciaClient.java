package Console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacciaClient extends JFrame {
    private GiocatoreLocale giocLoc;

    public InterfacciaClient(GiocatoreLocale gl) throws HeadlessException {
        giocLoc = gl;

        setSize(400, 800);
        setLocation(40, 40);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pannello = new JPanel();

        JTextArea textArea = new JTextArea();
        pannello.add(textArea);

        JTextArea impiccato = new JTextArea();

        JButton button = new JButton();

        ActionListener ascoltatore = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gl.scegliLettera(textArea.getText());
            }
        };

        button.addActionListener(ascoltatore);
    }
}
