import java.util.ArrayList;
import java.util.Random;

public class SimpleIA implements IA {
    Random rand = new Random();
    ArrayList<ArrayList<Integer>> p;
    SimpleIA(Plateau p) {
        this.p = p.plateau;
    }

    @Override
    public Coup jouer() {
        int[][] pairs = new int[p.size() * p.get(0).size()][2]; // Déclaration et initialisation du tableau de paires d'entiers
        int index = 0; // Index pour parcourir le tableau de paires d'entiers
        for (int i = 0; i < p.size(); i++) {
            for (int j = 0; j < p.get(i).size(); j++) {

                int value = p.get(i).get(j);
                if (value == Config.GOUFRE) {
                    pairs[index][0] = i; // Stocke la valeur de i dans la première colonne de la paire
                    pairs[index][1] = j; // Stocke la valeur de j dans la deuxième colonne de la paire
                    index++; // Incrémente l'index du tableau de paires d'entiers
                }
            }

        }
        int x = pairs.length;
        Random rand = new Random();
        int randomNumber = rand.nextInt(x);
        return new Coup(pairs[randomNumber][0], pairs[randomNumber][1]);
    }
}
