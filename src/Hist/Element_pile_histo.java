package Hist;

import Global.Config;
import Modele.*;


public class Element_pile_histo {
    Coup[] contours;
    Coup coup_actuel;

    Element_pile_histo(int x, int y, Plateau p) {
        this.coup_actuel = new Coup(x, y);
        this.contours = get_contour(p);
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
}
