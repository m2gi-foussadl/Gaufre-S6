package IHM;

import Modele.Plateau;

import javax.swing.*;
import java.awt.*;

public class FenetreJeu {

    JFrame frame;

    MenuJeu menu;
    PlateauGraphique plateauGraphique;

    public FenetreJeu(Plateau plateau) {
        frame = new JFrame("Jeu en cours");
        frame.setSize(new Dimension(1500, 800));

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(new GridLayout(1, 2, 20, 0));
        panel.setBackground(Color.white);

        plateauGraphique = new PlateauGraphique(this, plateau);
        frame.addMouseListener(plateauGraphique);
        panel.add(plateauGraphique);

        menu = new MenuJeu(this);
        panel.add(menu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void refresh() {
        menu.refresh(this);
    }

    public void annuler() {
        refresh();
    }

    public void refaire() {
        refresh();
    }

    public void recommencer() {
        refresh();
    }
}
