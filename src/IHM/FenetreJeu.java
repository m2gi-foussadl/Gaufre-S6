package IHM;

import javax.swing.*;
import java.awt.*;

public class FenetreJeu {

    JFrame frame;

    MenuJeu menu;
    PlateauGraphique plateauGraphique;

    public FenetreJeu() {
        frame = new JFrame("Jeu en cours");
        frame.setLayout(new BorderLayout());

        menu = new MenuJeu(this);
        menu.setSize(new Dimension(frame.getWidth() / 3, frame.getHeight()));
        frame.add(menu, BorderLayout.LINE_END);

        plateauGraphique = new PlateauGraphique();
        frame.add(plateauGraphique, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1500, 800));
        frame.setVisible(true);
    }

    public void annuler() {

    }

    public void refaire() {

    }

    public void recommencer() {

    }
}
