import java.io.BufferedReader;
import java.io.FileReader;
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
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                plateau[i][j]=Config.GOUFRE;
            }

        }
    }//

    public Plateau(int c, int r) {
        col = c;
        row = r;
        fini = false;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                plateau[i][j]=Config.GOUFRE;
            }

        }
    }

    public Plateau(String fichier) throws Exception{
        super();


    }

    public void mange(int c, int r) {
        if (c == 0 && r == 0) {
            //match fini
            fini = true;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i >= r) && (j >= c)) {
                    plateau[i][j]= Config.VIDE;
                }
            }
        }

    }

    public boolean estTermine() {
        return fini;
    }
}
