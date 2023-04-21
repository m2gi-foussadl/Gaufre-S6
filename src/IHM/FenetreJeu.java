package IHM;

import javax.swing.*;
import java.awt.*;

public class FenetreJeu {

    JFrame frame;

    public FenetreJeu() {
        frame = new JFrame("Jeu en cours");

        MenuJeu menu = new MenuJeu();
        PlateauGraphique plateauGraphique = new PlateauGraphique();

        frame.setLayout(new BorderLayout());
        Container pane = frame.getContentPane();

        pane.add(menu, BorderLayout.LINE_END);
        pane.add(plateauGraphique, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setVisible(true);
    }
}
