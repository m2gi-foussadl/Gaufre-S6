package IHM;

import Modele.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuJeu extends JPanel {

    JLabel messageTour;
    JTextArea historique;
    JButton annuler, refaire, recommencer;

    public MenuJeu(FenetreJeu fenetreJeu) {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        messageTour = new JLabel("Tour du joueur 1", JLabel.CENTER);
        messageTour.setFont(new Font("Impact", Font.BOLD, 20));
        messageTour.setPreferredSize(new Dimension(500, 100));
        add(messageTour, BorderLayout.PAGE_START);

        historique = new JTextArea(1, 20);
        historique.setEditable(false);
        add(historique, BorderLayout.CENTER);

        JPanel sideBar = new JPanel(new GridLayout(3, 1, 0, 20));
        sideBar.setBackground(Color.white);

        annuler = new JButton("Annuler");
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fenetreJeu.annuler();
                System.out.println("On annule");
                historique.append("Le joueur " + fenetreJeu.plateauGraphique.plateau.getTurnPlayer() + " annule son coup\n");
            }
        });
        sideBar.add(annuler);

        refaire = new JButton("Refaire");
        refaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fenetreJeu.refaire();
                System.out.println("On refais");
                historique.append("Le joueur " + fenetreJeu.plateauGraphique.plateau.getTurnPlayer() + " refais son coup\n");
            }
        });
        sideBar.add(refaire);

        recommencer = new JButton("Recommencer");
        recommencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fenetreJeu.recommencer();
                System.out.println("On recommence");
            }
        });
        sideBar.add(recommencer);

        add(sideBar, BorderLayout.LINE_END);
    }

    public void refresh(FenetreJeu fenetreJeu) {
        Plateau plateau = fenetreJeu.plateauGraphique.plateau;

        if (plateau.getTurnPlayer() == 1) {
            messageTour.setText("Tour du joueur 1");
        } else {
            messageTour.setText("Tour du joueur 2");
        }
    }
}
