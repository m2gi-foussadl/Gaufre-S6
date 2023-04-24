import Modele.*;
import IA.*;
import Global.*;

public class Goufre {
    public static void main(String[] args) {
        Plateau p;
        if (args.length == 0)
            p = new Plateau();
        else if (args.length == 1)
            p = new Plateau(args[0]);
        else if (args.length == 2)
            p = new Plateau(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        else {
            System.out.println("Usages: java Goufre");
            System.out.println("        java Goufre <filename>");
            System.out.println("        java Goufre <col> <row>");
            return;
        }

        IA ia = new MoyenIA(p);
        while (!p.estTermine()) {
            Coup c = ia.jouer();
            p.mange(c);
            if (Config.DEBUG) {
                System.out.println("Coup joué: " + c);
                p.afficher();
            }
        }
    }
}
