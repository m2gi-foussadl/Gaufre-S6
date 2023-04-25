package IHM;

import Modele.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

public class FenetreGraphique extends JFrame {
    private JButton bouton1;
    private JButton bouton2;
    private JPanel f;

    public FenetreGraphique(Plateau plateau) throws IOException, FontFormatException {
        // Configuration de la fenêtre principale
        setTitle("Fenêtre Principale");

//        InputStream inputStream = getClass().getResourceAsStream("res/DANCING_JUNGLE.ttf");
//        Font policePerso = Font.createFont(Font.TRUETYPE_FONT, inputStream);
//        policePerso = policePerso.deriveFont(Font.BOLD, 70); // Spécifier le style et la taille de la police
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        ge.registerFont(policePerso); // Enregistrer la police dans le système

        //Ajouter du texte sur la fenetre
        JLabel label = new JLabel("GOUFRE EMPOISONNEE");
        //Agrandir la police
//        label.setFont(policePerso.deriveFont(200f));
        label.setHorizontalAlignment(JLabel.CENTER);

        JLabel label2 = new JLabel("CHOISISSEZ VOTRE MODE DE JEU:");
//        label2.setFont(policePerso.deriveFont(100f));
        label2.setHorizontalAlignment(JLabel.CENTER);

        // Création des boutons
        bouton1 = new JButton("PLAYER VS PLAYER") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
                super.paintComponent(g);
            }
        };
//        bouton1.setFont(policePerso); // Appliquer la police personnalisée au bouton 1
        bouton1.setPreferredSize(new Dimension(500, 100));
        //enlever le contour du bouton
        bouton1.setBorderPainted(false);


        bouton2 = new JButton("PLAYER VS IA") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
                super.paintComponent(g);
            }
        };
//        bouton2.setFont(policePerso);
        bouton2.setPreferredSize(new Dimension(500, 100));
        bouton2.setBorderPainted(false);
        bouton2.setFocusPainted(false);

        f = new JPanel();
        f.setLayout(new BorderLayout());
        label.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);

// Ajouter les labels dans le centre du JPanel
        f.add(label, BorderLayout.CENTER);
        f.add(label2, BorderLayout.SOUTH);
        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));

// Ajouter des espaces entre les composants
        f.add(Box.createRigidArea(new Dimension(0, 75))); // Ajouter un espace de 100 pixels en haut du JPanel
        f.add(label);
        f.add(Box.createRigidArea(new Dimension(0, 75))); // Ajouter un espace de 50 pixels entre label et bouton1
        f.add(label2);
        f.add(Box.createRigidArea(new Dimension(0, 75))); // Ajouter un espace de 50 pixels entre label2 et bouton2
        f.add(bouton1);
        f.add(Box.createRigidArea(new Dimension(0, 75))); // Ajouter un espace de 50 pixels entre bouton1 et bouton2
        f.add(bouton2);

        //Ajouter le JPanel dans la fenetre
        add(f, BorderLayout.CENTER);

        // Ajout des écouteurs d'événements pour les boutons
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque le bouton 1 est cliqué
                setVisible(false);
                setEnabled(false);
                FenetreJeu jeu = new FenetreJeu(plateau);
            }
        });

        bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque le bouton 2 est cliqué
                FenetreSecondaire fenetre3 = new FenetreSecondaire("Fenêtre 3");
                fenetre3.setVisible(true);
            }
        });

        // Configuration de la fenêtre principale
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Obtenir la résolution de l'écran
        setSize(screenSize.width, screenSize.height); // Adapter la taille de la fenêtre à la résolution de l'écran
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
    }

    private class FenetreSecondaire extends JFrame {
        public FenetreSecondaire(String title) {
            // Configuration de la fenêtre secondaire
            setTitle(title);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setSize(screenSize.width, screenSize.height);
            setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        }
    }
}
