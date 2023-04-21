package IHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PlateauGraphique extends JComponent {

    Image img;

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
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        int largeur = getSize().width;
        int hauteur = getSize().height;

        int nbX = largeur / 50;
        int nbY = hauteur / 50;

        for(int i = 0; i < nbX; i++) {
            for(int j = 0; j < nbY; j++) {
                drawable.drawImage(img, i * 50, j * 50, 50, 50, null);
            }
        }
    }
}


