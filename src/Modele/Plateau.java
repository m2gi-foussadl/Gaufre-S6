package Modele;

import Global.Config;
import Hist.Historique;

import java.util.Arrays;

public class Plateau {
    int[][] plateau;
    int col;
    int row;
    int turnPlayer;
    boolean fini;
    Historique hist;

    public Plateau() {
        col = 5;
        row = 5;
        fini = false;
        turnPlayer = 1;
        hist = new Historique();
        plateau = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(plateau[i], Config.GOUFRE);
        }
    }

    public Plateau(int c, int r) {
        col = c;
        row = r;
        fini = false;
        turnPlayer = 1;
        plateau = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(plateau[i], Config.GOUFRE);
        }
    }

    public Plateau(String fichier) {
        hist = new Historique();
        this.hist.charger(fichier, this);
    }

    public void mange(Coup c) {

        if (c.x == 0 && c.y == 0)
            fini = true;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if ((i >= c.x) && (j >= c.y))
                    plateau[i][j] = Config.VIDE;
        //Stocker le coup et l'état de la gaufre après le coup
//        hist.ajouter(c, this);
        changeTurnPlayer();
    }

    public void changeTurnPlayer() {
        if (this.turnPlayer == 1) {
            this.turnPlayer = 2;
        } else if (this.turnPlayer == 2) {
            this.turnPlayer = 1;
        }
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

    public int getTurnPlayer() {
        return turnPlayer;
    }

    public int[][] copie() {
        int[][] newtab = new int[row][col];
        for (int i = 0; i < row; i++)
            newtab[i] = plateau[i].clone();

        return newtab;
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
