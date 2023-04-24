package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Observable;

public class FenetreJeu {

    JFrame frame;

    public FenetreJeu() {
        frame = new JFrame("Jeu en cours");

        MenuJeu menu = new MenuJeu();
        PlateauGraphique plateauGraphique = new PlateauGraphique();
        frame.addMouseListener(plateauGraphique);

        frame.setLayout(new BorderLayout());

        frame.add(menu, BorderLayout.LINE_END);

        frame.add(plateauGraphique);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        frame.setVisible(true);
    }
}
