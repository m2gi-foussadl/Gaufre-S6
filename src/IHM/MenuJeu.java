package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuJeu extends JPanel {

    public MenuJeu() {
        setLayout(new GridBagLayout());

        JLabel tourJoueur = new JLabel("Tour du joueur 1");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(tourJoueur, constraints);

        JTextArea historique = new JTextArea("Loremmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        historique.setEditable(false);
        historique.setLineWrap(true);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        add(historique, constraints);

        JButton annuler = new JButton("Annuler");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(annuler, constraints);

        JButton refaire = new JButton("Refaire");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(refaire, constraints);
    }

    public void updateSize(Dimension size) {

    }
}
