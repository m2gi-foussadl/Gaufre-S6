package Modele;

import Global.Config;

import java.util.*;

public class Plateau {
    int[][] plateau;
    int col;
    int row;

    boolean fini;

    public Plateau() {
        col = 5;
        row = 5;
        fini = false;

        plateau = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(plateau[i], Config.GOUFRE);
        }
    }

    public Plateau(int c, int r) {
        col = c;
        row = r;
        fini = false;

        plateau = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(plateau[i], Config.GOUFRE);
        }
    }

    public Plateau(String fichier) {
        super();
    }

    public void mange(Coup c) {
        if (c.x == 0 && c.y == 0)
            fini = true;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if ((i >= c.x) && (j >= c.y))
                    plateau[i][j]= Config.VIDE;
    }

    public boolean estTermine() {
        return fini;
    }

    public int lignes() {
        return row;
    }

    public int colonnes() {
        return col;
    }

    public int[][] grille() {
        return plateau;
    }

    public void afficher() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
    }
}
