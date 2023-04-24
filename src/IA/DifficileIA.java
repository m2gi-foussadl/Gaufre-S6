package IA;

import java.util.ArrayList;
import java.util.Arrays;

import Global.Config;
import Modele.*;

public class DifficileIA implements IA {
    Plateau p;

    DifficileIA(Plateau p) {
        this.p = p;
    }


    class Maillon {
        double valeur;
        int[][] plateau = new int[6][6];

        int nbfils;
        ArrayList<Maillon> filsMatrice;

        int coup_ligne;

        int coup_colone;

        boolean ordi; //savoir si c'est au tour du joueur ou de l'ordi

        public Maillon(int valeur, int[][] plat, boolean ordi) {
            this.valeur = valeur;
            this.plateau = plat;
            this.nbfils = 0;
            this.ordi = ordi;
            this.filsMatrice = new ArrayList<>();
        }

        public void ajouterFilsMatrice(int[][] plat, Maillon fils) {
            this.filsMatrice.add(fils);
            this.nbfils++;
            this.plateau = plat;
        }

        public boolean est_perdant() {
            return this.plateau[0][0] == Config.VIDE && !this.ordi;
        }

        public boolean est_gagnant() {
            return this.plateau[0][0] == Config.VIDE && this.ordi;
        }
    }

    public void jouercoup(int colone, int ligne, int[][] plateau) {
        for (int i = ligne; i < plateau.length; i++)
            for (int j = colone; j < plateau[0].length; j++)
                p.grille()[i][j] = Config.VIDE;
    }

    public void creer_arbre(Maillon m) {
        int[][] plateau = m.plateau;
        int nbfils = 0;
        double valtotal = 0.0;
        for (int i = 0; i < plateau.length; i++) {        //pour chaque coup possible
            if (plateau[i][0] == Config.VIDE)
                break;
            for (int j = 0; j < plateau.length; j++) {
                if (plateau[i][j] == Config.GOUFRE) {
                    if (!(i == 0 && j == 0)) { //tout les coup sauf coup 0.0
                        int[][] plateaufils = plateau.clone();
                        jouercoup(i, j, plateaufils);     // creer tableau du fils avec le coup jouer
                        Maillon racinefils = new Maillon(0, plateau, !m.ordi);
                        racinefils.coup_colone = i;
                        racinefils.coup_ligne = j;
                        m.ajouterFilsMatrice(plateaufils, racinefils); // ajoute le fils au maillon
                        creer_arbre(m.filsMatrice.get(nbfils));
                        valtotal += racinefils.valeur;
                        nbfils++;
                    }
                } else
                    break;
            }
        }
        if (m.est_perdant())
            m.valeur = 0.0;
        else {
            if (m.est_gagnant())
                m.valeur = 1.0;
            else
                m.valeur = valtotal / nbfils;
        }
    }

    @Override
    public Coup jouer() {
        int[][] plateau = p.grille();
        Maillon racine = new Maillon(0, plateau, true); //ordi qui commence à jouer
        creer_arbre(racine);
        Maillon maxfils = racine.filsMatrice.get(0);
        for (Maillon fils : racine.filsMatrice) {
            if (maxfils.valeur < fils.valeur)
                maxfils = fils;
        }

        return new Coup(maxfils.coup_ligne, maxfils.coup_colone);

    }

}
