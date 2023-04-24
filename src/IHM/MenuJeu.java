package IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuJeu extends JPanel {

    JLabel messageTour;
    JTextArea historique;
    JButton annuler, refaire, recommencer;

    public MenuJeu(FenetreJeu fenetreJeu) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        messageTour = new JLabel("Tour du joueur 1");
        add(messageTour);

        historique = new JTextArea();
        historique.setEditable(false);
        add(historique);

        annuler = new JButton("Annuler");
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fenetreJeu.annuler();
                System.out.println("On annule");
            }
        });
        add(annuler);

        refaire = new JButton("Refaire");
        refaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fenetreJeu.refaire();
                System.out.println("On refais");
            }
        });
        add(refaire);

        recommencer = new JButton("Recommencer");
        recommencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fenetreJeu.recommencer();
                System.out.println("On recommence");
            }
        });
        add(recommencer);
    }
}
