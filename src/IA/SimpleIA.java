package IA;

import Modele.*;
import Global.*;

import java.util.ArrayList;
import java.util.Random;

public class SimpleIA implements IA {
    Random rand = new Random();
    Plateau p;
    public SimpleIA(Plateau p) {
        this.p = p;
    }

    @Override
    public Coup jouer() {
        int[][] g = p.grille();
        ArrayList<Coup> coupsPossibles = new ArrayList<>();
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[i].length; j++)
                if (g[i][j] == Config.GOUFRE)
                    coupsPossibles.add(new Coup(i, j));
        return coupsPossibles.get(rand.nextInt(coupsPossibles.size()));
    }
}
