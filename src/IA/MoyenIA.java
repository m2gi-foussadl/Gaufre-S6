package IA;

import java.util.ArrayList;
import java.util.Random;
import Modele.*;
import Global.*;

public class MoyenIA implements IA {
    Random rand = new Random();
    Plateau p;
    public MoyenIA(Plateau p) {
        this.p = p;
    }

    @Override
    public Coup jouer() {
        int[][] g = p.grille();
        if (g[0][1] == Config.GOUFRE && g[1][0] == Config.VIDE)
            return new Coup(0, 1);
        else if (g[1][0] == Config.GOUFRE && g[0][1] == Config.VIDE)
            return new Coup(1, 0);
        else {
            ArrayList<Coup> coupsPossibles = new ArrayList<>();
            Coup c0, c1 = null, c2 = null;
            for (int i = 0; i < g.length; i++)
                for (int j = 0; j < g[i].length; j++)
                    if (g[i][j] == Config.GOUFRE) {
                        c0 = new Coup(i, j);
                        if (i == 0 && j == 1)
                            c1 = c0;
                        else if (i == 1 && j == 0)
                            c2 = c0;
                        coupsPossibles.add(c0);
                    }
            if (coupsPossibles.size() > 1)
                coupsPossibles.remove(0);
            if (coupsPossibles.size() > 1 && c1 != null)
                coupsPossibles.remove(c1);
            if (coupsPossibles.size() > 1 && c2 != null)
                coupsPossibles.remove(c2);
            return coupsPossibles.get(rand.nextInt(coupsPossibles.size()));
        }
    }
}
