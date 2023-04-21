import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Plateau {
    ArrayList<ArrayList<Integer>> plateau;
    int col;
    int row;

    boolean fini;

    public Plateau() {
        col = 5;
        row = 5;
        fini = false;
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> cols = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                cols.add(Config.GOUFRE);
            }
            plateau.add(cols);
        }
    }//

    public Plateau(int c, int r) {
        col = c;
        row = r;
        fini = false;
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> cols = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                cols.add(Config.GOUFRE);
            }

            plateau.add(cols);
        }
    }

    public Plateau(String fichier) throws Exception{
        Scanner scn = new Scanner(fichier);
        while (scn.hasNextLine()){
            String line = scn.nextLine();
            String[] f_cols = line.split(" ");
            ArrayList<Integer> cols = new ArrayList<>();
            for(String c : f_cols){
                cols.add(Integer.parseInt(c));
            }
            plateau.add(cols);
        }
        row = plateau.size();
        col = plateau.get(0).size();
    }

    public void mange(int c, int r) {
        if (c == 0 && r == 0) {
            //match fini
            fini = true;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i >= r) && (j >= c)) {
                    plateau.get(i).set(j, Config.VIDE);
                }
            }
        }

    }

    public boolean estTermine() {
        return fini;
    }
}
