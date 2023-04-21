package src.IHM;

import javax.swing.*;
import java.awt.*;

public class FenetreJeu {

    JFrame frame;

    public FenetreJeu() {
        frame = new JFrame("Jeu en cours");

        IHM.MenuJeu menu = new IHM.MenuJeu();
        IHM.PlateauGraphique plateauGraphique = new IHM.PlateauGraphique();

        frame.setLayout(new BorderLayout());
        Container pane = frame.getContentPane();

        pane.add(menu, BorderLayout.LINE_END);
        pane.add(plateauGraphique, BorderLayout.CENTER);

        frame.setSize(700, 450);
        frame.setVisible(true);
    }
}
