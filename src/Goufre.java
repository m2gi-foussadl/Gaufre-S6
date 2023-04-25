import IHM.FenetreGraphique;
import Modele.Plateau;

public class Goufre {
    public static void main(String[] args) {
        Plateau p = new Plateau(8, 8);
        try {
            FenetreGraphique mainFen = new FenetreGraphique(p);
            mainFen.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        if (args.length == 0)
//            p = new Plateau();
//        else if (args.length == 1)
//            p = new Plateau(args[0]);
//        else if (args.length == 2)
//            p = new Plateau(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//        else {
//            System.out.println("Usages: java Goufre <col> <row>");
//            System.out.println("        java Goufre <filename>");
//            return;
//        }

//        IA ia = new MoyenIA(p);
//        while (!p.estTermine()) {
//            Coup c = ia.jouer();
//            p.mange(c);
//            if (Config.DEBUG) {
//                System.out.println("Coup joué: " + c);
//                p.afficher();
//            }
//        }
    }
}
