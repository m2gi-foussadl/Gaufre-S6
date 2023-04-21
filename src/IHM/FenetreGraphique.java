package src.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;

public class FenetreGraphique extends JFrame {
    private JButton bouton1;
    private JButton bouton2;


    public FenetreGraphique() throws IOException, FontFormatException {
        // Configuration de la fenêtre principale
        setTitle("Fenêtre Principale");

        InputStream inputStream = getClass().getResourceAsStream("../../DANCING JUNGLE.ttf");
        Font policePerso = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        policePerso = policePerso.deriveFont(Font.BOLD, 70); // Spécifier le style et la taille de la police
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(policePerso); // Enregistrer la police dans le système

        //Ajouter du texte sur la fenetre
        JLabel label = new JLabel("GOUFRE EMPOISONNEE");
        //Agrandir la police
        label.setFont(policePerso.deriveFont(200f));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        // Création des boutons
        bouton1 = new JButton("PLAYER VS PLAYER"){
            @Override
            protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            super.paintComponent(g);
        }
        };
        bouton1.setFont(policePerso); // Appliquer la police personnalisée au bouton 1
        bouton1.setPreferredSize(new Dimension(500, 200));
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
        bouton2.setFont(policePerso);
        bouton2.setPreferredSize(new Dimension(500, 200));
        bouton2.setBorderPainted(false);
        bouton2.setFocusPainted(false);

        // Création d'un panneau pour contenir les boutons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 450));
        panel.add(bouton1);
        panel.add(bouton2);

        // Ajout du panneau à la fenêtre principale
        add(panel);


        // Ajout des écouteurs d'événements pour les boutons
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action à effectuer lorsque le bouton 1 est cliqué
                FenetreSecondaire fenetre2 = new FenetreSecondaire("Fenêtre 2");
                fenetre2.setVisible(true);
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

    public static void main(String[] args) throws IOException, FontFormatException {
        // Création et affichage de la fenêtre principale
        FenetreGraphique fenetre1 = new FenetreGraphique();
        fenetre1.setVisible(true);
    }
}

class FenetreSecondaire extends JFrame {
    public FenetreSecondaire(String title) {
        // Configuration de la fenêtre secondaire
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
    }
}
