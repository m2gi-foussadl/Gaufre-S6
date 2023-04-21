package IHM;

import modele.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PlateauGraphique extends JComponent {

    Image img;

    Plateau plateau;

    public PlateauGraphique() {
        InputStream in = null;
        try {
            in = new FileInputStream("Mur.png");
            img = ImageIO.read(in);
        } catch (FileNotFoundException e) {
            System.out.println("Lol");
        } catch (Exception e) {
            System.out.println("J'y arrive po");
        }

        plateau = new Plateau();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        int taille = Math.min(getSize().width, getSize().height);

        int tailleCases = taille / plateau.Lignes();

        for(int i = 0; i < plateau.Colonnes(); i++) {
            for(int j = 0; j < plateau.Lignes(); j++) {
                drawable.drawImage(img, i * tailleCases, j * tailleCases, tailleCases, tailleCases, null);
            }
        }
    }
}


