package Hist;

import Global.Config;
import Modele.Coup;
import Modele.Plateau;

public class Element_pile_histo {
    Coup[] contours;
    Coup coup;

    Element_pile_histo(int x, int y, Plateau p) {
        this.coup = new Coup(x, y);
        this.contours = get_contour(p);
    }

    Element_pile_histo(Coup c, Coup[] cont) {
        this.coup = c;
        this.contours = cont;
    }

    public Coup[] get_contour(Plateau p) {
        int[][] plateau = p.grille();
        int row = p.lignes();
        int col = p.colonnes();
        Coup[] cont = new Coup[row];
        int x, y;
        for (int i = 0; i < row; i++) {
            x = i;
            y = col;
            for (int j = 0; j < col; j++) {
                if (plateau[i][j] == Config.VIDE) {
                    y = j;
                    break;
                }
            }
            cont[i] = new Coup(x, y);
        }
        return cont;
    }

    public Coup get_coup() { return coup; }

    public String get_save_string() {
        String temp = "";
        for (int i = 0; i < contours.length; i++) {
            temp += contours[i].get_x() + " " + contours[i].get_y() + " ";
        }
        return coup.get_x() + " " + coup.get_y() + " " + temp;
    }
}
